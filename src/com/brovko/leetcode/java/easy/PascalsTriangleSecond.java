package com.brovko.leetcode.java.easy;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PascalsTriangleSecond {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> previous = result.get(i - 1);
            List<Integer> current = new ArrayList<>();
            current.add(1);

            for(int j = 1; j <= i; j++) {
                Integer preInt =  previous.size() > j ? previous.get(j) : 0;
                current.add(previous.get(j - 1) + preInt);
            }

            result.add(current);
        }

        return result.get(rowIndex);
    }

    @Test
    public void test_1() {
        assertEquals(Lists.newArrayList(1, 3, 3, 1), getRow(3));
    }
}
