package org.simonolander.horloge.model

import java.util.UUID

data class Chime(
    val id: String,
    val name: String,
    val beats: List<Beat>,
) {
    companion object {
        fun randomId() = UUID.randomUUID().toString()
    }
}
