package com.brovko.leetcode.tree.easy;

import com.brovko.leetcode.common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PathSum {
    /**
     * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such
     * that adding up all the values along the path equals targetSum.
     * A leaf is a node with no children.
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null)
            return targetSum == root.val;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(5,
            new TreeNode(4,
                new TreeNode(11,
                    new TreeNode(7),
                    new TreeNode(2)
                ),
               null
            ),
            new TreeNode(8,
                new TreeNode(13),
                new TreeNode(4,
                    null,
                    new TreeNode(4)
                )
            )
        );

        assertTrue(hasPathSum(root, 22));
    }
}
