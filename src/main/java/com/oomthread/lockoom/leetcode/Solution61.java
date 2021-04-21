package com.oomthread.lockoom.leetcode;
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        int length = 1;
        ListNode end = head;

        while (end.next != null) {
            length++;
            end = end.next;
        }
        if(length==1){
            return head;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        for (int i = 0; i < length-k-1; i++) {
            fast=fast.next;
        }
        ListNode reture=fast.next;
        fast.next=null;
        end.next=head;
        return reture;
    }
}
