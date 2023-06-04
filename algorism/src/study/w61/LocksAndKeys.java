package study.w61;

/*
잠겨있는 자물쇠는 격자 한 칸의 크기가 1 x 1인 N x N 크기의 정사각 격자 형태
    특이한 모양의 열쇠는 M x M 크기인 정사각 격자 형태로 되어 있습니다.

    자물쇠에는 홈이 파여 있고 열쇠 또한 홈과 돌기 부분이 있습니다

    열쇠는 회전과 이동이 가능

    열쇠의 돌기 부분을 자물쇠의 홈 부분에 딱 맞게 채우면 자물쇠가 열리게 되는 구조

    자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠를 여는 데 영향을 주지 않지만

    자물쇠 영역 내에서는 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 하며
    열쇠의 돌기와 자물쇠의 돌기가 만나서는 안됩니다.

    자물쇠를 열수 있으면 true를, 열 수 없으면 false를 return 하도록 solution 함수를 완성해주세요.

    // 이동하는 로직
    // 90도로 회전한는 로직
    // 비교하는 로직
    4(n - m)^2
 */
public class LocksAndKeys {

  public boolean solution(int[][] key, int[][] lock) {
    int holes = 0, ln = lock.length, kn = key.length;
    for (int i = 0; i < ln; i++) {
      for (int j = 0; j < ln; j++) {
        holes += lock[i][j] == 0 ? 1 : 0;
      }
    }
    if (holes == 0) return true;

    for (int rotate = 0; rotate < 4; rotate++) {
      // 이동하는 로직 (자물쇠 겨예 바깥으로 움직일 수 있어야한다.)
      for (int i = -kn + 1; i < ln; i++) {
        for (int j = -kn + 1; j < ln; j++) {
          // 비교하는 로직
          boolean possible = insert(lock, key, i, j, holes);
          if (possible) return true;
        }
      }
      // 회전하는 로직
      int[][] newKey = new int[kn][kn];
      for (int i = 0; i < kn; i++) {
        for (int j = 0; j < kn; j++) {
          newKey[j][kn - i - 1] = key[i][j];
        }
      }
      key = newKey;
    }

    return false;
  }

  private boolean insert(int[][] lock, int[][] key, int y, int x, int holes) {
    for (int i = 0; i < key.length; i++) {
      for (int j = 0; j < key[i].length; j++) {
        int ny = y + i, nx = x + j;
        if (ny < 0 || nx < 0 || ny >= lock.length || nx >= lock[ny].length) {
          continue;
        }

        if (key[i][j] == 1) {
          if (lock[ny][nx] == 1) return false;
          holes--;
        }
      }
    }

    return holes == 0;
  }
}
