package study.w22;

public class MaximalSquare {
  public static void main(String[] args) {
    MaximalSquare ms = new MaximalSquare();
    // [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    int anwser =
        ms.maximalSquare2(
            new char[][] {
              {'1', '0', '1', '0', '0'},
              {'1', '0', '1', '1', '1'},
              {'1', '1', '1', '1', '1'},
              {'1', '0', '0', '1', '0'}
            });
    System.out.println(anwser);
  }

  public int maximalSquare(char[][] matrix) {
    int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
    int max = 0;

    for (int i = 1; i <= matrix.length; i++) {
      for (int j = 1; j <= matrix[0].length; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
          max = Math.max(max, dp[i][j]);
        }
      }
    }

    return max * max;
  }

  public int maximalSquare2(char[][] matrix) {
    int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
    int[] dp = new int[cols + 1];
    int max = 0;
    int prev = 0;

    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        int temp = dp[j];
        if (matrix[i - 1][j - 1] == '1') {
          dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
          max = Math.max(max, dp[j]);
        } else {
          dp[j] = 0;
        }

        prev = temp;
      }
    }
    return max * max;
  }
}
