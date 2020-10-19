package com.kelompoksatu.sistempakardurian.util

object Utils {

    fun generateRandomInt(digits: Int): String {
        try {
            val str = StringBuilder()
            for (i in 0 until digits) {
                str.append((0..9).random())
            }
            return str.toString()
        } catch (e: Exception) {
            return ""
        }
    }

}