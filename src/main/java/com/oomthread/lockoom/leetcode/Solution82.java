package com.oomthread.lockoom.leetcode;


/**
 * @Author xuechaofu
 * @Date 2023-10-10 16:19
 **/
//[1,1,1,3,4,4,5]
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dump=new ListNode(0,head);
        ListNode curr=dump;
        while (curr.next!=null&& curr.next.next!=null){
            if (curr.next.val==curr.next.next.val){
                int x = curr.next.val;
                while (curr.next!=null&&curr.next.val==x){
                    curr.next=curr.next.next;
                }
            }else {
                curr = curr.next;
            }
        }


        return dump.next;
    }


}
