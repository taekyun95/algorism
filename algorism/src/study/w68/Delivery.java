package study.w68;

public class Delivery {
  public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    long answer = 0L;
    // 현재 배달 가능한 상자 수
    int delBox = 0;
    // 현재 수거 가능한 상자 수
    int pickBox = 0;
    for(int i = n - 1; i >= 0; i--){
      // 내부 코드가 짧기 때문에 가독성을 위해 if문 사용
      if(deliveries[i] > 0 || pickups[i] > 0) {
        // 현재 배달/수거 가능한 상자 수에서 배달/수거 해야 하는 상자 수를 뺀다
        // 만약 수가 부족하다면 가진 상자 수가 음수가 되게 된다.
        // ex) 3(배달 가능) - 4(배달 필요) = -1 (1개 추가 배달 필요)
        // 0이 되었을 경우는 어쨌거나 해당 집에 더 이상 볼 일 없으므로 상자가 남았을 경우와 같다
        delBox -= deliveries[i];
        pickBox -= pickups[i];
        // 가진 상자 수가 음수가 되었다면, 해당 집에 추가 방문이 필요하다
        if(delBox < 0 || pickBox < 0) {
          // 필요 방문 횟수를 계산한다
          // 부족한 만큼만 계산에 이용하면 되므로,
          // 원배열이 아닌 부족한 상자수가 담긴 변수를 이용한다
          int count = Math.max((-delBox - 1) / cap + 1, (-pickBox - 1) / cap + 1);
          // 이동거리
          answer += count * (i + 1) * 2L;
          // 방문을 했다면 배달/수거 가능한 상자 수가 함께 늘어난다
          delBox += count * cap;
          pickBox += count * cap;
        }
      }
    }
    return answer;
  }
}