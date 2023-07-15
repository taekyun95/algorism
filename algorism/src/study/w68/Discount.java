package study.w68;

public class Discount {
  public int[] solution(int[][] users, int[] emoticons) {

    int[][] map = new int[users.length][4];
    for (int i = 0; i < users.length; i++) {
      for (int j = 0; j < emoticons.length; j++) {
        for (int k = 10; k <= 40; k += 10) {
          if (users[i][0] <= k) {
            map[i][k/10] += emoticons[j];
          }
        }
      }
    }
    int subscribe = 0;
    int 판매액 = 0;
    for(int i = 0; i < 4; i++) {
      for (int j = 0; j < users.length; j++) {
        if(map[j][i] >= users[j][1]){
            subscribe++;
        }else{
          판매액 += map[j][i];
        }
      }
    }



    int[] answer = {};
    return answer;
  }
}
