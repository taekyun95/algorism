package study.w58;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Cache {

    /*
      캐시 크기를 얼마로 해야 효율적인지 몰라 난감한 상황이다.
    DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램

    입력 형식
    캐시 크기(cacheSize)와 도시이름 배열(cities)을 입력받는다.
    cacheSize는 정수이며, 범위는 0 ≦ cacheSize ≦ 30 이다.
    cities는 도시 이름으로 이뤄진 문자열 배열로, 최대 도시 수는 100,000개이다.
    각 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성되며, 대소문자 구분을 하지 않는다. 도시 이름은 최대 20자로 이루어져 있다.
    출력 형식
    입력된 도시이름 배열을 순서대로 처리할 때, "총 실행시간"을 출력한다.
    조건
    캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
    cache hit일 경우 실행시간은 1이다.
    cache miss일 경우 실행시간은 5이다.
   */

  public int solution(int cacheSize, String[] cities) {
    if (cacheSize == 0) {
      return cities.length * 5;
    }

    Set<String> set = new HashSet<>();
    Deque<String> deque = new ArrayDeque<>();
    int result = 0;

    for (String city : cities) {
      city = city.toLowerCase();
      // 캐시 hit
      if (set.contains(city)) {
        result++;
        deque.remove(city);
        deque.offerFirst(city);
      }
      // 캐시 miss
      else {
        result += 5;
        if (deque.size() == cacheSize) {
          String pollLast = deque.pollLast();
          set.remove(pollLast);
        }
        deque.offerFirst(city);
        set.add(city);
      }
    }
    return result;
  }

  public int solution2(int cacheSize, String[] cities) {
    if (cacheSize == 0) {
      return cities.length * 5;
    }

    Map<String, Integer> cache = new LinkedHashMap<>(cacheSize, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return this.size() > cacheSize;
      }
    };

    int result = 0;

    for (String city : cities) {
      city = city.toLowerCase();
      // 캐시 hit
      if (cache.containsKey(city)) {
        result++;
      }
      // 캐시 miss
      else {
        result += 5;
      }
      cache.put(city, 1);
    }
    return result;
  }
}
