package study.w58;

public class Friends4Block {

  public static void main(String[] args) {
    Friends4Block friends4Block = new Friends4Block();
    int solution = friends4Block.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
    System.out.println("solution = " + solution);
  }

  public int solution(int m, int n, String[] board) {
    int answer = 0;
    char[][] map = new char[m][n];

    for (int i = 0; i < m; i++) {
      map[i] = board[i].toCharArray();
    }

    while (true) {
      boolean[][] check = new boolean[m][n];
      boolean flag = false;

      for (int i = 0; i < m - 1; i++) {
        for (int j = 0; j < n - 1; j++) {
          if (map[i][j] != ' '
              && map[i][j] == map[i + 1][j]
              && map[i][j] == map[i][j + 1]
              && map[i][j] == map[i + 1][j + 1]) {
            check[i][j] = check[i + 1][j] = check[i][j + 1] = check[i + 1][j + 1] = true;
            flag = true;
          }
        }
      }

      if (!flag) {
        break;
      }

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (check[i][j]) {
            answer++;
            for (int k = i - 1; k >= 0; k--) {
              map[k + 1][j] = map[k][j];
              map[k][j] = ' ';
            }
          }
        }
      }
    }

    return answer;
  }
}
