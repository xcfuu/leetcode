package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-10-10 15:21
 **/
//[1,2,3,4]
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        if (head != null && head.next != null) {
            head = head.next;
        }

        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = curr;
            if (pre != null) {
                pre.next = next;
            }
            pre=curr;
            curr=curr.next;
        }


        return head;
    }

}
