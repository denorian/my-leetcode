package com.brovko.leetcode.kotlin.medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class CountSortedVowelStrings {
    /**
     * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u)
     * and are lexicographically sorted.
     * A string s is lexicographically sorted if for all valid i, s[i]
     * is the same as or comes before s[i+1] in the alphabet.
     */
    var vowels = listOf('a', 'e', 'i', 'o', 'u')
    var result = 0

    fun countVowelStrings(n: Int): Int {
        countVowelStringsRecursively(n, 0, StringBuilder())

        return result
    }

    fun countVowelStrings2(n: Int): Int {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24
    }

    fun countVowelStringsRecursively(n: Int, start: Int, sb: StringBuilder) {
        if(sb.length == n){
            result++
        } else {
            for (i in start ..   4) {
                sb.append(vowels[i])

                countVowelStringsRecursively(n, i, sb)
                sb.deleteCharAt(sb.length - 1);
            }
        }
    }

    @Test
    fun test1(){
        assertEquals(5, countVowelStrings(1))
    }

    @Test
    fun test2(){
        assertEquals(15, countVowelStrings(2))
    }

    @Test
    fun test3(){
        assertEquals(35, countVowelStrings(3))
    }

    @Test
    fun test4(){
        assertEquals(70, countVowelStrings(4))
    }

    @Test
    fun test5(){
        assertEquals(126, countVowelStrings(5))
    }

    @Test
    fun test6(){
        assertEquals(66045, countVowelStrings(33))
    }
}