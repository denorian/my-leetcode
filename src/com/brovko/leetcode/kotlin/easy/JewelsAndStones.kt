package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JewelsAndStones {
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val symbols = jewels.toSet()
        var count = 0;
        stones.toList()
            .forEach {
                if (symbols.contains(it)) count++
            }

        return count
    }

    @Test
    fun test1() {
        assertEquals(3, numJewelsInStones(jewels = "aA", stones = "aAAbbbb"))
    }

    @Test
    fun test2() {
        assertEquals(0, numJewelsInStones(jewels = "z", stones = "ZZ"))
    }
}