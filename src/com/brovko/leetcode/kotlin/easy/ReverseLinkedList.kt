package com.brovko.leetcode.kotlin.easy

import com.brovko.leetcode.common.ListNode
import com.brovko.leetcode.java.easy.MergeTwoSortedLists
import org.junit.Test
import kotlin.test.assertEquals

class ReverseLinkedList {

    /**
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     */

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head

        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }

        return prev
    }

    @Test
    fun test_1() {
        val source = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
        val expected = ListNode(5, ListNode(4, ListNode(3, ListNode(2, ListNode(1)))))

        assertEquals(expected, reverseList(source))
    }

    @Test
    fun test_2() {
        val source = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
        val expected = ListNode(5, ListNode(4, ListNode(3, ListNode(2, ListNode(1)))))

        assertEquals(expected, reverseList(source))
        assertEquals(null, MergeTwoSortedLists.mergeTwoLists(null, null))
    }

    @Test
    fun test_3() {
        assertEquals(ListNode(0), MergeTwoSortedLists.mergeTwoLists(null, ListNode(0)))
    }
}