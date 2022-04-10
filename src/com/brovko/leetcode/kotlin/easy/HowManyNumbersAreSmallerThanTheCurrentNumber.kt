package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class HowManyNumbersAreSmallerThanTheCurrentNumber {
    /** 1365. How Many Numbers Are Smaller Than the Current Number
     * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
     * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
     * Return the answer in an array.
     */

    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val numCountMap = HashMap<Int, Int>()
        val res = IntArray(nums.size)
        val sortedNums = nums.clone();
        sortedNums.sort()

        for (i in sortedNums.size - 1 downTo   0 )
            numCountMap[sortedNums[i]] = i

        for (i in 0 until nums.size)
            res[i] = numCountMap.get(nums[i])!!

        return res
    }

    @Test
    fun test1() {
        assertContentEquals(intArrayOf(4,0,1,1,3), smallerNumbersThanCurrent(intArrayOf(8,1,2,2,3)))
    }

    @Test
    fun test2() {
        assertContentEquals(intArrayOf(2,1,0,3), smallerNumbersThanCurrent(intArrayOf(6,5,4,8)))
    }

    @Test
    fun test3() {
        assertContentEquals(intArrayOf(0,0,0,0), smallerNumbersThanCurrent(intArrayOf(7,7,7,7)))
    }
}
