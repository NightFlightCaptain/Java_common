package collections;

import java.util.HashMap;

/**
 * Author: 小栗旬
 * Date: 2019/4/23 19:23
 *
 * 实现的LRU队列，没有使用LinkedHashMap
 *
 */
public class LRUCache<K, V> {
    class Entry<K, V> {
        K key;
        V value;
        Entry pre;
        Entry next;

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value + " }" +
                    ", next=" + next;
        }
    }

    private Entry<K, V> first;
    private Entry<K, V> last;

    private final int MAX_SIZE;
    private int size;

    private HashMap<K, Entry<K, V>> map;

    public LRUCache(int cacheSize) {
        MAX_SIZE = cacheSize;
        size = 0;
        map = new HashMap<>(MAX_SIZE, 1);
    }

    public void put(K key, V value) {
        Entry entry = getEntry(key);
        if (entry == null) {
            if (size == MAX_SIZE) {
                remove(last.key);
            }
            entry = new Entry();
            entry.key = key;
            size++;
        }
        entry.value = value;
        moveToFirst(entry);
        map.put(key, entry);
    }

    private Entry<K, V> getEntry(K key) {
        return map.get(key);
    }

    public V get(K key) {
        Entry<K,V> entry = getEntry(key);
        if (entry == null) return null;
        moveToFirst(entry);
        return entry.value;
    }

    public void remove(K key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            if (entry.pre != null) {
                entry.pre.next = entry.next;
            } else {
                first = first.next;
            }
            if (entry.next != null) {
                entry.next.pre = entry.pre;
            } else {
                last = last.pre;
            }
            size--;
        }
        map.remove(key);
        entry.pre = null;
        entry.next = null;
    }

    private void moveToFirst(Entry entry) {
        if (entry == first) return;
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        if (first == null){
            first = last = entry;
            return;
        }
        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "first=" + first +
                '}';
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);
        lruCache.put("a", 1);
        lruCache.put("b", 2);
        lruCache.put("c", 3);
        lruCache.put("d", 4);
        lruCache.put("c", 4);
        lruCache.put("e", 4);
        lruCache.put("f", 4);
        lruCache.remove("f");
        lruCache.get("c");
        System.out.println(lruCache);
    }
}
