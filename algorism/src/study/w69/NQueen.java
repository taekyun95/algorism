package study.w69;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
  int n;
  int[] rows; // rows[i] = j는 퀸이 (i, j)에 배치됨을 의미합니다.

  List<List<String>> results = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    this.n = n;
    rows = new int[n];
    Arrays.fill(rows, -1);

    backtrack(0);
    return results;
  }

  private void backtrack(int row) {
    for (int col = 0; col < n; col++) {
      if (isSafe(row, col)) {
        rows[row] = col;
        if (row == n - 1) addToOutput();
        else backtrack(row + 1);
        rows[row] = -1;
      }
    }
  }

  public void addToOutput() {
    List<String> solution = new ArrayList<>();
    for (int row = 0; row < n; row++) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (i == rows[row]) sb.append('Q');
        else sb.append('.');
      }
      solution.add(sb.toString());
    }
    results.add(solution);
  }

  public boolean isSafe(int row, int col) {
    for (int prevRow = 0; prevRow < row; prevRow++) {
      if (rows[prevRow] == col // 같은 열에 있는 경우
          || rows[prevRow] == col - row + prevRow // 같은 315도 대각선에 있는 경우
          || rows[prevRow] == col + row - prevRow // 같은 45도 대각선에 있는 경우
      ) {
        return false;
      }
    }
    return true;
  }
}
