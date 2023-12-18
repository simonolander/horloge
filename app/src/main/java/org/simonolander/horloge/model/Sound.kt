package org.simonolander.horloge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sound(
    val id: String,
    val name: String,
    val resourceId: Int,
    val group: String,
) : Parcelable