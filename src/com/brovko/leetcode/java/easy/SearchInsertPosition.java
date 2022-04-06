package com.brovko.leetcode.java.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInsertPosition {

    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You must write an algorithm with O(log n) runtime complexity.
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end =  nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(nums[end] < target){
            return end + 1;
        } else if (nums[start] >= target){
            return start;
        } else {
            return end;
        }
    }



    @Test
    public void test_1() {
        assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
    }

    @Test
    public void test_2() {
        assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));
    }

    @Test
    public void test_3() {
        assertEquals(4, searchInsert(new int[]{1,3,5,6}, 7));
    }

    @Test
    public void test_4() {
        assertEquals(0, searchInsert(new int[]{1,3,5,6}, 0));
    }

    @Test
    public void test_5() {
        assertEquals(0, searchInsert(new int[]{1}, 0));
    }

    @Test
    public void test_6() {
        assertEquals(1, searchInsert(new int[]{1,3}, 2));
    }
    @Test
    public void test_7() {
        assertEquals(1, searchInsert(new int[]{1,2,3,4,5,10}, 2));
    }

}
