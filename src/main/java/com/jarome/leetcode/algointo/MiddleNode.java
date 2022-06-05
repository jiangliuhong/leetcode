package com.jarome.leetcode.algointo;

import com.jarome.leetcode.test4.ln.ListNode;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        temp = head;
        ListNode res = head;
        int sub = len / 2;
        for (int i = 0; i <= sub; i++) {
            if (i == sub) {
                res = temp;
            }
            temp = temp.next;
        }
        return res;
    }
}
