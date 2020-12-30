package com.jarome.leetcode.test4;

public class SolutionMergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode node = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                node.next = l2;
                l2 = null;
                continue;
            }
            if (l2 == null) {
                node.next = l1;
                l1 = null;
                continue;
            }
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        return head;
    }
}
