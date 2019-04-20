package top.ningg.algo.scene;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import top.ningg.algo.model.BiNode;

/**
 * 题目: 实现一个 Cache, 支持 LRU
 *
 * 具体:
 *
 * 1. get: O(1) 时间复杂度
 *
 * 2. set: O(1) 时间复杂度
 *
 * 3. evictIfNecessary: O(1) 时间复杂度
 *
 * 4. 容量: capacity.
 *
 * 分析:
 *
 * 1. 数据结构: get、set 都是 O(1) 的时间复杂度, 则, 不允许遍历, 数据结构只能采用 Hash 表;
 *
 * 2. 数据结构: evictIfNecessary 也是 O(1) 的时间复杂度, 则, 必须能标识「最旧」的数据, 同时, 调整到「最旧」的数据, 也必须
 *
 * 是 O(1) 的时间复杂度, 则, 必须维护一个「按照最后使用时间排序」的链表, 同时, 能够很方便的进行链表顺序调整;
 *
 *
 * 入口:
 *
 * 1. 实现一个类: get、set、evictIfNecessary 方法, 具体, get(key)、set(key, value)
 *
 * 2. 元素: BiNode, 代表一个元素(value), 由双向链表构成
 *
 * 3. 数据结构: HashMap 存储, 设置一个 capacity
 */
public class LruCache {

    // 缓存容量
    private int capacity;
    // 缓存空间
    private HashMap<String, BiNode> cache;

    // 2 个指针:
    // a. 头指针: 最新使用的元素
    private BiNode head = null;
    // b. 尾指针: 最长时间未使用的元素
    private BiNode tail = null;

    // 构造方法
    public LruCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<String, BiNode>();
        this.head = null;
        this.tail = null;
    }

    // set 方法
    public void set(String key, Object value) {
        // 基本步骤:
        // 1. 判断 key 是否存在
        //  a. 若存在, 则, 获取-更新-截取-插入头部
        if (cache.containsKey(key)) {
            BiNode currNode = cache.get(key);
            currNode.value = value;
            BiNode cutNode = cut(currNode);
            addToHead(cutNode);
        } else {
            //  b. 若不存在, 则, 新增-插入头部
            // Note: 新增之前, 需要判断, 是否需要「删除尾部」
            evictIfNecessary();
            BiNode newNode = new BiNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
        }
    }

    // get 方法
    public BiNode get(String key) {
        // 基本步骤:
        // 1. 判断 key 是否存在
        //   a. 若存在, 则, 获取-截取-插入头部
        //   b. 若不存在, 则, 返回 null
        if (cache.containsKey(key)) {
            BiNode currNode = cache.get(key);
            BiNode cutNode = cut(currNode);
            addToHead(cutNode);
            return cutNode;
        } else {
            return null;
        }
    }

    // add 方法: 头部新增元素
    private void addToHead(BiNode node) {
        // 向头部增加, 同时影响 head 和 tail 两个指针
        // 1. 边界判断:
        //  a. 头部元素为 null, 则, 需要设置「头部指针」
        //  b. 尾部元素为 null, 则, 需要设置「尾部指针」
        // 2. 链表非空: 直接在头部, 增加元素
        if (null == head && null == tail) {
            this.head = node;
            this.tail = node;
        }

        BiNode currHead = this.head;
        node.next = currHead;
        currHead.pre = node;

        this.head = node;
    }

    // cut 方法: 剪切出元素(中间元素 or 头部元素 or 尾部元素)
    private BiNode cut(BiNode node) {
        // 基本步骤:
        // 1. 边界判断:
        //   a. 如果是头部元素, 则, 需要调整「头部指针」
        //   b. 如果是尾部元素, 则, 需要调整「尾部指针」
        // 2. 中间元素: 前后元素直接连接即可

        // 1. 边界判断:
        //   a. 如果是头部元素, 则, 需要调整「头部指针」
        if (this.head == node) {
            this.head = node.next;
            if (null != this.head) {
                this.head.pre = null;
            }
            node.next = null;
        }

        //   b. 如果是尾部元素, 则, 需要调整「尾部指针」
        if (this.tail == node) {
            this.tail = node.pre;
            if (null != this.tail) {
                this.tail.next = null;
            }
            node.pre = null;
        }

        // 2. 中间元素: 前后元素直接连接即可
        BiNode currNode = node;
        BiNode preNode = node.pre;
        BiNode nextNode = node.next;

        if (null != preNode && null != nextNode) {
            preNode.next = nextNode;
            nextNode.pre = preNode;

            currNode.pre = null;
            currNode.next = null;
        }

        return node;
    }

    // evictIfNecessary 方法
    private void evictIfNecessary() {
        // 基本步骤:
        // 1. 判断是否达到「容量上限」
        // 2. 若达到, 则, 删除最后一个 Node
        // 3. 若未达到, 则, 不做任何处理

        if (getCurrentSize() >= capacity) {
            // 删除最后一个 Node
            if (null != this.tail) {
                cache.remove(this.tail.key);

                this.tail = this.tail.pre;
                this.tail.next = null;
            }
        }
    }

    // 查询当前缓存大小
    private int getCurrentSize() {
        return cache.size();
    }

    // 输出对象
    public void print() {
        BiNode currNode = this.head;
        System.out.println("-----splitter:start----");
        while (null != currNode) {
            System.out.println(String.format("k:%s-v:%s", currNode.key, currNode.value));
            currNode = currNode.next;
        }
        System.out.println("-----splitter:end----");
    }

    public static void main(String[] args) {
        LruCache cache = new LruCache(5);

        List<String> keyList = new LinkedList<>();
        keyList.add("1");
        keyList.add("2");
        keyList.add("3");
        keyList.add("4");
        keyList.add("5");
        keyList.add("6");
        keyList.add("7");
        keyList.add("8");

        for (String singleStr : keyList) {
            cache.set(singleStr, singleStr);
        }

        cache.print();

        cache.get("2");
        cache.get("4");
        cache.get("6");

        cache.print();
    }
}
