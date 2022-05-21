package com.brovko.leetcode.kotlin.medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CoinChange {
    /**
     * You are given an integer array coins representing coins of different denominations and an integer amount
     * representing a total amount of money.
     * Return the fewest number of coins that you need to make up that amount.
     * If that amount of money cannot be made up by any combination of the coins, return -1.
     * You may assume that you have an infinite number of each kind of coin.
     */

    fun coinChange(coins: IntArray, amount: Int): Int {
        val mins = IntArray(amount + 1)
        for (i in 1..amount) {
            var min = Int.MAX_VALUE
            for (j in coins.indices) {
                if (i - coins[j] >= 0 && mins[i - coins[j]] != Int.MAX_VALUE) {
                    min = Math.min(min, mins[i - coins[j]] + 1)
                }
            }
            mins[i] = min
        }

        return if (mins[amount] == Int.MAX_VALUE) -1 else mins[amount]
    }



    @Test
    fun test1(){
        assertEquals(3, coinChange(intArrayOf(1,2,5), 11))
    }

    @Test
    fun test2(){
        assertEquals(-1, coinChange(intArrayOf(2), 3))
    }

    @Test
    fun test3(){
        assertEquals(0, coinChange(intArrayOf(1), 0))
    }

    @Test
    fun test4(){
        assertEquals(4, coinChange(intArrayOf(2,5,10,1), 27))
    }

    @Test
    fun test5(){
        assertEquals(2, coinChange(intArrayOf(9,6,5,1), 11))
    }
}