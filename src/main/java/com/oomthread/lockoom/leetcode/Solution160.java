package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-10-11 17:21
 **/
//[ 1 , 2 , 3 , 4 , 5 ]
//  A   B   A   B   A

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        while (headA!=null){

            ListNode tmp=headB;
            while (tmp!=null){
                if (headA==tmp){
                    return headA;
                }
                tmp= tmp.next;
            }
            headA=headA.next;

        }
        return null;
    }


}
