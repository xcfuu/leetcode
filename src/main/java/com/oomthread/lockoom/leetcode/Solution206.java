package com.oomthread.lockoom.leetcode;

//反转一个单链表。
public class Solution206 {
    public static ListNode reverseList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode pre =null;
        ListNode curr =head;
        ListNode next =head.next;
        while (true){
            curr.next=pre;
            pre=curr;
            curr=next;
            if(curr==null){
                break;
            }
            next=next.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node5=new ListNode(5);
        ListNode node4=new ListNode(4,node5);
        ListNode node3=new ListNode(3,node4);
        ListNode node2=new ListNode(2,node3);
        ListNode node1=new ListNode(1,node2);
        ListNode node=new ListNode(0,node1);
        System.out.println(Solution206.reverseList(node));
    }
}
