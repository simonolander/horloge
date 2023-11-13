package org.simonolander.horloge.model

data class Rhythm(
    val name: String,
    val beats: List<Beat>,
) {
    companion object {
        val Empty = Rhythm("", emptyList())
    }
}
