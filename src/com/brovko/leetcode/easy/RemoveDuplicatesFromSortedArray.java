package com.brovko.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedArray {

    /**
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
     * element appears only once. The relative order of the elements should be kept the same.
     * Since it is impossible to change the length of the array in some languages, you must instead have the result
     * be placed in the first part of the array nums.
     * More formally, if there are k elements after removing the duplicates,
     * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
     *
     * Return k after placing the final result in the first k slots of nums.
     * Do not allocate extra space for another array.
     * You must do this by modifying the input array in-place with O(1) extra memory.
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i < nums.length - 1 && nums[i] == nums[i + 1]) continue;

            nums[k] = nums[i];
            k++;
        }

        return k;
    }

    @Test
    public void test() {
        int[] source = new int[]{1, 1, 2};
        int[] expected = new int[]{1,  2};
        int k = removeDuplicates(source);

        assertEquals(2,  k);

        for (int i = 0; i < expected.length; i++) {
            assertTrue(source[i] == expected[i]);
        }
    }
}
