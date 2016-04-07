package GoogleOA;

import java.util.HashMap;

/* Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the 
 * cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the 
 * cache reached its capacity, it should invalidate the least recently used item before 
 * inserting a new item.
 * */

public class LRU {
//hash, double linkedlist, constant time lookup, delete, and add
    
    class Node {
        Node pre, next;
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private int capacity;
    private int num;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head, tail;
    
    public void LRUCache(int capacity) {
        this.capacity = capacity;
        num = 0;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
    //if exist & not the tail, then it will become the tail, since it's the least recently used.
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        else if (node != tail) {
            if (node == head) {
                head = head.next;
            }
            else {
                node.pre.next = node.next;
            }
            node.next.pre = node.pre;
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.val;
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                }
                else {
                    node.pre.next = node.next;
                }
                node.next.pre = node.pre;
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        }
        else {
            Node newnode = new Node(key, value);
            if (num >= capacity) {
                map.remove(head.key);
                head = head.next;
                if (head != null) {
                    head.pre = null;
                }
                num--;
            }
            if (head == null || tail == null) {
                head = newnode;
            }
            else {
                tail.next = newnode;
            }
            newnode.pre = tail;
            tail = newnode;
            map.put(key, newnode);
            num++;
        }
    }
}
