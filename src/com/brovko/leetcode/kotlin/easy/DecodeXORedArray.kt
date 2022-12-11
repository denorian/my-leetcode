package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class DecodeXORedArray {
    /**
     * 1720. Decode XORed Array
     * There is a hidden integer array arr that consists of n non-negative integers.
     * It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1].
     * For example, if arr = [1,0,2,1], then encoded = [1,2,3].
     * You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].
     * Return the original array arr. It can be proved that the answer exists and is unique.
     */
    fun decode(encoded: IntArray, first: Int): IntArray {
        val length = encoded.size
        val arr = IntArray(length + 1)
        arr[0] = first
        for (i in 0 until length ) {
            arr[i + 1] = arr[i] xor encoded[i]
        }

        return arr
    }

    @Test
    fun test1() {
        assertContentEquals(
            intArrayOf(1,0,2,1),
            decode(intArrayOf(1,2,3), 1)
        )
    }

    @Test
    fun test2() {
        assertContentEquals(
            intArrayOf(4,2,0,7,4),
            decode(intArrayOf(6,2,7,3), 4)
        )
    }
}