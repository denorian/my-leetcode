package com.brovko.leetcode.easy;

import com.brovko.leetcode.common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BalancedBinaryTree {
    /**
     * Given a binary tree, determine if it is height-balanced.
     * For this problem, a height-balanced binary tree is defined as:
     * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
     */
    public static boolean isBalanced(TreeNode root) {
        return maxDepth(root) != null;
    }

    private static Integer maxDepth(TreeNode root) {
        if(root == null) return 0;

        Integer left = maxDepth(root.left);
        Integer right = maxDepth(root.right);

        if(left == null || right == null || Math.abs(left - right) > 1) return null;

        return Math.max(left, right) + 1;
    }
    @Test
    public void test_1() {
        TreeNode root = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(
                20,
                new TreeNode(15),
                new TreeNode(7)
            )
        );

        assertTrue(isBalanced(root));
    }
    @Test
    public void test_2() {
        TreeNode root = new TreeNode(3,
            new TreeNode(
                2,
                new TreeNode(
                    3,
                    new TreeNode(4),
                    new TreeNode(4)
                ),
                new TreeNode(3)
            ),
            new TreeNode(2)
        );

        assertFalse(isBalanced(root));
    }
}
