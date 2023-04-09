package etc.factorial;

import java.math.BigInteger;

public class P120840 {

  BigInteger[] dp;

  public int solution(int balls, int share) {
    dp = new BigInteger[balls + 1];
    factorialUsingForLoop(balls);
    return dp[balls].divide(dp[balls - share].multiply(dp[share])).intValue();
  }

  public void factorialUsingForLoop(int n) {
    dp[0] = BigInteger.valueOf(1);
    dp[1] = BigInteger.valueOf(1);
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1].multiply(BigInteger.valueOf(i));
    }
  }
}
