package org.simonolander.horloge.infrastructure.db

import app.cash.sqldelight.coroutines.asFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.simonolander.horloge.infrastructure.db.chime.ChimeQueries
import org.simonolander.horloge.infrastructure.db.chime.GetChimesWithBeats
import org.simonolander.horloge.model.Beat
import org.simonolander.horloge.model.Chime
import org.simonolander.horloge.model.Sounds
import kotlin.time.Duration.Companion.milliseconds

class ChimeRepository(private val queries: ChimeQueries) {

    fun getChimes(): Flow<List<Chime>> {
        return queries.getChimesWithBeats().asFlow().map { query ->
            query.executeAsList().groupBy { it.id }.map { it.value }.map { toChime(it) }
        }
    }

    fun saveChime(chime: Chime) {
        queries.transaction {
            queries.upsertChime(chime.id, chime.name, chime.volume)
            chime.beats.forEachIndexed { index, beat ->
                queries.upsertBeat(
                    id = beat.id,
                    chimeId = chime.id,
                    soundId = beat.sound.id,
                    periodMs = beat.period.inWholeMilliseconds,
                    delayMs = beat.delay.inWholeMilliseconds,
                    volume = beat.volume,
                    ordinal = index.toLong(),
                )
            }
            queries.retainBeatsByIds(chime.id, chime.beats.map { it.id })
        }
    }

    fun deleteChime(chimeId: String) {
        queries.deleteChime(chimeId)
    }

    private fun toChime(chimesWithBeats: List<GetChimesWithBeats>): Chime {
        val first = chimesWithBeats.first()
        val beats = chimesWithBeats
            .sortedBy { it.ordinal }
            .mapNotNull { toBeat(it) }
        return Chime(
            id = first.id,
            name = first.name,
            beats = beats,
            volume = first.volume,
        )
    }

    private fun toBeat(beats: GetChimesWithBeats): Beat? {
        val id = beats.id_ ?: return null
        val soundId = beats.sound_id ?: return null
        val periodMs = beats.period_ms ?: return null
        val delayMs = beats.delay_ms ?: return null
        val volume = beats.volume_ ?: return null
        val sound = Sounds[soundId] ?: return null
        return Beat(
            id = id,
            sound = sound,
            period = periodMs.milliseconds,
            delay = delayMs.milliseconds,
            volume = volume,
        )
    }
}

