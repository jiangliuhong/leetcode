package com.jarome.leetcode.test4.ln;

/**
 * 两数相加
 */
public class SolutionAddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        int p = 0;
        while (l1 != null || l2 != null) {
            int sum = p;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            int val = sum % 10;
            p = sum / 10;
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        if (p > 0) {
            temp.next = new ListNode(p);
        }
        return listNode.next;
    }

}
