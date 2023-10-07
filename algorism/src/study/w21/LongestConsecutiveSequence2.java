package study.w21;

import java.util.HashMap;

public class LongestConsecutiveSequence2 {

  public int longestConsecutive(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int result = 0;
    for (int num : nums) {
      if (!map.containsKey(num)) {
        int length = 0;
        int left = num;
        int rigth = num;

        if (map.containsKey(num - 1)) {
          length += map.get(num - 1);
          left = num - map.get(num - 1);
        }
        if (map.containsKey(num + 1)) {
          length += map.get(num + 1);
          rigth = map.get(num + 1);
        }
        map.put(num, length);
        map.put(left, length);
        map.put(rigth, length);
        result = Math.max(result, length);
      }
    }
    return result;
  }
}
