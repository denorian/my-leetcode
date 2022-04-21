package com.brovko.leetcode.kotlin.easy

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DesignHashSet {

    /**
     * Design a HashSet without using any built-in hash table libraries.

    Implement MyHashSet class:

    void add(key) Inserts the value key into the HashSet.
    bool contains(key) Returns whether the value key exists in the HashSet or not.
    void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
     */
    val stub = "Stub"
    val map = HashMap<Int, String>()

    fun add(key: Int) {
        map.put(key, stub)
    }

    fun remove(key: Int) {
        map.remove(key)
    }

    fun contains(key: Int): Boolean {
       return map.contains(key)
    }

    @Test
    fun test1(){
        val myHashSet = DesignHashSet()
        myHashSet.add(1) // set = [1]
        myHashSet.add(2) // set = [1, 2]

        assertTrue(myHashSet.contains(1))  // return True
        assertFalse(myHashSet.contains(3)) // return False, (not found)

        myHashSet.add(2) // set = [1, 2]

        assertTrue(myHashSet.contains(2)) // return True

        myHashSet.remove(2) // set = [1]

        assertFalse(myHashSet.contains(2)) // return False, (already removed)
    }
}