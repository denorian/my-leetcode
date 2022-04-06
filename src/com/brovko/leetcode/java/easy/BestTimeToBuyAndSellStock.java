package com.brovko.leetcode.java.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BestTimeToBuyAndSellStock {
    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
     * in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     * @param prices
     * @return maxProfit
     */
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
                maxIndex = i;
            }

            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
                minIndex = i;
                maxIndex = i;
            }

            if(minIndex < maxIndex && profit < (max - min))
                profit = max - min;
        }

        return profit;
    }

    @Test
    public void test_1() {
        assertEquals(5, maxProfit(new int[]{7,1,5,3,6,4}));
    }

    @Test
    public void test_2() {
        assertEquals(0, maxProfit(new int[]{7,6,4,3,1}));
    }

    @Test
    public void test_3() {
        assertEquals(2, maxProfit(new int[]{2,4,1}));
    }
}
