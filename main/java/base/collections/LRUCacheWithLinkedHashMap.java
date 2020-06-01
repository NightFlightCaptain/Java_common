package base.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: 小栗旬
 * @Date: 2020/3/6 20:40
 */
public class LRUCacheWithLinkedHashMap<K,V> extends LinkedHashMap<K,V>{
    private int capacity;

    public LRUCacheWithLinkedHashMap(int size){
        super(16,0.75f,true);
        this.capacity = size;
    }



    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheWithLinkedHashMap<String,Integer> map = new LRUCacheWithLinkedHashMap<>(3);
        map.put("1",1);
        map.put("2",3);
        map.put("3",3);
        map.put("4",4);
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        map.get("2");
        map.put("5",5);
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
