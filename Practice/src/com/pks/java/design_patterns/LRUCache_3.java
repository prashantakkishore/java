package com.pks.java.design_patterns;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache_3<K,V> {

    public static void main(String[] args) {
        LRUCache_3 cache = new LRUCache_3<Integer, Integer>(3);
        cache.put(2,20);
        cache.put(3,30);
        cache.put(4,40);
        System.out.println(cache.get(2));
        cache.put(5,50);
        cache.print();
    }

    private Map<K, Node> map = new HashMap<>();
    private Deque<Node> deque = new LinkedList();
    private Integer cacheSize;

    LRUCache_3(Integer size){
        cacheSize = size;
    }

    public void put(K key, V value){
            Node node = new Node(key, value);
            map.put(key, node);
            deque.addFirst(node);

            if (map.size() > cacheSize) {
                // remove eldest
                Node value1 = deque.removeLast();
                map.remove(value1.key);
            }

    }

    public V get(K key){
        Node value = map.get(key);
        if(value != null) {
            Node newValue = new Node(key, value.value);
            deque.remove(value);
            deque.addFirst(newValue);
            map.put(key, newValue);
        }
        return (V)value.value;
    }

    public void print(){
        System.out.println("Map -> ");
        map.forEach((k,v) -> System.out.println(k + " -> " + v));
        System.out.println("DLL -> ");
        deque.forEach(v -> System.out.println(v));
    }


    class Node<K,V> {
        K key;
        V value;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

}
