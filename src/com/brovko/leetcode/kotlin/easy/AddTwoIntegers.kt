package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AddTwoIntegers {
    /**
     * Given two integers num1 and num2, return the sum of the two integers.
     */
    fun sum(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    @Test
    fun test1(){
        assertEquals(17, sum(12, 5))
    }

    @Test
    fun test2(){
        assertEquals(-6, sum(-10, 4))
    }
}