package org.simonolander.horloge.model

import android.os.Parcel
import android.os.Parcelable
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

data class Beat(
    val interval: Duration,
    val resourceId: Int,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readLong().milliseconds,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(interval.inWholeMilliseconds)
        parcel.writeInt(resourceId)
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
