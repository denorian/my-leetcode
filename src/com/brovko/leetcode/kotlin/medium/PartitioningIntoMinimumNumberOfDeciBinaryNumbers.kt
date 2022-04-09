package com.brovko.leetcode.kotlin.medium

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    /**
     * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
     * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
     * Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary
     * numbers needed so that they sum up to n.
     */
    fun minPartitions(n: String): Int {
        return n.toCharArray()
            .toList()
            .stream()
            .max(Char::compareTo)
            .get() - '0'
    }

    @Test
    fun test1() {
        assertEquals(3, minPartitions("32"))
    }
    @Test
    fun test2() {
        assertEquals(8, minPartitions("82734"))
    }
    @Test
    fun test3() {
        assertEquals(9, minPartitions("27346209830709182346"))
    }
}