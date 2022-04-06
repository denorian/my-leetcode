package com.brovko.leetcode.java.easy;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PascalsTriangle {
    /**
     * Given an integer numRows, return the first numRows of Pascal's triangle.
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) return result;

        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> previous = result.get(i - 1);
            List<Integer> current = new ArrayList<>();
            current.add(1);

            for(int j = 1; j <= i; j++) {
                Integer preInt =  previous.size() > j ? previous.get(j) : 0;
                current.add(previous.get(j - 1) + preInt);
            }

            result.add(current);
        }

        return result;
    }

    @Test
    public void test_1() {
        List<List<Integer>> expect = Lists.newArrayList(
            Lists.newArrayList(1),
            Lists.newArrayList(1, 1),
            Lists.newArrayList(1, 2, 1),
            Lists.newArrayList(1, 3, 3, 1),
            Lists.newArrayList(1, 4, 6, 4, 1)
        );

        assertEquals(expect, generate(5));
    }
}
