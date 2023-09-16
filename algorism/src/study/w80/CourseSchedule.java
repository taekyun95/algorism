package study.w80;

import java.util.*;

public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];
    List<List<Integer>> graph = new ArrayList<>(numCourses);

    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] prerequisite : prerequisites) {
      int preCourse = prerequisite[1];
      int course = prerequisite[0];
      graph.get(preCourse).add(course);
      indegree[course]++;
    }

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    int nodesVisited = 0;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      nodesVisited++;
      for (int neighbor : graph.get(node)) {
        // Delete the edge "node -> neighbor".
        indegree[neighbor]--;
        if (indegree[neighbor] == 0) {
          queue.offer(neighbor);
        }
      }
    }
    return nodesVisited == numCourses;
  }
}
