package study.w51;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class P127 {

  public int ladderLength(String beginWord, String endWord, List<String> wl) {
    // 그래프 제작
    wl.add(beginWord);
    wl.add(endWord);

    Map<String, Set<String>> map = new HashMap<>();
    for (String w : wl) {
      char[] arr = w.toCharArray();
      // 하나가 다르걸 모르기 때문에 한자리의 단어 바꿔서 확인한다.
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < 26; j++) {
          arr[i] = (char) ((int) 'a' + j);
          String tmp = new String(arr);
          if (wl.contains(tmp) && !tmp.equals(w)) {
            map.putIfAbsent(w, new HashSet<>());
            map.putIfAbsent(tmp, new HashSet<>());
            map.get(w).add(tmp);
            map.get(tmp).add(w);
          }
        }
      }
    }
    // 최단 경로
    int result = 1;
    Queue<String> q = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    if (map.containsKey(beginWord)) {
      q.addAll(map.get(beginWord));
      visited.add(beginWord);
    }

    while (!q.isEmpty()) {
      int size = q.size();
      result++;
      for (int i = 0; i < size; i++) {
        String next = q.poll();
        if (next.equals(endWord)) {
          return result;
        }
        for (String s : map.get(next)) {
          if (!visited.contains(s)) {
            q.add(s);
            visited.add(s);
          }
        }
      }
    }
    return 0;

  }
}
