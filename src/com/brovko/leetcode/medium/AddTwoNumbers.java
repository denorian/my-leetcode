package com.brovko.leetcode.medium;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class AddTwoNumbers {
    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example 1:
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     *
     * Example 2:
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     *
     * Example 3:
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     *
     * Constraints:
     * The number of nodes in each linked list is in the range [1, 100].
     * 0 <= Node.val <= 9
     * It is guaranteed that the list represents a number that does not have leading zeros.
     * @param l1
     * @param l2
     * @return ListNode
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = null;
        int carry = 0;

        while (l1 != null ||  l2 != null) {
            int sum = carry;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;

            if (temp == null){
                temp = result = node;
            } else {
                temp.next = node;
                temp = temp.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return result;
    }

    @Test
    public void test_1() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode res = new ListNode(7, new ListNode(0, new ListNode(8)));

        assertEquals( res, AddTwoNumbers.addTwoNumbers(l1, l2));
    }

    @Test
    public void test_2() {
        assertEquals( new ListNode(0), AddTwoNumbers.addTwoNumbers(new ListNode(0), new ListNode(0)));
    }

    @Test
    public void test_3() {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode res = new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))))))));
        assertEquals( res, AddTwoNumbers.addTwoNumbers(l1, l2));
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}