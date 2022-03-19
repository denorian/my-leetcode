package com.brovko.leetcode.tree.easy;

import com.brovko.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinaryTreePostorderTraversal {
    /**
     * Given the root of a binary tree, return the postorder traversal of its nodes' values.
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while ( ! stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(0, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        return result;
    }

    @Test
    public void test_1() {
        TreeNode tree = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> res = new ArrayList<Integer>();
        res.add(3);
        res.add(2);
        res.add(1);

        assertEquals(res, postorderTraversal(tree));
    }
}
