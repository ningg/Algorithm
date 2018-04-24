package top.ningg.algo;

import java.util.HashMap;
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
 * 3. evict: O(1) 时间复杂度
 *
 * 4. 容量: capacity.
 *
 * 分析:
 *
 * 1. 数据结构: get、set 都是 O(1) 的时间复杂度, 则, 不允许遍历, 数据结构只能采用 Hash 表;
 *
 * 2. 数据结构: evict 也是 O(1) 的时间复杂度, 则, 必须能标识「最旧」的数据, 同时, 调整到「最旧」的数据, 也必须
 *
 * 是 O(1) 的时间复杂度, 则, 必须维护一个「按照最后使用时间排序」的链表, 同时, 能够很方便的进行链表顺序调整;
 *
 *
 * 入口:
 *
 * 1. 实现一个类: get、set、evict 方法, 具体, get(key)、set(key, value)
 *
 * 2. 元素: BiNode, 代表一个元素(value), 由双向链表构成
 *
 * 3. 数据结构: HashMap 存储, 设置一个 capacity
 */
public class LruCache {

    // 缓存容量
    private int capacity;
    // 缓存空间
    private HashMap<String, BiNode> cache = new HashMap<>();

    // 2 个指针:
    // a. 头指针
    private BiNode head = null;
    // b. 尾指针
    private BiNode tail = null;

    // 构造方法
    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    // set 方法
    public BiNode set(String key, Object value) {
        // 基本步骤:
        // 1. 判断 key 是否存在
        // 2. 若不存在, 则, 新增
        // 3. 若存在, 则, 截取-更新-新增
        // 4. 判断是否进行 LRU(Least Recently Used)
        // TODO

        return null;
    }

    // get 方法
    public BiNode get(String key) {
        // 基本步骤:
        // 1. 判断 key 是否存在
        // 2. 若不存在, 则, 返回 null
        // 3. 若存在, 则, 截取-新增
        // TODO
        return null;
    }

    // add 方法: 头部新增元素
    private BiNode addToHead(BiNode node) {
        // 向头部增加, 同时影响 head 和 tail 两个指针
        // TODO
        return null;
    }

    // remove 方法: 剪切出元素(中间元素 or 头部元素 or 尾部元素)
    private BiNode remove(BiNode node) {
        // 基本步骤:
        // 1. 边界判断:
        // a. 如果是头部元素, 则, 需要调整头部指针
        // TODO
        return null;
    }

    // evict 方法
    private void evict() {
        // TODO
        // 基本步骤:
        // 1. 判断是否达到「容量上限」
        // 2. 若达到, 则, 删除最后一个 Node
        // 3. 若未达到, 则, 不做任何处理
    }
}
