package remainder.leetcode;

public class P1010 {
// 두 노래 길이의 합이 60으로 나누어 떨어지는 모든 조합의 개수를 리턴

  //  (time[i] + time[j]) % 60 == 0인
  // n^2 방식이 떠오르는데
  // 범위 (60_000 * 500)^2 => 타임 아웃

  // 조건
  // 노래는 2개 선택
  // i < j
  // 힙이 60으로 나누어 떨어지 수
  //
  // 모든 조합의 개수

  // 그외 방식이 존재하는가?
  // 답지 확인
  // 나머지 연산은 60 이하의 수가 반복해서 나온다는 특징을 활용

  public int numPairsDivisibleBy60(int[] time) {
    // 힙이 60으로 나누어 떨어지 수 = 범위 0 ~ 59
    int[] remainder = new int[60];
    // 모든 조합의 개수
    int count = 0;
    for (int t : time) {
      if (t % 60 == 0) {
        // 60으로 나누어 떨어지는 수의 갯수만큼 추가
        count += remainder[0];
      } else {
        // 60 = x + t 으로 만들 수 있는 x의 수의 갯수만큼 추가
        count += remainder[60 - (t % 60)];
      }
      remainder[t % 60]++;
    }
    return count;
  }

  public int numPairsDivisibleBy602(int[] time) {
    // i < j
    int count = 0;
    for (int i = 0; i < time.length; i++) {
      for (int j = i + 1; j < time.length; j++) {
        if ((time[i] + time[j]) % 60 == 0) {
          count++;
        }
      }
    }
    return count;
  }
}
