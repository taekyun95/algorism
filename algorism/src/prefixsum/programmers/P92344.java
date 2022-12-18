package prefixsum.programmers;

/*
N x M 크기의 행렬 모양의 게임 맵이 있습니다.
이 맵에는 내구도를 가진 건물이 각 칸마다 하나씩 있습니다 ?? 내구도 최소 최대는?
적은 이 건물들을 공격하여 파괴하려고 합니다. ?? 파괴 조건은?
건물은 적의 공격을 받으면 내구도가 감소하고 내구도가 0이하가 되면 파괴됩니다
  => 공격 내구도 감소
  => 0이하 파괴
아군은 회복 스킬을 사용하여 건물들의 내구도를 높이려고 합니다.
  => 회복 내구도 증가
최종적으로 0이 아니면 파괴X
1 <= N, M <= 1000
1 <= 내구도 <= 1000
1 <= 스킬수 <= 250,000
skill - [type, r1, c1, r2, c2, degree]
type = 1 : 공격, 2: 파괴
r1, c1, r2, c2 = 범위
degree = 공격력, 회복량
방법1 3중 반복문
  스킬수
    행
      열
  SKILL * N * M = 최대 250,000 * 1000 * 1000 = 250,000,000,000
  효율성 테스트 위반
방법2 누적합
SKILL + 2(N * M) = 최대 250,000 + 2(1000 * 1000) = 2,250,000

 */
public class P92344 {

  public int solution(int[][] board, int[][] skill) {
    int[][] prefixSum = new int[board.length + 1][board[0].length + 1];
    // 누적합 맵 생성
    for (int[] ints : skill) {
      int type = ints[0] == 1 ? -1 : 1;
      int r1 = ints[1];
      int c1 = ints[2];
      int r2 = ints[3];
      int c2 = ints[4];
      int degree = ints[5] * type;

      prefixSum[r1][c1] += degree;
      prefixSum[r1][c2 + 1] += degree * -1;
      prefixSum[r2 + 1][c1] += degree * -1;
      prefixSum[r2 + 1][c2 + 1] += degree;
    }
    // 누적합
    for (int i = 0; i < prefixSum.length; i++) {
      for (int j = 0; j < prefixSum[0].length; j++) {
        int r = i == 0 ? 0 : prefixSum[i - 1][j];
        int c = j == 0 ? 0 : prefixSum[i][j - 1];
        int rc = i == 0 || j == 0 ? 0 : prefixSum[i - 1][j - 1];
        prefixSum[i][j] += c + r - rc;
      }
    }

    // 살아남은 건무 수 계산
    int answer = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (0 < board[i][j] + prefixSum[i][j]) {
          answer++;
        }
      }
    }
    return answer;
  }
}
