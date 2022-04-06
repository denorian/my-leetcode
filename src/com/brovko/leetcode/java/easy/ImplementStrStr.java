package com.brovko.leetcode.java.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImplementStrStr {

    /**
     * Implement strStr().
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * Clarification:
     * What should we return when needle is an empty string? This is a great question to ask during an interview.
     * For the purpose of this problem, we will return 0 when needle is an empty string.
     * This is consistent to C's strstr() and Java's indexOf().
     * @param haystack
     * @param needle
     * @return
     */

    public static int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        if ( haystack == null || needleLength > haystack.length()) {
            return -1;
        } else if(haystack.equals(needle)) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needleLength; i++) {
            if(haystack.substring(i, i + needleLength).equals(needle))
                return i;
        }

        return -1;
    }

    
    @Test
    public void test_1() {
        assertEquals(2, strStr("hello", "ll"));
    }

    @Test
    public void test_2() {
        assertEquals(-1, strStr("aaaaa", "bba"));
    }

    @Test
    public void test_3() {
        assertEquals(0, strStr("", ""));
    }

    @Test
    public void test_4() {
        assertEquals(2, strStr( "abc", "c"));
    }
}
