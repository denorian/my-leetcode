package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DefangingAnIPAddress {
    /**
     * Given a valid (IPv4) IP address, return a defanged version of that IP address.
     * A defanged IP address replaces every period "." with "[.]".
     */
    fun defangIPaddr(address: String): String {
         var res = ""
         address.chars().forEach {
             ch -> res += if (ch == 46) "[.]" else ch.toChar().toString()
         }

        return res
    }

    fun defangIPaddrSecondSolution(address: String): String {
        return address.replace(".", "[.]");
    }

    @Test
    fun test1() {
        assertEquals("1[.]1[.]1[.]1", defangIPaddr("1.1.1.1"))
    }

    @Test
    fun test2() {
        assertEquals("255[.]100[.]50[.]0", defangIPaddr("255.100.50.0"))
    }
}