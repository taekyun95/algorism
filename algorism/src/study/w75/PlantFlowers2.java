package study.w75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlantFlowers2 {

  private static final int[] DX = {0, 0, 1, -1};
  private static final int[] DY = {1, -1, 0, 0};
  private static final char HOME = 'H';
  private static final char BLOCK = '0';
  private static final char FLOWER = 'X';
  private char[][] map;
  private int n;
  private int[] col;
  private List<char[][]> result;

  public static void main(String[] args) {
    PlantFlowers2 plantFlowers = new PlantFlowers2();

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

  public List<char[][]> plant(int n, char[][] inputMap) {
    result = new ArrayList<>();
    this.map = new char[n][n];
    for (int i = 0; i < n; i++) {
      System.arraycopy(inputMap[i], 0, this.map[i], 0, n);
    }
    this.n = n;
    this.col = new int[n];
    Arrays.fill(this.col, -1);

    back(0);

    return result;
  }

  private void back(int depth) {
    if (depth == n) {
      char[][] clone = new char[n][n];
      for (int i = 0; i < n; i++) {
        System.arraycopy(map[i], 0, clone[i], 0, n);
      }
      result.add(clone);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (isColUsed(i, depth) || map[depth][i] == FLOWER || !canPlantFlower(depth, i)) {
        continue;
      }

      setFlowerAndBacktrack(depth, i);
    }
  }

  private boolean isValidPosition(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }

  private boolean isColUsed(int colIndex, int depth) {
    for (int j = 0; j < depth; j++) {
      if (col[j] == colIndex) {
        return true;
      }
    }
    return false;
  }

  private void setFlowerAndBacktrack(int depth, int i) {
    col[depth] = i;
    map[depth][i] = FLOWER;

    back(depth + 1);

    map[depth][i] = BLOCK;
    col[depth] = -1;
  }

  private boolean canPlantFlower(int x, int y) {
    for (int i = 0; i < 4; i++) {
      int newX = x + DX[i];
      int newY = y + DY[i];

      if (isValidPosition(newX, newY) && map[newX][newY] == HOME) {
        return true;
      }
    }
    return false;
  }
}
