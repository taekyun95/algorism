package minimax.programmers;

// 플레이어 A,B
// 양 플레이어가 캐릭터를 몇 번 움직이게 될지 예측

// 정사각 격자
// 1:발판이 있는 부분
// 0:발판이 없는 부분

// 패배 조건
// 이동할 수 할 수 없는 경우
// 이동할 턴에 현재 발판이 없는경우

// 이동 방향: 상하좌우

// 이동 조건:
// 발판 존재
// 필드 안

// 이동후: 발판이 사라짐

//  양 플레이어는 번갈아가며
// 자기 차례에 자신의 캐릭터를
// 로 인접한 4개의 칸 중에서
// 2가지 상황에서 패자와 승자가 정해 결정

// 승자는 최대한 빨리 승리하도록 플레이
// 패자는 최대한 오래 버티도록 플레이

// 승리를 확인하는 방법
  // 깊이가 홀수면 A가 승리
  // 깊이가 짝수면 B가 승리
public class P92345 {

  public static void main(String[] args) {
    P92345 p92345 = new P92345();
    int[][] board = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    int[][] board2 = {{1, 1, 1, 1, 1}};
    int[] aloc = {1, 0};
    int[] aloc2 = {0, 0};
    int[] bloc = {1, 2};
    int[] bloc2 = {0, 4};

    System.out.println(p92345.solution(board2, aloc2, bloc2));
  }

  int[][] board;
  int N;
  int M;
  int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public int solution(int[][] board, int[] aloc, int[] bloc) {
    this.board = board;
    this.N = board.length;
    this.M = board[0].length;
    return dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
  }

  // 반환 값이 홀수 : A 플레이어가 승리함을 의미
  // 반환 값이 짝수 : B 플레이어가 승리함을 의미
  public int dfs(int myTurnX, int myTurnY, int yourTurnX, int yourTurnY) {
    // 패배 조건: 이동할 턴에 현재 발판이 없는경우
    if (board[myTurnX][myTurnY] == 0) {
      return 0;
    }

    int ret = 0;

    // 이동 방향: 상하좌우
    for (int[] dir : dirs) {
      int nextX = myTurnX + dir[0];
      int nextY = myTurnY + dir[1];

      // 이동 조건: 필드 안
      if (outOfBounds(nextX, N) || outOfBounds(nextY, M)) {
        continue;
      }
      // 이동 조건: 발판 존재
      if (board[nextX][nextY] == 0) {
        continue;
      }

      // 이동후: 발판이 사라짐
      board[myTurnX][myTurnY] = 0;

      // depth: 턴의 수
      int depth = dfs(yourTurnX, yourTurnY, nextX, nextY) + 1;
      board[myTurnX][myTurnY] = 1;

      // 플레이어 A가 이긴 경우
      if (depth % 2 == 1) {
        // 저장된 턴이 플레이어 A가 이긴 경우
        if (ret % 2 == 1) {
          // 승자는 최대한 빨리 승리하도록 플레이
          ret = Math.min(ret, depth);
        }
        // 저장된 턴이 플레이어 A가 진 경우
        else {
          // 이긴 걸 기록
          ret = depth;
        }
      }
      // 플레이어 A가 진 경우 && 저장된 턴에 플레이어 A가 진 경우
      else if (depth % 2 == 0 && ret % 2 == 0) {
        // 패자는 최대한 오래 버티도록 플레이
        ret = Math.max(ret, depth);
      }
    }
    return ret;
  }

  public boolean outOfBounds(int index, int size) {
    return index < 0 || size <= index;
  }
}