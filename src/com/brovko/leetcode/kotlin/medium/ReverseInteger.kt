package com.brovko.leetcode.kotlin.medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ReverseInteger {
    /**
     * Given a signed 32-bit integer x, return x with its digits reversed.
     * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     */
    fun reverse(x: Int): Int {
        var res: Long = 0
        var tempX = Math.abs(x)

        while (tempX > 0) {
            val temp = tempX % 10;
            tempX /= 10
            res = 10 * res + temp
        }

        if(res <= Integer.MIN_VALUE || res >= Integer.MAX_VALUE - 1)
            return 0

        return if ( x < 0 ) -res.toInt() else res.toInt()
    }

    @Test
    fun test1(){
        assertEquals(321, reverse(123))
    }

    @Test
    fun test2(){
        assertEquals(-321, reverse(-123))
    }

    @Test
    fun test3(){
        assertEquals(21, reverse(120))
    }

    @Test
    fun test4(){
        assertEquals(0, reverse(1534236469))
    }

    @Test
    fun test5(){
        assertEquals(0, reverse(-2147483648))
    }

    @Test
    fun test7(){
        assertEquals(2147483641, reverse(1463847412))
    }
}