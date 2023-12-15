package org.simonolander.horloge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Chime(
    val id: String,
    val name: String,
    val beats: List<Beat>,
) : Parcelable {
    companion object {
        fun randomId() = UUID.randomUUID().toString()
    }
}
