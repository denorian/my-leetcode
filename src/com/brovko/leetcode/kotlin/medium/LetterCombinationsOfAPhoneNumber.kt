package com.brovko.leetcode.kotlin.medium

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertTrue

class LetterCombinationsOfAPhoneNumber {
    /**
     * Given a string containing digits from 2-9 inclusive,
     * return all possible letter combinations that the number could represent. Return the answer in any order.
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * Note that 1 does not map to any letters.
     */

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList();

        val letters = arrayOf(
            charArrayOf('a', 'b', 'c'),
            charArrayOf('d', 'e', 'f'),
            charArrayOf('g', 'h', 'i'),
            charArrayOf('j', 'k', 'l'),
            charArrayOf('m', 'n', 'o'),
            charArrayOf('p', 'q', 'r', 's'),
            charArrayOf('t', 'u', 'v'),
            charArrayOf('w', 'x', 'y', 'z')
        )

        var current= ArrayList<String>(digits.length * 3)
        current.add("")

        for (digit in digits) {
            val temp = ArrayList<String>()

            for (ch in letters.get(digit -'2')) {
                for (s in current) {
                    temp.add(s + ch.toString())
                }
            }

            current = temp
        }

        return current
    }

    @Test
    fun test1() {
        val res = listOf("ad","ae","af","bd","be","bf","cd","ce","cf")

        assertTrue(
            letterCombinations("23")
                .stream()
                .allMatch{ t -> res.contains(t)}
        )
    }

    @Test
    fun test2() {
        assertContentEquals(emptyList(), letterCombinations(""))
    }

    @Test
    fun test3() {
        assertContentEquals(listOf("a","b","c"), letterCombinations("2"))
    }
}