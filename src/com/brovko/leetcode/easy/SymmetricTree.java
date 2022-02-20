package com.brovko.leetcode.easy;

import com.brovko.leetcode.common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SymmetricTree {
    /**
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     */
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return false;

        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1,
            new TreeNode(
                2,
                new TreeNode(3),
                new TreeNode(4)
            ),
            new TreeNode(
                2,
                new TreeNode(4),
                new TreeNode(3)
            )
        );

        assertTrue(isSymmetric(root));
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(1,
            new TreeNode(
                2,
                null,
                new TreeNode(3)
            ),
            new TreeNode(
                2,
                null,
                new TreeNode(3)
            )
        );

        assertFalse(isSymmetric(root));
    }

}
