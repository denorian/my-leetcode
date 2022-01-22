package com.brovko.leetcode.arrays;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;

public class TwoSum {
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * <p>
     * Example 1:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * <p>
     * Example 2:
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * <p>
     * Example 3:
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer requiredNum = target - nums[i];
            if (indexMap.containsKey(requiredNum)) {
                return new int[]{indexMap.get(requiredNum), i};
            }

            indexMap.put(nums[i], i);
        }

        return new int[]{};
    }

    @Test
    public void test() {
        TwoSum obj = new TwoSum();
        assertArrayEquals(new int[]{1, 2}, obj.twoSum(new int[]{2, 7, 13, 15}, 20));
    }
}
