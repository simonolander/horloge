package org.simonolander.horloge.model

import android.os.Parcel
import android.os.Parcelable
import org.simonolander.horloge.R

data class Sound(
    val name: String,
    val resourceId: Int,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(resourceId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Sound> {

        val ALL = listOf(
            Sound("D 1", R.raw.kyster__low_d_117720),
            Sound("D\u266f 1", R.raw.kyster__low_d_sharp_117719),
            Sound("E 1", R.raw.kyster__e_117714),
            Sound("F 1", R.raw.kyster__f_117716),
            Sound("F\u266f 1", R.raw.kyster__f_sharp_117715),
            Sound("G 1", R.raw.kyster__g_117718),
            Sound("G\u266f 1", R.raw.kyster__g_sharp_117717),
            Sound("A 1", R.raw.kyster__a_117708),
            Sound("A\u266f 1", R.raw.kyster__a_sharp_117707),
            Sound("B 1", R.raw.kyster__b_117709),
            Sound("C 2", R.raw.kyster__c_117711),
            Sound("C\u266f 2", R.raw.kyster__c_sharp_117710),
            Sound("D 2", R.raw.kyster__d_117713),
            Sound("D\u266f 2", R.raw.kyster__d_sharp_117712),
            Sound("E 2", R.raw.kyster__1_oct_e_117689),
            Sound("F 2", R.raw.kyster__1_oct_f_117691),
            Sound("F\u266f 2", R.raw.kyster__1_oct_f_sharp_117690),
            Sound("G 2", R.raw.kyster__1_oct_g_117693),
            Sound("G\u266f 2", R.raw.kyster__1_oct_g_sharp_117692),
            Sound("A 2", R.raw.kyster__1_oct_a_117683),
            Sound("A\u266f 2", R.raw.kyster__1_oct_a_sharp_117682),
            Sound("B 2", R.raw.kyster__1_oct_b_117684),
            Sound("C 3", R.raw.kyster__1_oct_c_117686),
            Sound("C\u266f 3", R.raw.kyster__1_oct_c_sharp_117685),
            Sound("D 3", R.raw.kyster__1_oct_d_117688),
            Sound("D\u266f 3", R.raw.kyster__1_oct_d_sharp_117687),
            Sound("E 3", R.raw.kyster__2_oct_e_117701),
            Sound("F 3", R.raw.kyster__2_oct_f_117703),
            Sound("F\u266f 3", R.raw.kyster__2_oct_f_sharp_117702),
            Sound("G 3", R.raw.kyster__2_oct_g_117705),
            Sound("G\u266f 3", R.raw.kyster__2_oct_g_sharp_117704),
            Sound("A 3", R.raw.kyster__2_oct_a_117695),
            Sound("A\u266f 3", R.raw.kyster__2_oct_a_sharp_117694),
            Sound("B 3", R.raw.kyster__2_oct_b_117696),
            Sound("C 4", R.raw.kyster__2_oct_c_117852),
            Sound("C\u266f 4", R.raw.kyster__2_oct_c_117697),
            Sound("D 4", R.raw.kyster__2_oct_d_117700),
            Sound("D\u266f 4", R.raw.kyster__2_oct_d_sharp_117699),
            Sound("E 4", R.raw.kyster__3_oct_e_117706),
        )

        override fun createFromParcel(parcel: Parcel): Sound {
            return Sound(parcel)
        }

        override fun newArray(size: Int): Array<Sound?> {
            return arrayOfNulls(size)
        }
    }
}