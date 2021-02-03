package com.udacity.shoestore

import androidx.databinding.InverseMethod

object ShoeSizeConverter {

    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(value: Double): String {
        return if (value > 0.0) value.toString() else ""
    }

    @JvmStatic fun stringToDouble(value: String): Double {
        return value.toDoubleOrNull() ?: 0.0
    }
}