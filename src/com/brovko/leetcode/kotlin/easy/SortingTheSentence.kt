package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SortingTheSentence {
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