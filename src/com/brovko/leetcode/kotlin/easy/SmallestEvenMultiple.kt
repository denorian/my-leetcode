package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SmallestEvenMultiple {
    /**
     * Given a positive integer n, return the smallest positive integer that is a multiple of both 2 and n.
     */
    fun smallestEvenMultiple(n: Int): Int {
        return if(n % 2 == 0 ) { n } else { n * 2 }
    }

    @Test
    fun test1() {
       assertEquals(10 , smallestEvenMultiple(5))
    }

    @Test
    fun test2() {
       assertEquals(6 , smallestEvenMultiple(6))
    }
}