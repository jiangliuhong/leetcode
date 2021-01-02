package com.jarome.leetcode.test4.ln;

public class SolutionReverseList {

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode node = head;
        ListNode pre = null;
        while (node.next != null){
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        node.next = pre;
        return node;
    }
}
