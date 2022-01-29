package com.brovko.leetcode.medium;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class IntegerToRoman {
    /**
     *Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, 2 is written as II in Roman numeral, just two one's added together.
     * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII. Instead, the number four is written as IV.
     * Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX.
     * There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given an integer, convert it to a roman numeral.
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        Map<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        Iterator<Map.Entry<Integer, String>> iterator = romanMap.entrySet().iterator();
        Map.Entry<Integer, String> curr = iterator.next();
        StringBuilder res = new StringBuilder();
        int i = 0;

        while (i < romanMap.size()) {
            if (num >= curr.getKey()) {
                res.append(curr.getValue());
                num -= curr.getKey();
            } else {
                i++;
                if (iterator.hasNext())
                    curr = iterator.next();
            }
        }

        return res.toString();
    }

    /** The fasted solution*/
    public String intToRoman2(int N) {
        int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder ans = new StringBuilder();
        for (int i = 0; N > 0; i++) {
            while (N >= val[i]) {
                ans.append(rom[i]);
                N -= val[i];
            }
        }
        return ans.toString();
    }


    @Test
    public void test_1() {
        assertEquals("III", intToRoman2(3));
    }

    @Test
    public void test_2() {
        assertEquals("LVIII", intToRoman2(58));
    }

    @Test
    public void test_3() {
        assertEquals("MCMXCIV", intToRoman2(1994));
    }

    @Test
    public void test_4() {
        assertEquals("MMMCMXCIX", intToRoman2(3999));
    }
}
