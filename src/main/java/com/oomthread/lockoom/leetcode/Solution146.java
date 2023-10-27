package com.oomthread.lockoom.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public Solution146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode dLinkedNode = cache.get(key);

        if (dLinkedNode == null) {
            DLinkedNode node = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, node);
            size++;
            addToHead(node);
            if (size > capacity) {
                addToHead(node);
                DLinkedNode node1 = removeTail();
                cache.remove(node1.key);
                size--;
            }
        } else {
            dLinkedNode.value = value;
            moveToHead(dLinkedNode);
        }


    }


    //添加节点到头部
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //去除节点
    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }


}
