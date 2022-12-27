package etc;

import java.util.Arrays;

public class P77484 {

  // 숫자 범위: 1 ~ 45
  // 방법 1 2중 반복
  // 시간 N^2
  // 방법 2 two pointer
  // 시간 N


  // 목표:
  // 최고 순위
  // 최저 순위

  // 풀이
  // 최고 순위: 일치한 갯수, 일치한 횟수를 순위로 변환하는 기능, 가져진 숫자 갯수
  // 최저 순위: 일치한 갯수, 일치한 횟수를 순위로 변환하는 기능,

  // 가져진 숫자 갯수: 0을 count
  // 일치한 횟수를 순위로 변환하는 기능: 배열 index = 일치한 횟수, value = 순위
  // 일치한 갯수: two pointer

  // two pointer: lottos,  win_nums 정렬


  // 1위 6개 번호 모두 일치
  // 2위 5개 번호 일치
  // 3위 4개 번호 일치
  // 4위 3개 번호 일치
  // 5위 2개 번호 일치
  // 6위 1개, 0개 번호 일치
  int[] rank = new int[]{6, 6, 5, 4, 3, 2, 1};

  public int[] solution(int[] lottos, int[] win_nums) {

    Arrays.sort(lottos);
    Arrays.sort(win_nums);

    // 0 갯수 찾기
    // 상황: 일부 숫자 가려짐
    // 0: 가져인 숫자
    int zeroCount = 0;
    for (int lotto : lottos) {
      if (lotto == 0) {
        zeroCount++;
      } else {
        break;
      }
    }

    int matchCount = 0;
    int i = zeroCount;
    int j = 0;
    // 0 제외한 숫자 일치 갯수 찾기
    // 순서는 상관하지 않는다.
    while (i < lottos.length && j < win_nums.length) {
      if (lottos[i] < win_nums[j]) {
        i++;
      } else if (win_nums[j] < lottos[i]) {
        j++;
      } else {
        matchCount++;
        i++;
        j++;
      }
    }

    // 원하는 것: 최고 순위, 최저 순위
    // 최고 순위: 가져진 모두 숫자 일치
    // 최저 순쉬: 가져린 모두 숫자 불일치
    return new int[]{rank[matchCount + zeroCount], rank[matchCount]};
  }

  public static void main(String[] args) {
    P77484 p = new P77484();
    int[] solution = p.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
    System.out.println(solution[0] + ", " + solution[1]);
  }
}
