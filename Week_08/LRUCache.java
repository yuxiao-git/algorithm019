package Week_08;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class LRUNode {
        int key;
        int value;
        LRUNode prev;
        LRUNode next;

        public LRUNode() {
        }

        public LRUNode(int key, int value) {
            key = key;
            value = value;
        }
    }

    private Map<Integer, LRUNode> cache = new HashMap<>();
    private int size;// 大小
    private int capacity;
    private LRUNode head, tail;//  头尾节点

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        this.head = new LRUNode();
        this.tail = new LRUNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 查找并设置为最近使用
        LRUNode node = cache.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 先插队列中是否存在，存在则设置为最近使用，不存在则最近新增
        LRUNode node = cache.get(key);
        if (node != null) {
            moveToHead(node);
        } else {
            node = new LRUNode(key, value);
            addAtHead(node);
        }
    }

    // 将节点删除
    private void removeNode(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    // 将节点添加到最前面
    private void addAtHead(LRUNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // 将节点移动到最前面
    private void moveToHead(LRUNode node) {
        removeNode(node);
        addAtHead(node);
    }

}
