package study.leedcode;

import java.util.*;

public class Solution49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    // 같은 아나그램인 문자열들을 그룹핑하는 기능
    // 같은 아나그램을 찾는 기능
    // 같은 아나그램 그룹에 넣는 기능
    int[] count = new int[26];
    for(String str : strs) {
      Arrays.fill(count, 0);
      for(char c : str.toCharArray()) count[c - 'a']++;
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < 26; i++) {
        sb.append("#");
        sb.append(count[i]);
      }
      String key = sb.toString();
      if (!map.containsKey(key)) map.put(key, new ArrayList<>());
      map.get(key).add(str);
    }
    return new ArrayList<>(map.values());
  }
}
