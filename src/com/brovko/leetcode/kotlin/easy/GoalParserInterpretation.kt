package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GoalParserInterpretation {
    /**
     * You own a Goal Parser that can interpret a string command.
     * The command consists of an alphabet of "G", "()" and/or "(al)" in some order.
     * The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al".
     * The interpreted strings are then concatenated in the original order.
     * Given the string command, return the Goal Parser's interpretation of command.
     */
    fun interpret(command: String): String {
        var i = 0
        val builder = StringBuilder()

        while (i < command.length) {
            if(command.get(i) == 'G') {
                builder.append("G")
                i += 1
            } else if(command.get(i) == '(') {
                if(command.get(i+1) == ')') {
                    builder.append("o")
                    i += 2
                } else {
                    builder.append("al")
                    i += 4
                }
            }
        }

        return builder.toString()
    }

    @Test
    fun test1() {
        assertEquals("Goal", interpret("G()(al)"))
    }

    @Test
    fun test2() {
        assertEquals("Gooooal", interpret("G()()()()(al)"))
    }

    @Test
    fun test3() {
        assertEquals("alGalooG", interpret("(al)G(al)()()G"))
    }
}