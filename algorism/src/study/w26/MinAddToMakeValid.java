package study.w26;

public class MinAddToMakeValid {
  // )가 남는 경우 수 + ( 남은 갯수
  public int minAddToMakeValid(String S) {
    int ans = 0, bal = 0;
    for (int i = 0; i < S.length(); ++i) {
      bal += S.charAt(i) == '(' ? 1 : -1;
      if (bal == -1) {
        ans++;
        bal++;
      }
    }

    return ans + bal;
  }
}
