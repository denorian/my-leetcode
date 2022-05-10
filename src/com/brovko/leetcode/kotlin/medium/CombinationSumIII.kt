package com.brovko.leetcode.kotlin.medium

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals


class CombinationSumIII {
    /**
     * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
     * Only numbers 1 through 9 are used.
     * Each number is used at most once.
     * Return a list of all possible valid combinations.
     * The list must not contain the same combination twice, and the combinations may be returned in any order.
     */
    var result: ArrayList<List<Int>> = ArrayList()

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        recurcionCombSum(k, 1, n, ArrayList())

        return result
    }

    fun recurcionCombSum(k: Int, start: Int, sum: Int, curr: ArrayList<Int>) {
        if (sum == 0 && curr.size == k) {
            result.add(ArrayList(curr))
        } else if (sum < start || curr.size == k) {
            return
        } else {
            for (i in start ..   kotlin.math.min(sum, 9)) {
                curr.add(i)
                recurcionCombSum(k, i + 1, sum - i, curr)
                curr.removeAt(curr.lastIndex)
            }
        }
    }

    @Test
    fun test1(){
        assertContentEquals(
            listOf(listOf(1,2,4)) ,
            combinationSum3(3, 7)
        )
    }

    @Test
    fun test2(){
        assertContentEquals(
            listOf(listOf(1,2,6), listOf(1,3,5), listOf(2,3,4)) ,
            combinationSum3(3, 9)
        )
    }

    @Test
    fun test3(){
        assertContentEquals(
            listOf() ,
            combinationSum3(4, 1)
        )
    }

    @Test
    fun test4(){
        assertContentEquals(
            listOf(listOf(1,5,9), listOf(1,6,8), listOf(2,4,9), listOf(2,5,8), listOf(2,6,7), listOf(3,4,8), listOf(3,5,7), listOf(4,5,6)) ,
            combinationSum3(3, 15)
        )
    }

    @Test
    fun test5(){
        assertContentEquals(
            listOf() ,
            combinationSum3(4, 54)
        )
    }
}