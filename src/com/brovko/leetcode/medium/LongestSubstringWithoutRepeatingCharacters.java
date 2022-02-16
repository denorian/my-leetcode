package com.brovko.leetcode.medium;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int start = 0;
        int end = 0;
        int max = 0;

        Set<Character> unique = new HashSet<>();
        while (end < s.length()){
            if (unique.add(s.charAt(end))){
                end++;
                max = Math.max(max, unique.size());
            } else {
                unique.remove(s.charAt(start));
                start++;
            }
        }

        return max;
    }

    @Test
    public void test_1() {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void test_2() {
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void test_3() {
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }
}
