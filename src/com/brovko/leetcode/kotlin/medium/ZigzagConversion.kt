package com.brovko.leetcode.kotlin.medium

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ZigzagConversion {
    /** 6. Zigzag Conversion
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     */
    fun convert(s: String, numRows: Int): String {
        if (s.length < numRows || numRows < 2) return s

        val cycle = 2 * numRows - 2;
        val builder = StringBuilder()

        for (i in 0 until numRows) {
            var j = 0
            while (j + i < s.length){
                builder.append(s.get(j + i))

                if(i != 0 && i != numRows - 1 && j + cycle - i  < s.length)
                    builder.append(s.get(j + cycle - i))

                j += cycle
            }
        }

        return builder.toString()
    }

    @Test
    fun test1() {
        assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3))
    }

    @Test
    fun test2() {
        assertEquals("PINALSIGYAHRPI", convert("PAYPALISHIRING", 4))
    }
}