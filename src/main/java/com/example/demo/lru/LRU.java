package com.example.demo.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/8 10:04
 * @description：
 * @modified By：
 * @version:
 */
public class LRU<K, V> extends LinkedHashMap<K, V> {

    private final int CACHE_SIZE;
    /**
     * 传递进来最多能缓存多少数据 *
     * @param cacheSize 缓存大小 */
    public LRU(int cacheSize) {
        // true 表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的 放在尾部。
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当 map 中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
        return size() > CACHE_SIZE;
    }
}


