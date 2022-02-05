package com.brovko.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthOfLastWord {
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
