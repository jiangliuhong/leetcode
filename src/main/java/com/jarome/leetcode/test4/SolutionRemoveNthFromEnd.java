package com.jarome.leetcode.test4;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val) {
 * this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        int num = 1;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(num, start);
        while (start.next != null) {
            start = start.next;
            num++;
            map.put(num, start);
        }
        int index = num - n + 1;
        if (index > num) {
            return null;
        } else if (index == 1) {
            return map.get(2);
        } else {
            map.get(index - 1).next = map.get(index + 1);
            return head;
        }
    }
}