package algorism;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

  private final int capacity;
  private final LinkedHashMap<Integer, Integer> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    // 정수 개수로 초기 크기를 설정하려면 capacity를 인수로 전달하고 로드 팩터를 1로 설정합니다.
    cache = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
      private static final long serialVersionUID = 1L;

      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > LRUCache.this.capacity;
      }
    };
  }

  public int get(int key) {
    return cache.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    cache.put(key, value);
  }
}
