package com.jarome.leetcode.algobase;

import com.jarome.leetcode.test4.ln.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = new ListNode(-101);
        ListNode p = h;
        while (head != null) {
            ListNode temp = head.next;
            while (temp != null) {
                if (head.val != temp.val) {
                    break;
                }
                temp = temp.next;
            }
            if (temp == head.next) {
                p.next = new ListNode(head.val);
                p = p.next;
            }
            head = temp;
        }
        return h.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates d = new DeleteDuplicates();
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        head.next = l1;
        l1.next = l2;
        System.out.println(d.deleteDuplicates(head));
    }
}
