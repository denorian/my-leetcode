package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FinalValueOfVariableAfterPerformingOperations {
    /** There is a programming language with only four operations and one variable X:
    ++X and X++ increments the value of the variable X by 1.
    --X and X-- decrements the value of the variable X by 1.
    Initially, the value of X is 0.
    Given an array of strings operations containing a list of operations,
    return the final value of X after performing all the operations.
     */
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var res = 0;
        for (op in operations)
            res += if(op.contains("+")) 1 else -1

        return res;
    }

    @Test
    fun test1() {
        assertEquals(1, finalValueAfterOperations(arrayOf("--X","X++","X++")))
    }

    @Test
    fun test2() {
        assertEquals(3, finalValueAfterOperations(arrayOf("++X","++X","X++")))
    }

    @Test
    fun test3() {
        assertEquals(0, finalValueAfterOperations(arrayOf("X++","++X","--X","X--")))
    }
}