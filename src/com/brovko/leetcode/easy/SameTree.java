package com.brovko.leetcode.easy;

import com.brovko.leetcode.common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SameTree {
    /**
     * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
     * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Test
    public void test_1() {
        TreeNode treeA = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode treeB = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        assertTrue(isSameTree(treeA, treeB));
    }

    @Test
    public void test_2() {
        TreeNode treeA = new TreeNode(1, new TreeNode(2), null);
        TreeNode treeB = new TreeNode(1, null, new TreeNode(3));

        assertFalse(isSameTree(treeA, treeB));
    }

    @Test
    public void test_3() {
        TreeNode treeA = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode treeB = new TreeNode(1, new TreeNode(1), new TreeNode(2));

        assertFalse(isSameTree(treeA, treeB));
    }
}
