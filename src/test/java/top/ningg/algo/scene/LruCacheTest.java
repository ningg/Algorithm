package top.ningg.algo.scene;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCacheTest<K, V> {


    private LinkedHashMap<K, V> map = null;

    private int capacity = 0;

    private float loadFactor = 0.75f;


    public LruCacheTest(int capacity) {
        this.capacity = capacity;
        int initialSize = (int) Math.ceil(capacity / loadFactor) + 1;
        map = new LinkedHashMap<K, V>(initialSize, loadFactor, true) {
            @Override
            public boolean removeEldestEntry(Map.Entry entry) {
                return capacity < size();
            }
        };
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void clear() {
        map.clear();
    }


}
