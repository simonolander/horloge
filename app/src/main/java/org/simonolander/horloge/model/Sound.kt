package org.simonolander.horloge.model

import android.os.Parcel
import android.os.Parcelable
import org.simonolander.horloge.R

data class Sound(
    val name: String,
    val resourceId: Int,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!, parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(resourceId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Sound> {
        val D_1 = Sound("D 1", R.raw.kyster__low_d_117720)
        val D_SHARP_1 = Sound("D\u266f 1", R.raw.kyster__low_d_sharp_117719)
        val E_1 = Sound("E 1", R.raw.kyster__e_117714)
        val F_1 = Sound("F 1", R.raw.kyster__f_117716)
        val F_SHARP_1 = Sound("F\u266f 1", R.raw.kyster__f_sharp_117715)
        val G_1 = Sound("G 1", R.raw.kyster__g_117718)
        val G_SHARP_1 = Sound("G\u266f 1", R.raw.kyster__g_sharp_117717)
        val A_1 = Sound("A 1", R.raw.kyster__a_117708)
        val A_SHARP_1 = Sound("A\u266f 1", R.raw.kyster__a_sharp_117707)
        val B_1 = Sound("B 1", R.raw.kyster__b_117709)
        val C_2 = Sound("C 2", R.raw.kyster__c_117711)
        val C_SHARP_2 = Sound("C\u266f 2", R.raw.kyster__c_sharp_117710)
        val D_2 = Sound("D 2", R.raw.kyster__d_117713)
        val D_SHARP_2 = Sound("D\u266f 2", R.raw.kyster__d_sharp_117712)
        val E_2 = Sound("E 2", R.raw.kyster__1_oct_e_117689)
        val F_2 = Sound("F 2", R.raw.kyster__1_oct_f_117691)
        val F_SHARP_2 = Sound("F\u266f 2", R.raw.kyster__1_oct_f_sharp_117690)
        val G_2 = Sound("G 2", R.raw.kyster__1_oct_g_117693)
        val G_SHARP_2 = Sound("G\u266f 2", R.raw.kyster__1_oct_g_sharp_117692)
        val A_2 = Sound("A 2", R.raw.kyster__1_oct_a_117683)
        val A_SHARP_2 = Sound("A\u266f 2", R.raw.kyster__1_oct_a_sharp_117682)
        val B_2 = Sound("B 2", R.raw.kyster__1_oct_b_117684)
        val C_3 = Sound("C 3", R.raw.kyster__1_oct_c_117686)
        val C_SHARP_3 = Sound("C\u266f 3", R.raw.kyster__1_oct_c_sharp_117685)
        val D_3 = Sound("D 3", R.raw.kyster__1_oct_d_117688)
        val D_SHARP_3 = Sound("D\u266f 3", R.raw.kyster__1_oct_d_sharp_117687)
        val E_3 = Sound("E 3", R.raw.kyster__2_oct_e_117701)
        val F_3 = Sound("F 3", R.raw.kyster__2_oct_f_117703)
        val F_SHARP_3 = Sound("F\u266f 3", R.raw.kyster__2_oct_f_sharp_117702)
        val G_3 = Sound("G 3", R.raw.kyster__2_oct_g_117705)
        val G_SHARP_3 = Sound("G\u266f 3", R.raw.kyster__2_oct_g_sharp_117704)
        val A_3 = Sound("A 3", R.raw.kyster__2_oct_a_117695)
        val A_SHARP_3 = Sound("A\u266f 3", R.raw.kyster__2_oct_a_sharp_117694)
        val B_3 = Sound("B 3", R.raw.kyster__2_oct_b_117696)
        val C_4 = Sound("C 4", R.raw.kyster__2_oct_c_117852)
        val C_SHARP_4 = Sound("C\u266f 4", R.raw.kyster__2_oct_c_117697)
        val D_4 = Sound("D 4", R.raw.kyster__2_oct_d_117700)
        val D_SHARP_4 = Sound("D\u266f 4", R.raw.kyster__2_oct_d_sharp_117699)
        val E_4 = Sound("E 4", R.raw.kyster__3_oct_e_117706)

        val ALL = listOf(
            D_1,
            D_SHARP_1,
            E_1,
            F_1,
            F_SHARP_1,
            G_1,
            G_SHARP_1,
            A_1,
            A_SHARP_1,
            B_1,
            C_2,
            C_SHARP_2,
            D_2,
            D_SHARP_2,
            E_2,
            F_2,
            F_SHARP_2,
            G_2,
            G_SHARP_2,
            A_2,
            A_SHARP_2,
            B_2,
            C_3,
            C_SHARP_3,
            D_3,
            D_SHARP_3,
            E_3,
            F_3,
            F_SHARP_3,
            G_3,
            G_SHARP_3,
            A_3,
            A_SHARP_3,
            B_3,
            C_4,
            C_SHARP_4,
            D_4,
            D_SHARP_4,
            E_4,
        )

        operator fun get(name: String): Sound? {
            return ALL.find { it.name == name }
        }

        override fun createFromParcel(parcel: Parcel): Sound {
            return Sound(parcel)
        }

        override fun newArray(size: Int): Array<Sound?> {
            return arrayOfNulls(size)
        }
    }
}