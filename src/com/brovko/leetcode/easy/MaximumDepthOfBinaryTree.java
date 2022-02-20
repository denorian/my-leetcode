package com.brovko.leetcode.easy;

import com.brovko.leetcode.common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumDepthOfBinaryTree {
    /**
     * Given the root of a binary tree, return its maximum depth.
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
        assertEquals(3 ,maxDepth(root));
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(1,
            null,
            new TreeNode(2)
        );
        assertEquals(2 ,maxDepth(root));
    }

    @Test
    public void test_3() {
        TreeNode root = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(
                20,
                new TreeNode(15),
                new TreeNode(
                    20,
                    new TreeNode(15),
                    new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(
                            20,
                            new TreeNode(15),
                            new TreeNode(
                                20,
                                new TreeNode(15),
                                null
                            )
                        )
                    )
                )
            )
        );
        assertEquals(7 ,maxDepth(root));
    }
}
