package com.brovko.leetcode.easy;

import com.brovko.leetcode.common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertSortedArrayToBinarySearchTree {
    /**
     * Given an integer array nums where the elements are sorted in ascending order,
     * convert it to a height-balanced binary search tree.
     * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node
     * never differs by more than one.
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;

        return constructTree(nums, 0, nums.length - 1);
    }

    private static TreeNode constructTree(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums, start, mid - 1);
        root.right = constructTree(nums, mid + 1, end);

        return root;
    }

    @Test
    public void test_1() {
        TreeNode result = new TreeNode(0,
            new TreeNode(-10,
                null,
                new TreeNode(-3)
            ),
            new TreeNode(
                5,
                null,
                new TreeNode(9)
            )
        );

        int[] source = new int[]{-10,-3,0,5,9};

        assertEquals(result, sortedArrayToBST(source));
    }
}
