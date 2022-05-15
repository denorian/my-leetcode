package com.brovko.leetcode.kotlin.medium

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class Solution3Sum {
    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets.
     */

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val res: ArrayList<List<Int>> = ArrayList()

        for (i in 0 until nums.size) {
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(listOf(nums[i], nums[j], nums[k]))
                    j++

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++
                } else {
                    k--
                }
            }
        }

        return res
    }

    @Test
    fun test1(){
        assertContentEquals(
            listOf(listOf(-1,-1,2), listOf(-1,0,1)) ,
            threeSum(intArrayOf(-1,0,1,2,-1,-4))
        )
    }

    @Test
    fun test2(){
        assertContentEquals(
            listOf() ,
            threeSum(intArrayOf())
        )
    }


    @Test
    fun test3(){
        assertContentEquals(
            listOf() ,
            threeSum(intArrayOf(0))
        )
    }
}