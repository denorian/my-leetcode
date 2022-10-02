package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SubtractTheProductAndSumOfDigitsOfInteger {
    /**
     * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
     */
    fun subtractProductAndSum(n: Int): Int {
        var temp = n
        var prod = 1
        var summ = 0

        while (temp > 0) {
            val digit = temp % 10
            prod *= digit
            summ += digit
            temp /= 10
        }

        return prod - summ
    }

    @Test
    fun test1() {
        assertEquals(15, subtractProductAndSum(234))
    }

    @Test
    fun test2() {
        assertEquals(21, subtractProductAndSum(4421))
    }
}