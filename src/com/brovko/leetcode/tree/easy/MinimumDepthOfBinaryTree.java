package com.brovko.leetcode.tree.easy;

import com.brovko.leetcode.common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumDepthOfBinaryTree {
    /**
     * Given a binary tree, find its minimum depth.
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     * Note: A leaf is a node with no children.
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
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
        assertEquals(2, minDepth(root));
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(2,
            null,
            new TreeNode(3,
                null,
                new TreeNode(4,
                    null,
                    new TreeNode( 5,
                        null,
                        new TreeNode(6)
                    )
                )
            )
        );
        assertEquals(5 ,minDepth(root));
    }
}