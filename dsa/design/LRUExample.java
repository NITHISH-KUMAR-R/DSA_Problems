package dsa.design;

public class LRUExample {
    public static void main(String[] args) {
        LRUCache<Integer,String> cache = new LRUCache(3);
        cache.put(1, "Apple");
        cache.put(2, "Orange");
        cache.put(3, "Mango");

        cache.get(1); // Accessing key 1
        cache.put(4, "PineApple"); // Adding new key-value pair
        cache.get(2); // This should return null because 2 is the least recently used and removed

        System.out.println(cache);
    }
}
