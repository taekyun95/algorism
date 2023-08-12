package study.w75;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PlantFlowers {
  private final int[] dx = {-1, 0, 1, 0};
  private final int[] dy = {0, 1, 0, -1};
  private int n;
  private char[][] map;
  private List<char[][]> results;

  public static void main(String[] args) {
    PlantFlowers plantFlowers = new PlantFlowers();

    char[][][] testMaps = {
      {
        {'H', '0', '0', '0'},
        {'H', '0', '0', '0'},
        {'0', '0', '0', 'H'},
        {'0', '0', '0', 'H'}
      },
      {
        {'0', '0', 'H', '0'},
        {'0', '0', '0', '0'},
        {'0', 'H', '0', '0'},
        {'H', 'H', '0', '0'}
      },
      {
        {'0', '0', '0', '0', 'H'},
        {'0', '0', '0', '0', '0'},
        {'0', '0', 'H', '0', 'H'},
        {'H', '0', '0', '0', '0'},
        {'H', '0', '0', '0', '0'}
      }
    };

    for (char[][] testMap : testMaps) {
      List<char[][]> results = plantFlowers.plant(testMap.length, testMap);
      System.out.println("Result for n = " + testMap.length + ":");
      for (char[][] result : results) {
        for (char[] row : result) {
          for (char cell : row) {
            System.out.print(cell + " ");
          }
          System.out.println();
        }
        System.out.println("------------");
      }
    }
  }

  public List<char[][]> plant(int n, char[][] map) {
    this.n = n;
    this.map = map;
    results = new ArrayList<>();
    backtrack(0);

    return results;
  }

  private boolean isValid(char[][] map, int x, int y) {
    if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
      return false;
    }

    if (map[x][y] != '0') {
      return false;
    }

    // 상하 좌우 검사
    for (int i = 0; i < map.length; i++) {
      if (map[i][y] == 'X' || map[x][i] == 'X') {
        return false;
      }
    }
    return true;
  }

  private void backtrack(int houseIndex) {
    if (houseIndex == n) {
      char[][] copy = new char[n][n];
      IntStream.range(0, n).forEach(i -> System.arraycopy(map[i], 0, copy[i], 0, n));
      results.add(copy);
      return;
    }

    int x = -1, y = -1;
    // 집('H')의 위치 찾기
    for (int i = 0; i < n && x == -1; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 'H') {
          x = i;
          y = j;
          break;
        }
      }
    }

    if (x == -1) return;

    map[x][y] = 'h'; // 소문자로 방문 표시
    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k];
      int ny = y + dy[k];
      if (isValid(map, nx, ny)) {
        map[nx][ny] = 'X';
        backtrack(houseIndex + 1);
        map[nx][ny] = '0'; // Revert
      }
    }
    map[x][y] = 'H'; // Revert house to unvisited
  }
}
