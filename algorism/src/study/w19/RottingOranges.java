package study.w19;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
  int[] dx = new int[] {1, -1, 0, 0};
  int[] dy = new int[] {0, 0, 1, -1};

  public static void main(String[] args) {
    RottingOranges rottingOranges = new RottingOranges();
    rottingOranges.orangesRotting(new int[][] {{1, 2}});
  }

  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    Queue<Pos> q = new ArrayDeque<>();
    boolean[][] visits = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          visits[i][j] = true;
          q.add(new Pos(i, j));
        }
      }
    }
    int level = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      boolean visit = false;
      for (int i = 0; i < size; i++) {
        Pos pos = q.poll();
        for (int j = 0; j < 4; j++) {
          int nx = pos.x + dx[j];
          int ny = pos.y + dy[j];
          if (ny < 0 || nx < 0 || nx >= m || ny >= n || visits[nx][ny] || grid[nx][ny] != 1) {
            continue;
          }
          visit = true;
          visits[nx][ny] = false;
          q.add(new Pos(nx, ny));
          grid[nx][ny] = 2;
        }
      }
      if (visit) level++;
    }

    for (int[] ints : grid) {
      for (int j = 0; j < n; j++) {
        if (ints[j] == 1) {
          return -1;
        }
      }
    }

    return level;
  }

  class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
