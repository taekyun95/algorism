package study.w63;

public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int zeroCount = 0;
        int equalCount = 0;
        for (int lotto : lottos) {
            // 0 객수 찾기
            if (lotto == 0) zeroCount += 1;
                // 맞는 횟수 찾기
            else {
                for (int win_num : win_nums) {
                    if (win_num == lotto) {
                        equalCount += 1;
                    }
                }
            }
        }

        int maxCount = equalCount + zeroCount;

        return new int[] {rank[maxCount], rank[equalCount]};
    }
}
