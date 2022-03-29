package com.brovko.leetcode.hard;

import org.junit.Test;

import static com.brovko.leetcode.common.GlobalConstants.DELTA;
import static org.junit.Assert.assertEquals;

public class MedianOfTwoSortedArrays {
    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively,
     * return the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int indexRes = 0;
        int[] result = new int[nums1.length + nums2.length];

        while (index1 < nums1.length && index2 < nums2.length) {
            if(nums1[index1] < nums2[index2]) {
                result[indexRes] = nums1[index1];
                index1++;
            } else {
                result[indexRes] = nums2[index2];
                index2++;
            }

            indexRes++;
        }

        while (index1 < nums1.length) {
            result[indexRes] = nums1[index1];
            index1++;
            indexRes++;
        }

        while (index2 < nums2.length) {
            result[indexRes] = nums2[index2];
            index2++;
            indexRes++;
        }

        if(result.length % 2 == 0) {
            int n = result.length / 2 - 1;
            int m = result.length / 2;
            return (result[n] + result[m]) / 2.;
        } else {
            return (result[result.length / 2]);
        }
    }


    @Test
    public void test_1() {
        assertEquals(2, findMedianSortedArrays(new int[]{1,3}, new int[]{2}), DELTA);
    }

    @Test
    public void test_2() {
        assertEquals(2.5, findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}), DELTA);
    }
}
