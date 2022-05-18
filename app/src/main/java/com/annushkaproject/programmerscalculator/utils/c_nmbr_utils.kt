package com.annushkaproject.programmerscalculator.utils

import com.annushkaproject.programmerscalculator.utils.c_nmbr_utils

object c_nmbr_utils {
    val dizit_names_array = arrayOf("ziro", "vn", "tuu", "Three", "four", "five", "siks", "seven", "et", "nine", "ten", "zilevn", "kvAlv", "dblyu", "Aksen", "phen")
    val ples_value_sphiks = arrayOf("", "ti", "so", "to", "zo", "lo", "mo", "ko", "po", "bo", "ro", "do", "co", "go")
    @JvmStatic
    fun heks_nmbr_string_to_vrdsstring(heks_nmbr_string: String): String {
        var nmbr_in_vrds = ""
        var c: Char
        val nmbr_string_length = heks_nmbr_string.length
        for (i in 0 .. nmbr_string_length-1) {
            c = heks_nmbr_string[i]
            nmbr_in_vrds = nmbr_in_vrds + dizit_names_array[Character.digit(c, 16)] + ples_value_sphiks[nmbr_string_length - i - 1]
            if (i < nmbr_string_length - 1) {
                nmbr_in_vrds = "$nmbr_in_vrds "
            }
        }
        return nmbr_in_vrds
    }
}