package study.w65;

public class SumSameQueue {
  public int solution(int[] queue1, int[] queue2) {
    int n = queue1.length;
    long sum1 = 0, sum2 = 0;
    for (int i = 0; i < n; i++) {
      sum1 += queue1[i];
      sum2 += queue2[i];
    }
    if ((sum1 + sum2) % 2 == 1) {
      return -1;
    }

    long targetSum = (sum1 + sum2) / 2;
    if (sum1 == targetSum) {
      return 0;
    }

    int front1 = 0, front2 = 0;
    int operations = 0;
    while (sum1 != targetSum && front1 < n && front2 < n) {
      if (sum1 < targetSum) {
        sum1 += queue2[front2++];
      } else {
        sum1 -= queue1[front1++];
      }
      operations++;
    }
    return (sum1 != targetSum) ? -1 : operations;
  }

  public static void main(String[] args) {
    SumSameQueue sumSameQueue = new SumSameQueue();
    int[] queue1 = {3, 2, 7, 2};
    int[] queue2 = {4, 6, 5, 1};
    System.out.println(sumSameQueue.solution(queue1, queue2));

    queue1 = new int[] {1, 2, 1, 2};
    queue2 = new int[] {1, 10, 1, 2};
    System.out.println(sumSameQueue.solution(queue1, queue2));

    queue1 = new int[] {1, 1};
    queue2 = new int[] {1, 5};
    System.out.println(sumSameQueue.solution(queue1, queue2));
  }
}
