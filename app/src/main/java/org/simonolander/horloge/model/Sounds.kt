package org.simonolander.horloge.model

import org.simonolander.horloge.R

object Sounds {
    private val D_1 = Sound("D 1", R.raw.kyster__low_d_117720, "Nylon guitar")
    private val D_SHARP_1 = Sound("D\u266f 1", R.raw.kyster__low_d_sharp_117719, "Nylon guitar")
    private val E_1 = Sound("E 1", R.raw.kyster__e_117714, "Nylon guitar")
    private val F_1 = Sound("F 1", R.raw.kyster__f_117716, "Nylon guitar")
    private val F_SHARP_1 = Sound("F\u266f 1", R.raw.kyster__f_sharp_117715, "Nylon guitar")
    private val G_1 = Sound("G 1", R.raw.kyster__g_117718, "Nylon guitar")
    private val G_SHARP_1 = Sound("G\u266f 1", R.raw.kyster__g_sharp_117717, "Nylon guitar")
    private val A_1 = Sound("A 1", R.raw.kyster__a_117708, "Nylon guitar")
    private val A_SHARP_1 = Sound("A\u266f 1", R.raw.kyster__a_sharp_117707, "Nylon guitar")
    private val B_1 = Sound("B 1", R.raw.kyster__b_117709, "Nylon guitar")
    private val C_2 = Sound("C 2", R.raw.kyster__c_117711, "Nylon guitar")
    private val C_SHARP_2 = Sound("C\u266f 2", R.raw.kyster__c_sharp_117710, "Nylon guitar")
    private val D_2 = Sound("D 2", R.raw.kyster__d_117713, "Nylon guitar")
    private val D_SHARP_2 = Sound("D\u266f 2", R.raw.kyster__d_sharp_117712, "Nylon guitar")
    private val E_2 = Sound("E 2", R.raw.kyster__1_oct_e_117689, "Nylon guitar")
    private val F_2 = Sound("F 2", R.raw.kyster__1_oct_f_117691, "Nylon guitar")
    private val F_SHARP_2 = Sound("F\u266f 2", R.raw.kyster__1_oct_f_sharp_117690, "Nylon guitar")
    private val G_2 = Sound("G 2", R.raw.kyster__1_oct_g_117693, "Nylon guitar")
    private val G_SHARP_2 = Sound("G\u266f 2", R.raw.kyster__1_oct_g_sharp_117692, "Nylon guitar")
    private val A_2 = Sound("A 2", R.raw.kyster__1_oct_a_117683, "Nylon guitar")
    private val A_SHARP_2 = Sound("A\u266f 2", R.raw.kyster__1_oct_a_sharp_117682, "Nylon guitar")
    private val B_2 = Sound("B 2", R.raw.kyster__1_oct_b_117684, "Nylon guitar")
    private val C_3 = Sound("C 3", R.raw.kyster__1_oct_c_117686, "Nylon guitar")
    private val C_SHARP_3 = Sound("C\u266f 3", R.raw.kyster__1_oct_c_sharp_117685, "Nylon guitar")
    private val D_3 = Sound("D 3", R.raw.kyster__1_oct_d_117688, "Nylon guitar")
    private val D_SHARP_3 = Sound("D\u266f 3", R.raw.kyster__1_oct_d_sharp_117687, "Nylon guitar")
    private val E_3 = Sound("E 3", R.raw.kyster__2_oct_e_117701, "Nylon guitar")
    private val F_3 = Sound("F 3", R.raw.kyster__2_oct_f_117703, "Nylon guitar")
    private val F_SHARP_3 = Sound("F\u266f 3", R.raw.kyster__2_oct_f_sharp_117702, "Nylon guitar")
    private val G_3 = Sound("G 3", R.raw.kyster__2_oct_g_117705, "Nylon guitar")
    private val G_SHARP_3 = Sound("G\u266f 3", R.raw.kyster__2_oct_g_sharp_117704, "Nylon guitar")
    private val A_3 = Sound("A 3", R.raw.kyster__2_oct_a_117695, "Nylon guitar")
    private val A_SHARP_3 = Sound("A\u266f 3", R.raw.kyster__2_oct_a_sharp_117694, "Nylon guitar")
    private val B_3 = Sound("B 3", R.raw.kyster__2_oct_b_117696, "Nylon guitar")
    private val C_4 = Sound("C 4", R.raw.kyster__2_oct_c_117852, "Nylon guitar")
    private val C_SHARP_4 = Sound("C\u266f 4", R.raw.kyster__2_oct_c_117697, "Nylon guitar")
    private val D_4 = Sound("D 4", R.raw.kyster__2_oct_d_117700, "Nylon guitar")
    private val D_SHARP_4 = Sound("D\u266f 4", R.raw.kyster__2_oct_d_sharp_117699, "Nylon guitar")
    private val E_4 = Sound("E 4", R.raw.kyster__3_oct_e_117706, "Nylon guitar")

    private val BOXING_BELL = Sound("Boxing bell", R.raw.benboncan__boxing_bell, "Bells and gongs")
    private val BRASS_BOWL = Sound("Brass bowl", R.raw.benboncan__brass_bowl, "Bells and gongs")
    private val BRONZE_BELL_1 = Sound("Bronze bell 1", R.raw.benboncan__bronze_bell_1, "Bells and gongs")
    private val BRONZE_BELL_2 = Sound("Bronze bell 2", R.raw.benboncan__bronze_bell_2, "Bells and gongs")
    private val BRONZE_BELL_3 = Sound("Bronze bell 3", R.raw.benboncan__bronze_bell_3, "Bells and gongs")
    private val CLANG = Sound("Clang", R.raw.benboncan__clang, "Bells and gongs")
    private val GAS_BOTTLE = Sound("Gas bottle", R.raw.benboncan__gas_bottle, "Bells and gongs")
    private val GLASS_LID = Sound("Glass lid", R.raw.benboncan__glass_lid, "Bells and gongs")
    private val GLASS_LID_REVISITED = Sound("Glass lid revisited", R.raw.benboncan__glass_lid_revisited, "Bells and gongs")
    private val LARGE_CYMBAL_FELT = Sound("Large cymbal felt", R.raw.benboncan__large_cymbal_felt, "Bells and gongs")
    private val LARGE_CYMBAL_STICK = Sound("Large cymbal stick", R.raw.benboncan__large_cymbal_stick, "Bells and gongs")
    private val STAINLESS_STEEL_BOWL = Sound("Stainless steel bowl", R.raw.benboncan__stainless_steel_bowl, "Bells and gongs")
    private val STAINLESS_STEEL_BOWL_1 = Sound("Stainless steel bowl 1", R.raw.benboncan__stainless_steel_bowl_1, "Bells and gongs")
    private val STAINLESS_STEEL_BOWL_2 = Sound("Stainless steel bowl 2", R.raw.benboncan__stainless_steel_bowl_2, "Bells and gongs")
    private val STAINLESS_STEEL_BOWL_3 = Sound("Stainless steel bowl 3", R.raw.benboncan__stainless_steel_bowl_3, "Bells and gongs")
    private val STAINLESS_STEEL_BOWL_4 = Sound("Stainless steel bowl 4", R.raw.benboncan__stainless_steel_bowl_4, "Bells and gongs")
    private val STAINLESS_STEEL_LID_1 = Sound("Stainless steel lid 1", R.raw.benboncan__stainless_steel_lid_1, "Bells and gongs")
    private val STAINLESS_STEEL_LID_2 = Sound("Stainless steel lid 2", R.raw.benboncan__stainless_steel_lid_2, "Bells and gongs")
    private val STEEL_BAR = Sound("Steel bar", R.raw.benboncan__steel_bar, "Bells and gongs")
    private val STEEL_BELL = Sound("Steel bell", R.raw.benboncan__steel_bell, "Bells and gongs")

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
        BOXING_BELL,
        BRASS_BOWL,
        BRONZE_BELL_1,
        BRONZE_BELL_2,
        BRONZE_BELL_3,
        CLANG,
        GAS_BOTTLE,
        GLASS_LID,
        GLASS_LID_REVISITED,
        LARGE_CYMBAL_FELT,
        LARGE_CYMBAL_STICK,
        STAINLESS_STEEL_BOWL,
        STAINLESS_STEEL_BOWL_1,
        STAINLESS_STEEL_BOWL_2,
        STAINLESS_STEEL_BOWL_3,
        STAINLESS_STEEL_BOWL_4,
        STAINLESS_STEEL_LID_1,
        STAINLESS_STEEL_LID_2,
        STEEL_BAR,
        STEEL_BELL,
    )

    operator fun get(name: String): Sound? {
        return ALL.find { it.name == name }
    }
}