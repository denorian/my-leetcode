package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NumberOfGoodPairs {
    fun numIdenticalPairs(nums: IntArray): Int {
        var res = 0
        val temp = IntArray(101)
        nums.forEach {
            num -> res += temp[num]++
        }

        return res
    }

    @Test
    fun test1() {
        Assertions.assertEquals(4, numIdenticalPairs(intArrayOf(1,2,3,1,1,3)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(6, numIdenticalPairs(intArrayOf(1,1,1,1)))
    }
    @Test
    fun test3() {
        Assertions.assertEquals(0, numIdenticalPairs(intArrayOf(1,2,3)))
    }
}