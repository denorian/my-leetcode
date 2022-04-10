package com.brovko.leetcode.kotlin.easy


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class BaseballGame {
    /**
    You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.
    At the beginning of the game, you start with an empty record. You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:
    An integer x - Record a new score of x.
    "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
    "D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
    "C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
    Return the sum of all the scores on the record.
     */
    fun calPoints(ops: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        ops.forEach {
            when(it) {
                "C" -> stack.pop()
                "D" -> stack.push(stack.peek() * 2 )
                "+" -> {
                    val last = stack.pop()
                    val newLast = stack.peek() + last;
                    stack.push(last)
                    stack.push(newLast)
                }
                else -> {
                    if(it.toIntOrNull() != null)
                        stack.push(it.toInt())
                }
            }
        }

        return stack.stream()
            .mapToInt { it.toInt() }
            .sum()
    }

    @Test
    fun test1() {
        assertEquals(30, calPoints(arrayOf("5","2","C","D","+")))
    }

    @Test
    fun test2() {
        assertEquals(27, calPoints(arrayOf("5","-2","4","C","D","9","+","+")))
    }

    @Test
    fun test3() {
        assertEquals(1, calPoints(arrayOf("1")))
    }
}