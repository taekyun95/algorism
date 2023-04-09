package w56;

public class SecretMap {

  /*
  의도
    이진수와 정수 사이의 변환을 이해하고 다룰 수 있는 능력을 평가합니다.
    배열 및 문자열 조작 기술을 평가합니다.
    두 개의 지도 정보를 합쳐서 하나의 완성된 지도를 만드는 논리적 사고 능력을 평가합니다.

  비밀 지도 해독
    숫자를 2진수로 변환
      2진수를 비교
    결과 출력 - 담을 곳이 필요
   */
  public String[] solution2(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    for (int i = 0; i < n; i++) {
      int b = arr1[i] | arr2[i];
      StringBuilder sb = new StringBuilder();
      String s = Integer.toBinaryString(b);
      for (int j = 0; j < n - s.length(); j++) {
        sb.append(' ');
      }
      for (int j = 0; j < s.length(); j++) {
        char c = s.charAt(j) == '1' ? '#' : ' ';
        sb.append(c);
      }

      answer[i] = sb.toString();
    }
    return answer;
  }

  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    for (int i = 0; i < n; i++) {
      int combined = arr1[i] | arr2[i];
      StringBuilder sb = new StringBuilder();

      /*
        for (int j = 0; j < n - s.length(); j++) {
          sb.append(' ');
        }
        위 코드가 필요없는 이유는 n자리 숫자부터 확인하기 때문이다.
       */
      for (int j = n - 1; j >= 0; j--) {
        char c = ((combined & (1 << j)) != 0) ? '#' : ' ';
        sb.append(c);
      }

      answer[i] = sb.toString();
    }

    return answer;
  }

  public static void main(String[] args) {
    SecretMap secretMap = new SecretMap();
    String[] strings = secretMap.solution(5, new int[]{46, 33, 33, 22, 31, 50},
        new int[]{27, 56, 19, 14, 14, 10});
    System.out.println(strings.toString());
  }

  public String[] solution1(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    // n으로 하는 이유는 자리수 때문이다.
    for (int i = 0; i < n; i++) {
      int b = (arr1[i] | arr2[i]);
      String s = "";
      for (int j = 0; j < n; j++) {
        String s1 = (b & 1) == 1 ? "#" : " ";
        s = s1 + s;
        b = b >> 1;
      }
      answer[i] = s;
    }
    return answer;
  }
}
