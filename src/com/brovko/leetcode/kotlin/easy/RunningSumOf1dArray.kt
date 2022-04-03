package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RunningSumOf1dArray {
    /**
        Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
        Return the running sum of nums.
     */
    fun runningSum(nums: IntArray): IntArray {
        for (i in 1 ..nums.size - 1)
            nums[i]  = nums[i] + nums[i - 1]

        return nums
    }

    @Test
    fun test1() {
        assertArrayEquals(intArrayOf(1,2,3,4),  runningSum(intArrayOf(1,1,1,1)))
    }

    @Test
    fun test2() {
        assertArrayEquals(intArrayOf(1,3,6,10),  runningSum(intArrayOf(1,2,3,4)))
    }
}