package w52;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class P210 {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] indegree = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      int from = prerequisite[1];
      int to = prerequisite[0];
      indegree[to]++;
      map.putIfAbsent(from, new HashSet<>());
      map.get(from).add(to);
    }
    Queue<Integer> q = new ArrayDeque<>();
    for (int i : indegree) {
      if (i == 0) {
        q.add(i);
      }
    }

    int[] result = new int[numCourses];
    int idx = 0;
    while (!q.isEmpty()) {
      Integer cur = q.poll();
      result[idx++] = cur;
      if (map.containsKey(cur)) {
        for (Integer integer : map.get(cur)) {
          indegree[integer]--;
          if (indegree[integer] == 0) {
            q.add(integer);
          }
        }
      }
    }
    return idx == numCourses ? result : new int[]{};
  }
}
