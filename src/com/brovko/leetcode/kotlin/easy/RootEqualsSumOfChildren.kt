package com.brovko.leetcode.kotlin.easy

import com.brovko.leetcode.common.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RootEqualsSumOfChildren {
    /**
     * You are given the root of a binary tree that consists of exactly 3 nodes: the root, its left child, and its right child.
     * Return true if the value of the root is equal to the sum of the values of its two children, or false otherwise.
     */
    var temp: Int = 0

    fun checkTree(root: TreeNode?): Boolean {
        sumTreeRec(root?.left)
        sumTreeRec(root?.right)

        return root?.`val` == temp
    }

    fun sumTreeRec(root: TreeNode?) {
        temp += root?.`val` ?: 0
        if(root?.left != null) sumTreeRec(root.left)
        if(root?.right != null) sumTreeRec(root.right)
    }

    @Test
    fun test_1() {
        val tree = TreeNode(10, TreeNode(4), TreeNode(6))

        assertTrue(checkTree(tree))
    }

    @Test
    fun test_2() {
        val tree = TreeNode(5, TreeNode(3), TreeNode(1))

        assertFalse(checkTree(tree))
    }
}