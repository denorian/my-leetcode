package com.brovko.leetcode.kotlin.medium

import com.brovko.leetcode.common.TreeNode
import org.junit.Test
import kotlin.test.assertEquals

class DeepestLeavesSum {
    /**
     * Given the root of a binary tree, return the sum of values of its deepest leaves.
     */
    var sum = 0
    var maxDepth = 0

    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) return 0

        depth(root, 0)

        return sum
    }

    fun depth(root: TreeNode, depth: Int) {
        if(maxDepth < depth) {
            maxDepth = depth
            sum = 0
        }

        if (maxDepth == depth) {
            sum += root.`val`
        }

        if(root.left != null)
            depth(root.left, depth + 1)

        if(root.right != null)
            depth(root.right, depth + 1)
    }

    @Test
    fun test_1() {
        val root = TreeNode(
            1,
            TreeNode(2,
                TreeNode(4,
                    TreeNode(7),
                    null
                ),
                TreeNode(5)
            ),
            TreeNode(
                3,
                null,
                TreeNode(6,
                null,
                    TreeNode(8),
                )
            )
        )

        assertEquals(15, deepestLeavesSum(root))
    }
}