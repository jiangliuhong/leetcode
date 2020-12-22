package com.jarome.leetcode.test4;

public class SolutionRemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        int i = 0;
        while (start.next != null){
            i++;
            if(i == n){

                break;
            }
        }
        return head;
    }

}