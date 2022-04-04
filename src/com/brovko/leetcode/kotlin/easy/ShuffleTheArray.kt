package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ShuffleTheArray {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        var res = IntArray(0)

        for (i in 0 until n) {
            res += nums[i]
            res += nums[i + n]
        }

        return res
    }

    @Test
    fun test1() {
        assertArrayEquals(intArrayOf(2,3,5,4,1,7), shuffle(intArrayOf(2,5,1,3,4,7), 3))
    }

    @Test
    fun test2() {
        assertArrayEquals(intArrayOf(1,4,2,3,3,2,4,1), shuffle(intArrayOf(1,2,3,4,4,3,2,1), 4))
    }

    @Test
    fun test3() {
        assertArrayEquals(intArrayOf(1,2,1,2), shuffle(intArrayOf(1,1,2,2), 2))
    }
}