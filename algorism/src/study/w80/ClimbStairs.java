package study.w80;

public class ClimbStairs {
  int n;
  int[] dp;

  public int climbStairs(int n) {
    this.n = n;
    this.dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 2;
    re(2);
    return dp[n];
  }

  public void re(int index){
    if(index > n) return;
    dp[index] = dp[index - 1] + dp[index - 2];
    re(index + 1);
  }
  public int climbStairs2(int n) {
    if (n == 1) {
      return 1;
    }
    int first = 1;
    int second = 2;
    for (int i = 3; i <= n; i++) {
      int third = first + second;
      first = second;
      second = third;
    }
    return second;
  }
}
