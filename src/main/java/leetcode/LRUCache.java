package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 01/11/18.
 *
 * https://leetcode.com/problems/lru-cache/description/
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,6);
        lruCache.put(1,5);
        lruCache.put(1,2);
        lruCache.get(1);
        lruCache.get(2);
    }

    public class Node{
        Node prev;
        Node next;
        int value;
        int key;
        public Node(int key,int value){
            this.value = value;
            this.key = key;
        }
    }

    Node head = new Node(-1,-1);
    Node tail = head;
    Map<Integer,Node> map = new HashMap<>();
    int tempCapacity = 0;
    int maxCapacity = 0;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            adjustNode(key);
            return map.get(key).value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value = value;
            adjustNode(key);
            return;
        }
        if(tempCapacity < maxCapacity){
            insertNewNode(key,value);
            tempCapacity++;
            return;
        }

        removeLRUNode();
        insertNewNode(key,value);
        tempCapacity++;
    }

    public void adjustNode(int key){
        Node node = map.get(key);
        if(node.next == null)
            return;             // don't adjust if its the last node
        node.prev.next = node.next;
        node.next.prev  = node.prev;
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }

    public void insertNewNode(int key, int value){
        Node node = new Node(key,value);
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
        map.put(key,node);
    }

    public void removeLRUNode(){
        map.remove(head.next.key);
        if(tempCapacity > 1){
            head.next.next.prev = head;
        }
        head.next = head.next.next;   // assuming there is atleast 1 capacity;
        tempCapacity--;
        if(tempCapacity == 0)
            tail = head;
    }
}
