package top.ningg.algo.scene;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU Cache: 基于 LinkedHashMap 方式实现.
 */
public class LruCacheWithLinkedHashMap<K, V> {

    public static final float hashLoadFactor = 0.75f;

    private LinkedHashMap<K, V> map;

    private int cacheSize;

    public LruCacheWithLinkedHashMap(int cacheSize) {
        this.cacheSize = cacheSize;
        int capacity = (int) Math.ceil(cacheSize / hashLoadFactor) + 1;
        boolean accessOrder = true;

        //LinkedHashMap(int initialCapacity,float loadFactor,boolean accessOrder)
        //initialCapacity:初始化容量,loadFactor:加载因子(一般是0.75f),accessOrder:排序方式 false 基于插入顺序 true 基于访问顺序

        // 初始化缓存
        map = new LinkedHashMap<K, V>(capacity, hashLoadFactor, accessOrder) {

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void set(K key, V value) {
        map.put(key, value);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int usedSize() {
        return map.size();
    }

    public void print() {
        for (Map.Entry<K, V> singleEntry : map.entrySet()) {
            System.out.println(String.format("k:%s-v:%s", singleEntry.getKey(), singleEntry.getValue()));
        }
    }

    public static void main(String[] args) {
        LruCacheWithLinkedHashMap cache = new LruCacheWithLinkedHashMap(3);

        cache.set(1, 11);
        cache.set(2, 22);
        cache.set(3, 33);
        cache.set(4, 44);
        cache.set(5, 55);
        cache.set(6, 66);
        cache.get(5);
        cache.set(7, 77);
        cache.set(8, 88);

        cache.print();
    }

}
