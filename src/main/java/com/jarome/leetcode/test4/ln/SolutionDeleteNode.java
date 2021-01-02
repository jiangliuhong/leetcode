package com.jarome.leetcode.test4.ln;

public class SolutionDeleteNode {

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        if (next.next != null) {
            node.next = next.next;
        } else {
            node.next = null;
        }
    }

}
