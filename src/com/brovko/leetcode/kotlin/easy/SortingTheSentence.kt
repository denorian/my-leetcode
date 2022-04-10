package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SortingTheSentence {
    /**
    A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
    Each word consists of lowercase and uppercase English letters.
    A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.
    For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
    Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.
    */
    fun sortSentence(s: String): String {
        return s.split(" ")
            .stream()
            .sorted { a, b -> a.get(a.length - 1) - b.get(b.length - 1) }
            .map { it.substring(0, it.length - 1) }
            .toArray()
            .joinToString(" ")
    }

    fun firstSolution(s: String): String {
        val splited = s.split(" ")
        val resArr = Array(splited.size) { "" }

        for (s in splited) {
            resArr[s.get(s.length - 1) - '0' - 1] = s.substring(0, s.length - 1)
        }

        return resArr.joinToString(" ")
    }

    @Test
    fun test1() {
        assertEquals("This is a sentence", sortSentence("is2 sentence4 This1 a3"))
    }

    @Test
    fun test2() {
        assertEquals( "Me Myself and I", sortSentence("Myself2 Me1 I4 and3"))
    }
}