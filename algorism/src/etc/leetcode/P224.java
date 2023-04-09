package etc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P224 {

  public static void main(String[] args) {
    WordDistance wd = new WordDistance(
        new String[]{"practice", "makes", "perfect", "coding", "makes"});
    // 3을 리턴
    if (wd.shortest("coding", "practice") == 3) {
      System.out.println("coding practice = true");
    }

    ;  // 1을 리턴
    if (wd.shortest("makes", "coding") == 1) {
      System.out.println("makes, coding = true");
    }
  }
}

class WordDistance {

  Map<String, List<Integer>> map = new HashMap<>();

  public WordDistance(String[] wordsDict) {
    for (int i = 0; i < wordsDict.length; i++) {
      String s = wordsDict[i];
      map.putIfAbsent(s, new ArrayList<>());
      map.get(s).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> indexWord1 = map.get(word1);
    List<Integer> indexWord2 = map.get(word2);

    int min = Integer.MAX_VALUE;
    int i = 0, j = 0;
    while (i < indexWord1.size() && j < indexWord2.size()) {
      Integer index1 = indexWord1.get(i);
      Integer index2 = indexWord2.get(j);
      min = Math.min(min, Math.abs(index1 - index2));

      if (index1 < index2) {
        i++;
      } else {
        j++;
      }
    }

    return min;
  }
}