package dsa.problems.doublyLinkedList;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final int capacity;
    private final Map<Integer,Node> map ;
    private final DoublyLinkedList dll;
    public static class Node{
        int key , value;
        Node next, prev;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static class DoublyLinkedList{
        private final Node head, tail;
        DoublyLinkedList(){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        void addNodeToFront(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        void remove(Node node){
            node.next.prev= node.prev;
            node.prev.next = node.next;
        }
        Node removeLast(){
            Node lru  = tail.prev;
            remove(lru);
            return lru;
        }

    }

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            dll.remove(node);
            dll.addNodeToFront(node);
            return node.value;
        }return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            dll.remove(node);
            dll.addNodeToFront(node);
        }else{
            if(map.size()==capacity){
                Node lru = dll.removeLast();
                map.remove(lru.key);
            }
            Node newNode = new Node(key,value);
            dll.addNodeToFront(newNode);
            map.put(key,newNode);
        }

    }
}