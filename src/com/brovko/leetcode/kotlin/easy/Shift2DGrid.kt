package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class Shift2DGrid {
    /**
    Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
    In one shift operation:
    Element at grid[i][j] moves to grid[i][j + 1].
    Element at grid[i][n - 1] moves to grid[i + 1][0].
    Element at grid[m - 1][n - 1] moves to grid[0][0].
    Return the 2D grid after applying shift operation k times.
     */
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val x = grid[0].size
        val y = grid.size
        val newK = k % (x * y)
        val start = (x * y) - newK

        val list: MutableList<MutableList<Int>> = mutableListOf()
        for (i in start until x * y + start) {
            val j = i % (x * y)
            val r = j / x
            val c = j % x
            if ((i - start) % x == 0) {
                list.add(mutableListOf())
            }
            list.last().add(grid[r][c])
        }

        return list
    }

    @Test
    fun test1() {
        assertContentEquals(
            listOf(listOf(9,1,2), listOf(3,4,5), listOf(6,7,8)) ,
            shiftGrid( arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)),1)
        )
    }

    @Test
    fun test2() {
        assertContentEquals(
            listOf(listOf(12,0,21,13), listOf(3,8,1,9), listOf(19,7,2,5), listOf(4,6,11,10)) ,
            shiftGrid( arrayOf(
                intArrayOf(3,8,1,9),
                intArrayOf(19,7,2,5),
                intArrayOf(4,6,11,10),
                intArrayOf(12,0,21,13)
            ),
                4
            )
        )
    }


    @Test
    fun test3() {
        assertContentEquals(
            listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9)) ,
            shiftGrid( arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)), 9)
        )
    }


    @Test
    fun test4() {
        assertContentEquals(
            listOf(listOf(1)) ,
            shiftGrid( arrayOf(intArrayOf(1)), 100)
        )
    }
}