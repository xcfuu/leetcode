package com.oomthread.lockoom.leetcode;

        /*给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
        要求返回这个链表的深拷贝。
        我们用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
        val：一个表示Node.val的整数。
        random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            Node node = new Node(head.val);
            if (head.random == head) {
                node.random = node;
            }
            return node;
        }
        Node fast = head;
        List<Node> list = new ArrayList<>();
        List<Node> newlist = new ArrayList<>();
        list.add(head);
        Node node = new Node(fast.val);
        newlist.add(node);
        while (fast.next != null) {
            fast = fast.next;
            Node newNode = new Node(fast.val);
            list.add(fast);
            newlist.add(newNode);
        }
        for (int i = 0; i < list.size(); i++) {
            Node oldNode =list.get(i);
            Node newNode =newlist.get(i);
            if(i!=list.size()-1){
                newNode.next = newlist.get(i+1);
            }
            if(oldNode.random!=null){
                int flag = list.indexOf(oldNode.random);
                newNode.random=newlist.get(flag);
            }
        }
        return newlist.get(0);

    }


    // HashMap which holds old nodes as keys and new nodes as its values.
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList1(Node head) {

        if (head == null) {
            return null;
        }

        // If we have already processed the current node, then we simply return the cloned version of
        // it.
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val);

        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid
        // them.
        this.visitedHash.put(head, node);

        // Recursively copy the remaining linked list starting once from the next pointer and then from
        // the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }

    public Node copyRandomList3(Node head) {

        if (head == null) {
            return null;
        }

        // Creating a new weaved list of original and copied nodes.
        Node ptr = head;
        while (ptr != null) {

            // Cloned node
            Node newNode = new Node(ptr.val);

            // Inserting the cloned node just next to the original node.
            // If A->B->C is the original linked list,
            // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Unweave the linked list to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }




}
