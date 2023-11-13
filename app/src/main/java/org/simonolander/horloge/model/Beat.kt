package org.simonolander.horloge.model

import android.os.Parcel
import android.os.Parcelable
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

data class Beat(
    val sound: Sound,
    val period: Duration,
    val delay: Duration,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Sound::class.java.classLoader)!!,
        parcel.readLong().milliseconds,
        parcel.readLong().milliseconds,
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(sound, flags)
        parcel.writeLong(period.inWholeMilliseconds)
        parcel.writeLong(delay.inWholeMilliseconds)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Beat> {
        override fun createFromParcel(parcel: Parcel): Beat {
            return Beat(parcel)
        }

        override fun newArray(size: Int): Array<Beat?> {
            return arrayOfNulls(size)
        }
    }
}
