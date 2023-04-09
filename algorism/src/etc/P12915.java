package etc;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P12915 {

  PriorityQueue<String>[] list = new PriorityQueue[26];

  public static void main(String[] args) {
    P12915 p12915 = new P12915();
    p12915.solution(new String[]{"sun", "bed", "car"}, 1);
  }

  public String[] solution(String[] strings, int n) {
    char[] abc = new char[strings.length];

    for (int i = 0; i < strings.length; i++) {
      String string = strings[i];

      char key = string.charAt(n);
      int index = key - 'a';

      if (list[index] == null) {
        list[index] = new PriorityQueue<>();
      }
      list[index].add(string);

      abc[i] = key;
    }
    Arrays.sort(abc);

    String[] result = new String[strings.length];
    for (int i = 0; i < abc.length; i++) {
      String string = list[abc[i] - 'a'].poll();
      result[i] = string;
    }
    return result;
  }
}
