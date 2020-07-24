package demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther
 */

public class LRUCache {

    class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }


    Map<Integer, Node> data = new HashMap<>();
    Node head = null;
    Node tail = null;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

    }

    public int get(int key) {
        if (!data.containsKey(key)) {
            throw new UnsupportedOperationException();
        }
        Node node = data.get(key);
        deleteNode(node);
        setHead(node);
        return node.val;
    }

    public void set(int key, int val) {
        Node node = new Node(val);
        data.put(key, node);
        if (data.size() > capacity) {
            removeEnd();
        }
        setHead(node);
    }

    private void removeEnd() {
        data.remove(tail.val);
        if (tail.prev != null) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            tail = null;
            head = null;
        }
    }

    private void setHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

    }

    private void deleteNode(Node node) {
        if (node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else if (node.prev != null) {
            node.prev.next = null;
            tail = node.prev;
            node.prev = null;
        } else {
            node.next.prev = null;
            head = node.next;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.set(1, 1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
        System.out.println(cache.get(2));
        cache.set(5,5);
        System.out.println(cache.get(3));
    }
}
