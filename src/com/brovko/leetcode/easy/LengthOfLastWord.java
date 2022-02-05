package com.brovko.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthOfLastWord {
    /**
     * Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
     * A word is a maximal substring consisting of non-space characters only.
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        String trim = s.trim();

        return trim.length() - trim.lastIndexOf(" ") - 1;
    }

    @Test
    public void test_1() {
        assertEquals(5, lengthOfLastWord("Hello World"));
    }
    @Test
    public void test_2() {
        assertEquals(4, lengthOfLastWord("   fly me   to   the moon  "));
    }

    @Test
    public void test_3() {
        assertEquals(6, lengthOfLastWord("luffy is still joyboy"));
    }
}
