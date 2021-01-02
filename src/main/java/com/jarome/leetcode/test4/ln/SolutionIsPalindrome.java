package com.jarome.leetcode.test4.ln;

public class SolutionIsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int size = 1;
        ListNode start = head;
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
            size++;
        }
        int half = size / 2;
        ListNode node = head;
        int index = 1;
        while (node.next != null) {
            if (index < half) {
                index++;
                node = node.next;
                continue;
            }
            // 开始反转
            end = reverseList(node.next);
            node.next = null;
            break;
        }
        while (start != null && end != null) {
            if (start.val != end.val) {
                return false;
            }
            start = start.next;
            end = end.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        while (node.next != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        node.next = pre;
        return node;
    }

}
