package study.w59;

import java.util.Arrays;

public class FailureRate {
    public static void main(String[] args) {
        FailureRate failureRate = new FailureRate();
        failureRate.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }

    public int[] solution(int N, int[] stages) {
        // 스테이지에 몇명일 있는지 담는 변수
        int[] position = new int[N + 2];
        for (int stage : stages) {
            position[stage]++;
        }

        // 스테이지를 진행한 모든 사람의 수
        int[] all = position.clone();
        for (int i = all.length - 2; 0 <= i; i--) {
            all[i] += all[i + 1];
        }
//        int[][] cal = new int[n][2];
//        for (int i = 1; i < N + 1; i++) {
//            cal[i][0] =
//            cal[i][1] =
//        }

       return null;
    }
}