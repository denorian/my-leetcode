package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShuffleString {
    /** 1528. Shuffle String
     *  You are given a string s and an integer array indices of the same length.
     *  The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
     *  Return the shuffled string.
     */
    fun restoreString(s: String, indices: IntArray): String {
        val chars = CharArray(indices.size)

        for (i in 0 until indices.size)
            chars[indices[i]] = s.get(i)

        return String(chars)
    }

    @Test
    fun test1() {
        assertEquals( "leetcode", restoreString("codeleet", intArrayOf(4,5,6,7,0,2,1,3)))
    }

    @Test
    fun test2() {
        assertEquals( "abc", restoreString( "abc", intArrayOf(0,1,2)))
    }
}