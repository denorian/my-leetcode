package com.brovko.leetcode.kotlin.medium

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class ShortestPathInBinaryMatrix {
    /**
     * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
     * If there is no clear path, return -1.
     * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0))
     * to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
     * All the visited cells of the path are 0.
     * All the adjacent cells of the path are 8-directionally connected
     * (i.e., they are different and they share an edge or a corner).
     * The length of a clear path is the number of visited cells of this path.
     */
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid.size == 0 || grid[0].size == 0 || grid[0][0] == 1)
            return -1;

        val row = grid.size
        val col = grid[0].size

        if (grid[row - 1][col - 1] == 1)
            return -1;

        val queue = LinkedList<IntArray>()
        queue.add(intArrayOf(0,0,1))
        grid[0][0] = 1

        val dirs = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(1, 1),
            intArrayOf(1, -1),
            intArrayOf(-1, -1),
            intArrayOf(-1, 1)
        )

        while ( ! queue.isEmpty()) {
            var size = queue.size
            while (size-- > 0) {
                val point = queue.poll()

                if (point[0] == row-1 && point[1] == col-1)
                    return point[2]

                for (dir in dirs) {
                    val nextX = point[0] + dir[0]
                    val nextY = point[1] + dir[1]

                    if(nextX >= 0 && nextY >= 0 && nextX < row && nextY < col && grid[nextX][nextY] == 0) {
                        queue.add(intArrayOf(nextX, nextY, point[2] + 1))
                        grid[nextX][nextY] = 1
                    }
                }
            }
        }

        return -1
    }

    @Test
    fun test1() {
         assertEquals(
            2,
             shortestPathBinaryMatrix(
                 arrayOf(
                     intArrayOf(0,1),
                     intArrayOf(1,0)
                 )
             )
         )
    }

    @Test
    fun test2() {
        assertEquals(
            4,
            shortestPathBinaryMatrix(
                arrayOf(
                    intArrayOf(0,0,0),
                    intArrayOf(1,1,0),
                    intArrayOf(1,1,0),
                )
            )
        )
    }

    @Test
    fun test3() {
        assertEquals(
            -1,
            shortestPathBinaryMatrix(
                arrayOf(
                    intArrayOf(1,0,0),
                    intArrayOf(1,1,0),
                    intArrayOf(1,1,0),
                )
            )
        )
    }

    @Test
    fun test4() {
        assertEquals(
            10,
            shortestPathBinaryMatrix(
                arrayOf(
                    intArrayOf(0,1,1,0,0,0),
                    intArrayOf(0,1,1,0,1,0),
                    intArrayOf(0,0,0,1,1,0),
                    intArrayOf(1,1,1,1,1,0),
                    intArrayOf(1,1,1,1,1,0),
                )
            )
        )
    }
}