package com.brovko.leetcode.easy;

import com.brovko.leetcode.common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesFromSortedList {
    /**
     * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
     * Return the linked list sorted as well.
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if ( head == null) return head;

        ListNode curr = head;

        while (curr.next != null) {
            if(curr.val == curr.next.val ) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    @Test
    public void test_1() {
        ListNode list = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode res = new ListNode(1, new ListNode(2));

        assertEquals(res, deleteDuplicates(list));
    }

    @Test
    public void test_2() {
        ListNode list = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode res = new ListNode(1, new ListNode(2, new ListNode(3)));

        assertEquals(res, deleteDuplicates(list));
    }
}
