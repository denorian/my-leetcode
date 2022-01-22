package com.brovko.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * If there is no common prefix, return an empty string "".
     *
     * Example 1:
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     *
     * Example 2:
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     *
     * Constraints:
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lower-case English letters.
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();

        int minLength = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }

        for (int i = 0; i < minLength; i++) {
            char symbol = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != symbol)
                    return prefix.toString();
            }

            prefix.append(symbol);
        }

        return prefix.toString();
    }

    @Test
    public void test_1() {
        assertEquals("fl", longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
    @Test
    public void test_2() {
        assertEquals("", longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
