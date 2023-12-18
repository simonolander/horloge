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
            queries.upsertChime(chime.id, chime.name)
            chime.beats.forEach {
                queries.upsertBeat(
                    id = it.id,
                    chimeId = chime.id,
                    soundId = it.sound.id,
                    periodMs = it.period.inWholeMilliseconds,
                    delayMs = it.delay.inWholeMilliseconds,
                    volume = it.volume,
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
        val beats = chimesWithBeats.mapNotNull { toBeat(it) }
        return Chime(
            id = first.id,
            name = first.name,
            beats = beats,
        )
    }

    private fun toBeat(beats: GetChimesWithBeats): Beat? {
        val id = beats.id_ ?: return null
        val soundId = beats.sound_id ?: return null
        val periodMs = beats.period_ms ?: return null
        val delayMs = beats.delay_ms ?: return null
        val volume = beats.volume ?: return null
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

