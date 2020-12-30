package com.jarome.leetcode.test4;

public class SolutionIsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.next.val == head.val;
        }
        return ln(head, head.next, head.next.next);
    }

    private boolean ln(ListNode start, ListNode endPre, ListNode end) {
        if (end.next == null) {
            return start.val == end.val;
        } else {
            return ln(start, end, end.next) && start.next.val == endPre.val;
        }
    }
}
