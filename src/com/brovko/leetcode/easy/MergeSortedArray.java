package com.brovko.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortedArray {
    /**
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
     * representing the number of elements in nums1 and nums2 respectively.
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
     * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that
     * should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int i = m + n + 1; i >= 0; i--) {
            int a = m >= 0 ? nums1[m] : Integer.MIN_VALUE;
            int b = n >= 0 ? nums2[n] : Integer.MIN_VALUE;

            if(a > b) {
                nums1[i] = a;
                m--;
            } else {
                nums1[i] = b;
                n--;
            }
        }
    }



    @Test
    public void test_1() {
        int[] source = {1, 2, 3, 0, 0, 0};
        merge(source, 3, new int[]{2,5,6}, 3);
        assertArrayEquals(
            new int[]{1,2,2,3,5,6},
            source
        );
    }

    @Test
    public void test_2() {
        int[] source = {1};
        merge(source, 1, new int[]{}, 0);
        assertArrayEquals(
            new int[]{1},
            source
        );
    }
}
