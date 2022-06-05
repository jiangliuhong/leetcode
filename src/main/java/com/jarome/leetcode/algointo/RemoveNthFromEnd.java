package com.jarome.leetcode.algointo;

import com.jarome.leetcode.test4.ln.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) {
                return head.next;
            }
        }
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                slow.next = slow.next.next;
            } else {
                slow = slow.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ln = head;
        ln.next = new ListNode(2);
        ln = ln.next;
        ln.next = new ListNode(3);
        ln = ln.next;
        ln.next = new ListNode(4);
        ln = ln.next;
        ln.next = new ListNode(5);
        RemoveNthFromEnd r = new RemoveNthFromEnd();
        r.removeNthFromEnd(head, 2);
    }
}
