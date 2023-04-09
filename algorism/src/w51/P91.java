package w51;

public class P91 {

  int[] remember;

  public void numDecodings(String s) {
    // s == "0" 일 때 - 예지 케이스
    if (s.charAt(0) == '0') {
      System.out.println(0);
      return;
    }

    remember = new int[s.length() + 1];
    remember[0] = remember[1] = 1;
    dp(s, 2);
    System.out.println(remember[s.length()]);
  }

  private static boolean 십에서이십육까지(char c, char pc) {
    return pc == '1' || (pc == '2' && c <= '6');
  }


  // 이런 결과에 현재가 형향을
  public void dp(String s, int index) {
    if (s.length() < index) {
      return;
    }
    char c = s.charAt(index - 1);
    if (c != '0') {
      remember[index] += remember[index - 1];
    }
    char prevC = s.charAt(index - 2);

    if (십에서이십육까지(c, prevC)) {
      remember[index] += remember[index - 2];
    }
    dp(s, index + 1);
  }

  public int inter(String s) {
    // 0의 자리의 경우 수는 1이다
    int prev = 1;
    int pprev = 1;
    for (int i = 1; i < s.length(); i++) {

      char c = s.charAt(i);
      // c가 0일 경우 필터
      int cur = 0;
      if (c != '0') {
        cur += prev;
      }
      char prevC = s.charAt(i - 1);

      if (십에서이십육까지(c, prevC)) {
        cur += pprev;
      }
      pprev = prev;
      prev = cur;
    }
    return prev;
  }


  public static void main(String[] args) {
    P91 p91 = new P91();
    System.out.println("-----------------");
    System.out.println("-------------");
    p91.numDecodings("1239882379358239123");
    System.out.println("-------------");
    p91.numDecodings(
        "1239882379358239123123988237935823912312398823793582391231239882379358239123");
  }
}
