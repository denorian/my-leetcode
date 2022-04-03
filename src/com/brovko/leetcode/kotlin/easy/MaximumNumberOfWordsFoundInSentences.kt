package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfWordsFoundInSentences {
    /**
    A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
    You are given an array of strings sentences, where each sentences[i] represents a single sentence.
    Return the maximum number of words that appear in a single sentence.
     */
    fun mostWordsFound(sentences: Array<String>): Int {
        var res = 0;
        for (s in sentences) {
            val count = s.filter { it == ' ' }.count()
            if (res < count)
                res = count
        }

        return res + 1
    }

    @Test
    fun test1() {
        val strings = arrayOf(
            "alice and bob love leetcode",
            "i think so too",
            "this is great thanks very much"
        )
        assertEquals(6, mostWordsFound(strings))
    }

    @Test
    fun test2() {
        val strings = arrayOf(
            "please wait",
            "continue to fight",
            "continue to win"
        )
        assertEquals(3, mostWordsFound(strings))
    }
}