package com.oomthread.lockoom.leetcode;

import java.util.List;

/**
 * @Author xuechaofu
 * @Date 2023-10-11 16:16
 **/

//[ 1 , 2 , 3 , 4 , 5 ]
//  p   l       r   n
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dump = new ListNode(0, head);


        ListNode p = dump;

        for (int i=0;i<left-1;i++){
            p=p.next;
        }
        ListNode l=p.next;
        ListNode r=p;

        for (int i=0;i<right-left+1;i++){
            r=r.next;
        }
        ListNode n=r.next;

        r.next=null;
        p.next=null;
        this.res(l);
        p.next=r;
        l.next=n;


        return dump.next;
    }


    private ListNode res(ListNode head){
        ListNode pre = head;
        ListNode curr = head.next;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return head;
    }




}
