package study.w71;

public class NumberOfIslands {
  boolean[][] visited;
  char[][] grid;
  int[] dx = {0, 0, -1, 1};
  int[] dy = {1, -1, 0, 0};

  public int numIslands(char[][] grid) {
    visited = new boolean[grid.length][grid[0].length];
    this.grid = grid;
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] != '0'){
          dfs(i,j);
          count++;
        }
      }
    }
    return count;
  }


  private void dfs(int x, int y) {
    if (visited[x][y] || grid[x][y] == '0') {
      return;
    }
    visited[x][y] = true;
    for(int i = 0; i < 4; i++) {
      int dxx = dx[i] + x;
      int dyy = dy[i] + y;
      if (dxx >= 0 && dxx < grid.length && dyy >= 0 && dyy < grid[0].length) {
        dfs(dxx, dyy);
      }
    }
  }
}
