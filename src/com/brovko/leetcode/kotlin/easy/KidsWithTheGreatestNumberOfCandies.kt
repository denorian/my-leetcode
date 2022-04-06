package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class KidsWithTheGreatestNumberOfCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val max = candies.maxOrNull()
        val resList = ArrayList<Boolean>(candies.size)

        for (candy in candies) {
            resList.add(candy + extraCandies > max!!)
        }

        return resList
    }

    @Test
    fun test1() {
        assertContentEquals(listOf(true,true,true,false,true), kidsWithCandies(intArrayOf(2,3,5,1,3), 3))
    }

    @Test
    fun test2() {
        assertContentEquals(listOf(true,false,false,false,false), kidsWithCandies(intArrayOf(4,2,1,1,2), 1))
    }

    @Test
    fun test3() {
        assertContentEquals(listOf(true,false,true), kidsWithCandies(intArrayOf(12,1,12), 1))
    }
}