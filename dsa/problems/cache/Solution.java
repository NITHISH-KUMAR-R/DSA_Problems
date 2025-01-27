package dsa.problems.cache;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.next=null;
            this.prev=null;
        }
    }
    class LRUCache {
        private  int capacity;
        private Map<Integer, Node> cacheMap;
        private  Node head;
        private  Node tail;


        LRUCache(int cap) {

            this.capacity=cap;
            this.cacheMap= new HashMap<Integer,Node>();
            this.head=new Node(-1,-1);
            this.tail=new Node(-1,-1);
            this.head.next=this.tail;
            this.tail.prev=this.head;
        }

        // Function to return value corresponding to the key.
        public int get(int key) {
            // your code here
            if(!cacheMap.containsKey(key)){
                return -1;
            }
            Node oldNode=cacheMap.get(key);
            remove(oldNode);
            add(oldNode);
            return oldNode.value;
        }

        // Function for storing key-value pair.
        public void put(int key, int value) {
            // your code here
            if(cacheMap.containsKey(key)){
                Node oldNode=cacheMap.get(key);
                remove(oldNode);
            }

            Node newNode=new Node(key,value);
            add(newNode);
            cacheMap.put(key,newNode);

            if(cacheMap.size()>capacity){
                Node delNode=this.head.next;
                remove(delNode);
                cacheMap.remove(delNode.key);
            }
        }

        private  void add(Node newNode){
            Node prevN=this.tail.prev;
            this.tail.prev=newNode;
            newNode.prev=prevN;
            newNode.next=this.tail;
            prevN.next=newNode;
        }

        private  void remove(Node delNode){
            Node prevN=delNode.prev;
            prevN.next=delNode.next;
            delNode.next.prev=prevN;
        }

    }
}
