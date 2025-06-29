package org.simonolander.horloge.model

import org.simonolander.horloge.R

object Sounds {
    private val D_1 = Sound("27e2d655-36d1-4aca-9a32-06d77cf73650", "Guitar, D 1", R.raw.kyster__low_d_117720, "Nylon guitar")
    private val D_SHARP_1 =
        Sound("1d1a194f-a67a-46c3-8b5b-79c8bad6a68e", "Guitar, D\u266f 1", R.raw.kyster__low_d_sharp_117719, "Nylon guitar")
    private val E_1 = Sound("093aa527-703c-4c90-b92d-0af7db38d3bd", "Guitar, E 1", R.raw.kyster__e_117714, "Nylon guitar")
    private val F_1 = Sound("9ca65821-2784-469c-b8f6-51a0f7f8175a", "Guitar, F 1", R.raw.kyster__f_117716, "Nylon guitar")
    private val F_SHARP_1 = Sound("f9cbc318-d472-497b-a379-6168eee42eec", "Guitar, F\u266f 1", R.raw.kyster__f_sharp_117715, "Nylon guitar")
    private val G_1 = Sound("a8bc6dc2-9c21-4b87-b41c-735b14d1e888", "Guitar, G 1", R.raw.kyster__g_117718, "Nylon guitar")
    private val G_SHARP_1 = Sound("7740e31e-d8b8-4f61-84e1-24b0cd98c1aa", "Guitar, G\u266f 1", R.raw.kyster__g_sharp_117717, "Nylon guitar")
    private val A_1 = Sound("db7f0d77-e644-40fa-ac6e-1902af7bc966", "Guitar, A 1", R.raw.kyster__a_117708, "Nylon guitar")
    private val A_SHARP_1 = Sound("4ea408c1-f6f0-4c76-82d2-10805d2e10c7", "Guitar, A\u266f 1", R.raw.kyster__a_sharp_117707, "Nylon guitar")
    private val B_1 = Sound("cd7b2464-8c32-44e8-828b-c7edecc2af8a", "Guitar, B 1", R.raw.kyster__b_117709, "Nylon guitar")
    private val C_2 = Sound("0a1a6de6-08d7-465c-9ca1-9e1a27a56083", "Guitar, C 2", R.raw.kyster__c_117711, "Nylon guitar")
    private val C_SHARP_2 = Sound("cd021019-7fd5-46b2-a6e0-7714c4ba6e11", "Guitar, C\u266f 2", R.raw.kyster__c_sharp_117710, "Nylon guitar")
    private val D_2 = Sound("80cce35f-6c5c-4994-9efd-acd75dc23a16", "Guitar, D 2", R.raw.kyster__d_117713, "Nylon guitar")
    private val D_SHARP_2 = Sound("a3955058-f02c-4b96-9c6f-5f4c1b917230", "Guitar, D\u266f 2", R.raw.kyster__d_sharp_117712, "Nylon guitar")
    private val E_2 = Sound("9d03cc68-b090-4b60-9a07-ade528c5e21f", "Guitar, E 2", R.raw.kyster__1_oct_e_117689, "Nylon guitar")
    private val F_2 = Sound("5f37d15e-c2d1-400f-a3c3-b4e86a62f0f5", "Guitar, F 2", R.raw.kyster__1_oct_f_117691, "Nylon guitar")
    private val F_SHARP_2 =
        Sound("1b8c5c4a-450c-4af4-bfa4-225076a89f95", "Guitar, F\u266f 2", R.raw.kyster__1_oct_f_sharp_117690, "Nylon guitar")
    private val G_2 = Sound("e69697a9-ff2b-4b9f-85c2-d45b9f460b2a", "Guitar, G 2", R.raw.kyster__1_oct_g_117693, "Nylon guitar")
    private val G_SHARP_2 =
        Sound("f8608576-494c-4000-b7ee-153cc6de310f", "Guitar, G\u266f 2", R.raw.kyster__1_oct_g_sharp_117692, "Nylon guitar")
    private val A_2 = Sound("1dda5a68-3453-45ca-befa-ef2c47f74bec", "Guitar, A 2", R.raw.kyster__1_oct_a_117683, "Nylon guitar")
    private val A_SHARP_2 =
        Sound("cffef2a2-91f9-458d-b187-6ccce76cb36f", "Guitar, A\u266f 2", R.raw.kyster__1_oct_a_sharp_117682, "Nylon guitar")
    private val B_2 = Sound("3e10c99a-8c17-438f-ae9c-e91e405a1c6c", "Guitar, B 2", R.raw.kyster__1_oct_b_117684, "Nylon guitar")
    private val C_3 = Sound("24193231-a1ad-42d9-bd34-befd6cf0b435", "Guitar, C 3", R.raw.kyster__1_oct_c_117686, "Nylon guitar")
    private val C_SHARP_3 =
        Sound("fc318cee-56ae-4a60-8cf6-9d7cdccd770b", "Guitar, C\u266f 3", R.raw.kyster__1_oct_c_sharp_117685, "Nylon guitar")
    private val D_3 = Sound("df3d7e57-179c-4026-a981-44013782d5ee", "Guitar, D 3", R.raw.kyster__1_oct_d_117688, "Nylon guitar")
    private val D_SHARP_3 =
        Sound("e7bc6785-5525-4294-8a51-603ed7bd8ed6", "Guitar, D\u266f 3", R.raw.kyster__1_oct_d_sharp_117687, "Nylon guitar")
    private val E_3 = Sound("c8412162-438a-4fd8-99ea-46ed46f0c91b", "Guitar, E 3", R.raw.kyster__2_oct_e_117701, "Nylon guitar")
    private val F_3 = Sound("9163a810-4804-4650-a342-2b06a2af5292", "Guitar, F 3", R.raw.kyster__2_oct_f_117703, "Nylon guitar")
    private val F_SHARP_3 =
        Sound("97326879-e47c-43e8-847d-2a0147f9f120", "Guitar, F\u266f 3", R.raw.kyster__2_oct_f_sharp_117702, "Nylon guitar")
    private val G_3 = Sound("f2f8d254-1b39-4a6c-a060-66fd4dbbc7a7", "Guitar, G 3", R.raw.kyster__2_oct_g_117705, "Nylon guitar")
    private val G_SHARP_3 =
        Sound("3299695f-b341-422e-849d-c760fa3f50a0", "Guitar, G\u266f 3", R.raw.kyster__2_oct_g_sharp_117704, "Nylon guitar")
    private val A_3 = Sound("189a86b4-097c-4e15-bda2-2c2790ddffbd", "Guitar, A 3", R.raw.kyster__2_oct_a_117695, "Nylon guitar")
    private val A_SHARP_3 =
        Sound("7cbce269-1e68-4c03-b424-78bf0724fda1", "Guitar, A\u266f 3", R.raw.kyster__2_oct_a_sharp_117694, "Nylon guitar")
    private val B_3 = Sound("053dca40-4d96-452e-9cdc-140c52897c3d", "Guitar, B 3", R.raw.kyster__2_oct_b_117696, "Nylon guitar")
    private val C_4 = Sound("1b65e167-dc4c-45e7-bc04-be6b56c50cca", "Guitar, C 4", R.raw.kyster__2_oct_c_117852, "Nylon guitar")
    private val C_SHARP_4 = Sound("68338bcd-7b43-46f1-a61b-79b08f111d6d", "Guitar, C\u266f 4", R.raw.kyster__2_oct_c_117697, "Nylon guitar")
    private val D_4 = Sound("ae3b377a-45c8-4030-9d4b-f72bde0e0865", "Guitar, D 4", R.raw.kyster__2_oct_d_117700, "Nylon guitar")
    private val D_SHARP_4 =
        Sound("a14ab7c1-b8d4-4604-95cf-d8b3cfe35491", "Guitar, D\u266f 4", R.raw.kyster__2_oct_d_sharp_117699, "Nylon guitar")
    private val E_4 = Sound("4384b0b8-621d-4634-8f3f-ab4c44331669", "Guitar, E 4", R.raw.kyster__3_oct_e_117706, "Nylon guitar")

    private val BOXING_BELL = Sound("75c88625-5e70-4ced-977d-8034409efc25", "Boxing bell", R.raw.benboncan__boxing_bell, "Bells and gongs")
    private val BRASS_BOWL = Sound("96995f76-efff-4449-ac3a-45806bc191de", "Brass bowl", R.raw.benboncan__brass_bowl, "Bells and gongs")
    private val BRONZE_BELL_1 =
        Sound("0f68242e-9866-4886-99ea-5554e824405e", "Bronze bell 1", R.raw.benboncan__bronze_bell_1, "Bells and gongs")
    private val BRONZE_BELL_2 =
        Sound("1a84778c-74b2-4c20-a6b8-79e492923f73", "Bronze bell 2", R.raw.benboncan__bronze_bell_2, "Bells and gongs")
    private val BRONZE_BELL_3 =
        Sound("b4600654-4f77-43d8-90c2-aa20dc2b68fa", "Bronze bell 3", R.raw.benboncan__bronze_bell_3, "Bells and gongs")
    private val CLANG = Sound("42701644-d97e-4fc6-bf9b-9ecec71f637d", "Clang", R.raw.benboncan__clang, "Bells and gongs")
    private val GAS_BOTTLE = Sound("c75b5b6d-97c7-4a58-8113-cd3c52cc8a93", "Gas bottle", R.raw.benboncan__gas_bottle, "Bells and gongs")
    private val GLASS_LID = Sound("e46b0fd8-4ef5-450a-84d5-8a662b64c80e", "Glass lid", R.raw.benboncan__glass_lid, "Bells and gongs")
    private val GLASS_LID_REVISITED =
        Sound("62af64a7-d14f-4a91-bafa-44e54143d8b3", "Glass lid revisited", R.raw.benboncan__glass_lid_revisited, "Bells and gongs")
    private val LARGE_CYMBAL_FELT =
        Sound("65c90b43-4cc2-4abf-a538-7187b05ee08b", "Large cymbal felt", R.raw.benboncan__large_cymbal_felt, "Bells and gongs")
    private val LARGE_CYMBAL_STICK =
        Sound("574f95ca-cd7d-470f-91c6-e3389cec78ac", "Large cymbal stick", R.raw.benboncan__large_cymbal_stick, "Bells and gongs")
    private val STAINLESS_STEEL_BOWL =
        Sound("70d9cce7-630f-4421-8de7-b6927aa6c15b", "Stainless steel bowl", R.raw.benboncan__stainless_steel_bowl, "Bells and gongs")
    private val STAINLESS_STEEL_BOWL_1 =
        Sound("3cda6f26-52a1-496b-9bf8-22d0a3b33fcb", "Stainless steel bowl 1", R.raw.benboncan__stainless_steel_bowl_1, "Bells and gongs")
    private val STAINLESS_STEEL_BOWL_2 =
        Sound("5b18da27-5743-43ca-992c-b240e17106b9", "Stainless steel bowl 2", R.raw.benboncan__stainless_steel_bowl_2, "Bells and gongs")
    private val STAINLESS_STEEL_BOWL_3 =
        Sound("141dab9c-9d8b-40ed-915b-dfdacfc21190", "Stainless steel bowl 3", R.raw.benboncan__stainless_steel_bowl_3, "Bells and gongs")
    private val STAINLESS_STEEL_BOWL_4 =
        Sound("177153eb-e1fe-479c-b0d8-858213f46fe4", "Stainless steel bowl 4", R.raw.benboncan__stainless_steel_bowl_4, "Bells and gongs")
    private val STAINLESS_STEEL_LID_1 =
        Sound("ef683ea4-9244-485d-88bf-b97ee7aafe56", "Stainless steel lid 1", R.raw.benboncan__stainless_steel_lid_1, "Bells and gongs")
    private val STAINLESS_STEEL_LID_2 =
        Sound("5b67fd12-2acd-4519-a5d0-3f5618eaa3dd", "Stainless steel lid 2", R.raw.benboncan__stainless_steel_lid_2, "Bells and gongs")
    private val STEEL_BAR = Sound("4923434f-d71b-4138-80da-339cb26e3988", "Steel bar", R.raw.benboncan__steel_bar, "Bells and gongs")
    private val STEEL_BELL = Sound("0563e90b-84d6-4c14-85a7-a7f0c85ccc63", "Steel bell", R.raw.benboncan__steel_bell, "Bells and gongs")

    val ALL =
        listOf(
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

    operator fun get(id: String): Sound? = ALL.find { it.id == id }
}
