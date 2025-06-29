package org.simonolander.horloge.model

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import java.util.UUID
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

data class Beat(
    val id: String,
    val sound: Sound,
    val period: Duration,
    val delay: Duration,
    val volume: Double,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcel.readParcelable(
                Sound::class.java.classLoader,
                Sound::class.java,
            )!!
        } else {
            @Suppress("DEPRECATION")
            parcel.readParcelable(Sound::class.java.classLoader)!!
        },
        parcel.readLong().milliseconds,
        parcel.readLong().milliseconds,
        parcel.readDouble(),
    )

    override fun writeToParcel(
        parcel: Parcel,
        flags: Int,
    ) {
        parcel.writeString(id)
        parcel.writeParcelable(sound, flags)
        parcel.writeLong(period.inWholeMilliseconds)
        parcel.writeLong(delay.inWholeMilliseconds)
        parcel.writeDouble(volume)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Beat> {
        override fun createFromParcel(parcel: Parcel): Beat = Beat(parcel)

        override fun newArray(size: Int): Array<Beat?> = arrayOfNulls(size)

        fun randomId() = UUID.randomUUID().toString()
    }
}
