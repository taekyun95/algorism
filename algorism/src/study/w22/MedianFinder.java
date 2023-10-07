package study.w22;

import java.util.*;

public class MedianFinder {

  class Simple {

    private final List<Integer> store = new ArrayList<>();

    public void addNum(int num) {
      store.add(num);
    }

    public double findMedian() {
      Collections.sort(store);
      int size = store.size();
      return (size % 2 == 1)
          ? store.get(size / 2)
          : ((double) store.get(size / 2 - 1) + store.get(size / 2)) * 0.5;
    }
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such: MedianFinder obj = new
 * MedianFinder(); obj.addNum(num); double param_2 = obj.findMedian();
 */
