package study.w57;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CompressionLZW {

  public int[] Solution(String msg) {
    Map<String, Integer> dictionary = new HashMap<>();
    for (int i = 0; i < 26; i++) {
      dictionary.put(Character.toString('A' + i), i + 1);
    }

    List<Integer> compressedMsg = new LinkedList<>();
    int nextIndex = 27;
    int i = 0;
    while (i < msg.length()) {
      int j = 1;
      // 주어진 문자열을 순회하면서 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾습니다.
      while (i + j <= msg.length() && dictionary.containsKey(msg.substring(i, i + j))) {
        j++;
      }

      // w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
      String foundWord = msg.substring(i, i + j - 1);
      compressedMsg.add(dictionary.get(foundWord));

      // 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
      if (i + j <= msg.length()) {
        String newWord = msg.substring(i, i + j);
        dictionary.put(newWord, nextIndex++);
      }
      i += j - 1;
    }
    return compressedMsg.stream().mapToInt(Integer::intValue).toArray();
  }

  public int[] Solution2(String msg) {
    List<Integer> list = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();
    int idx = 27;
    for (int i = 0; i < 26; i++) {
      map.put(Character.toString('A' + i), i + 1);
    }

    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (true) {
      sb.append(msg.charAt(i++));

      int tmp = 0;
      while (i < msg.length() && map.containsKey(sb.toString())) {
        tmp = map.get(sb.toString());
        sb.append(msg.charAt(i++));
      }

      if (i == msg.length()) {
        if (map.containsKey(sb.toString())) {
          list.add(map.get(sb.toString()));
        } else {
          list.add(tmp);
          list.add(map.get(String.valueOf(msg.charAt(i - 1))));
        }
        break;
      }
      list.add(tmp);
      map.put(sb.toString(), idx++);
      sb = new StringBuilder();
      i--;
    }

    return list.stream().mapToInt(Integer::intValue).toArray();
  }
}