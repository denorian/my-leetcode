package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class ConvertTheTemperature {
    /**
    You are given a non-negative floating point number rounded to two decimal places celsius, that denotes the temperature in Celsius.
    You should convert Celsius into Kelvin and Fahrenheit and return it as an array ans = [kelvin, fahrenheit].
    Return the array ans. Answers within 10-5 of the actual answer will be accepted.
     */
    fun convertTemperature(celsius: Double): DoubleArray {
        return doubleArrayOf(
            celsius + 273.15,
            celsius * 1.80 + 32.00
        )
    }

    @Test
    fun test1() {
        assertContentEquals(
            doubleArrayOf(309.65000, 97.70000),
            convertTemperature(36.50)
        )
    }

    @Test
    fun test2() {
        assertContentEquals(
            doubleArrayOf(395.26000, 251.79800),
            convertTemperature(122.11)
        )
    }
}
