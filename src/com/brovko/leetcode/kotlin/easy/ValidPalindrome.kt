package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertTrue

class ValidPalindrome {
    /**
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
     * non-alphanumeric characters, it reads the same forward and backward.
     * Alphanumeric characters include letters and numbers.
     * Given a string s, return true if it is a palindrome, or false otherwise.
     */

    fun isPalindrome(s: String): Boolean {
        val arr = s.lowercase()
            .chars()
            .filter { i -> (i in 97..122) || (i in 48..57) }
            .toArray()

        val revers = arr.copyOf()
        revers.reverse()

        return arr.contentEquals(revers)
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "A man, a plan, a canal: Panama",
        " "
    ])
    fun test1(src: String) {
       assertTrue(isPalindrome(src))
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "0P",
        "ABBVA",
        "race a car"
    ])
    fun test2(src: String) {
        assertFalse(isPalindrome(src))
    }
}