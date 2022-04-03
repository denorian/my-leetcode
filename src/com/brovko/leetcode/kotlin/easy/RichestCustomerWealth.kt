package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class RichestCustomerWealth {
    /**
     * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the in customer has in the bank.
     * Return the wealth that the richest customer has.
     * A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.
     */
    fun maximumWealth(accounts: Array<IntArray>): Int {
        return Arrays.stream(accounts)
            .map{ arr -> Arrays.stream(arr).sum() }
            .max(Int::compareTo)
            .get()
    }

    @Test
    fun test1() {
        val source = arrayOf(
            intArrayOf (1,2,3),
            intArrayOf (3,2,1)
        )

        assertEquals(6, maximumWealth(source))
    }

    @Test
    fun test2() {
        val source = arrayOf(
            intArrayOf (1,5),
            intArrayOf (7,3),
            intArrayOf (3,5)
        )

        assertEquals(10, maximumWealth(source))
    }

    @Test
    fun test3() {
        val source = arrayOf(
            intArrayOf (2,8,7),
            intArrayOf (7,1,3),
            intArrayOf (1,9,5),
        )

        assertEquals( 17, maximumWealth(source))
    }
}