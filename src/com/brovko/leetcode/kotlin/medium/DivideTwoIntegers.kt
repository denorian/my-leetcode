package com.brovko.leetcode.kotlin.medium

import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.test.assertEquals

class DivideTwoIntegers {
    /**
     * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
     * The integer division should truncate toward zero, which means losing its fractional part.
     * For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
     * Return the quotient after dividing dividend by divisor.
     * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1].
     * For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
     */
    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == 0) return 0
        if (divisor == 1) return dividend
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE

        var m = abs(dividend.toLong())
        val n = abs(divisor.toLong())

        var result = 0
        while (m >= n) {
            m -= n
            result++
        }

        return if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) result.inv() + 1 else result
    }

    @Test
    fun test1() {
        assertEquals(divide(10, 3), 3)
    }

    @Test
    fun test2() {
        assertEquals(divide(7, -3), -2)
    }

    @Test
    fun test3() {
        assertEquals(divide(0, 1), 0)
    }

    @Test
    fun test4() {
        assertEquals(divide(1, 1), 1)
    }

    @Test
    fun test5() {
        assertEquals(divide(2147483647,  1),  2147483647)
    }

    @Test
    fun test6() {
        assertEquals(divide(-2147483647,  2),  -1073741823)
    }
}