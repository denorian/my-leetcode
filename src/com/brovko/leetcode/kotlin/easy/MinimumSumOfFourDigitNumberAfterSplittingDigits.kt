package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class MinimumSumOfFourDigitNumberAfterSplittingDigits {
    /**
     * You are given a positive integer num consisting of exactly four digits.
     * Split num into two new integers new1 and new2 by using the digits found in num.
     * Leading zeros are allowed in new1 and new2, and all the digits found in num must be used.
     * For example, given num = 2932, you have the following digits: two 2's, one 9 and one 3.
     * Some of the possible pairs [new1, new2] are [22, 93], [23, 92], [223, 9] and [2, 329].
     * Return the minimum possible sum of new1 and new2.
     */
    fun minimumSum(num: Int): Int {
        val ch = num.toString().toCharArray()
        Arrays.sort(ch);

        return (ch[0] - '0') * 10 + (ch[2] - '0') + (ch[1] - '0') * 10 + (ch[3] - '0')
    }

    @Test
    fun test1() {
        assertEquals(52, minimumSum(2932))
    }

    @Test
    fun test2() {
        assertEquals(13, minimumSum(4009))
    }
}