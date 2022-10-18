package leonardo.ezio.personal.others.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 *      -LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 *      -int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *      -void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * @Description : 自定义LRU缓存策略实现
 * @Author : LeonardoEzio
 * @Date: 2022-10-18 15:22
 */
public class LRUCache {

    private int cacheSize;

    private int currentSize;

    private CacheNode head;

    private CacheNode tail;

    private Map<String,CacheNode> nodes;

    class CacheNode{

        private CacheNode pre;

        private CacheNode next;

        private String key;

        private Object value;

    }

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.currentSize = 0;
        this.nodes = new HashMap<>(cacheSize);
    }

    public void set(String key,Object value){
        if (nodes.get(key) == null){
            // 添加新元素
            CacheNode cacheNode = new CacheNode();
            cacheNode.key = key;
            cacheNode.value = value;
            nodes.put(key, cacheNode);
            // 新元素移动到表头
            moveToHead(cacheNode);
            if (currentSize >= cacheSize){
                removeTail();
            } else {
                currentSize++;
            }
        } else {
            // 更新旧元素
            CacheNode cacheNode = nodes.get(key);
            moveToHead(cacheNode);
            cacheNode.value = value;
        }
    }

    public Object get(String key){
        CacheNode cacheNode = nodes.get(key);
        if (cacheNode != null){
            moveToHead(cacheNode);
            return cacheNode.value;
        }
        return null;
    }

    public void moveToHead(CacheNode node){
        // 移动到头节点
        if (node == head){
            return;
        }
        // 1. node为中间节点
        if (node.pre != null){
            node.pre.next = node.next;
        }
        if (node.next != null){
            node.next.pre = node.pre;
        }

        // 2. 移动node到头节点
        if (head == null){
            head = node;
        } else {
            node.next = head;
            head.pre = node;
        }
        head = node;

        // 3. 若node刚好是尾节点
        if (node == tail){
            tail = tail.pre;
        }

        // 缓存中只有一个元素
        if (tail == null){
            tail = node;
        }
    }

    public void removeTail(){
        if (tail != null){
            nodes.remove(tail.key);
            if (tail.pre != null){
                tail.pre.next = null;
            }
            tail = tail.pre;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set("2","1");
        lruCache.set("3","2");
        System.out.println(lruCache.get("3"));
        System.out.println(lruCache.get("2"));
        lruCache.set("4","3");
        System.out.println(lruCache.get("2"));
        System.out.println(lruCache.get("3"));
        System.out.println(lruCache.get("4"));
        System.out.println(lruCache);
    }
}
