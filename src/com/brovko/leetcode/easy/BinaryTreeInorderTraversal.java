package com.brovko.leetcode.easy;

import com.brovko.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class BinaryTreeInorderTraversal {
    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;

        while (true) {
            if(node != null) {
                stack.push(node);
                node = node.left;
                continue;
            }

            if (stack.isEmpty()) break;

            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }

        return result;
    }

    @Test
    public void test_1() {
        TreeNode tree = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List res = new ArrayList<Integer>();
        res.add(1);
        res.add(3);
        res.add(2);

        assertEquals(res, inorderTraversal(tree));
    }
}
