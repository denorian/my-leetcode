package com.brovko.leetcode.easy;

import com.brovko.leetcode.common.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeTwoSortedLists {
    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
     * Return the head of the merged linked list.
     *
     * Example 1:
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     *
     * Example 2:
     * Input: list1 = [], list2 = []
     * Output: []
     *
     * Example 3:
     * Input: list1 = [], list2 = [0]
     * Output: [0]
     *
     * Constraints:
     * The number of nodes in both lists is in the range [0, 50].
     * -100 <= Node.val <= 100
     * Both list1 and list2 are sorted in non-decreasing order.
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head, temp;

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            temp = head = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            temp = head = new ListNode(list2.val);
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }

            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return head;
    }

    @Test
    public void test_1() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode res = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))));

        assertEquals(res, mergeTwoLists(list1, list2));
    }

    @Test
    public void test_2() {
        assertEquals(null, mergeTwoLists(null, null));
    }

    @Test
    public void test_3() {
        assertEquals(new ListNode(0), mergeTwoLists(null, new ListNode(0)));
    }
}
