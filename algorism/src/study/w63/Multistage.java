package study.w63;

import java.util.HashMap;
import java.util.Map;

public class Multistage {
  public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    int[] answer = new int[enroll.length];
    Map<String, String> parentMap = new HashMap<>();
    Map<String, Integer> memberInfo = new HashMap<>();
    for (int i = 0; i < enroll.length; i++) {
      String me = enroll[i];
      String parent = referral[i];
      parentMap.put(me, parent);
      memberInfo.put(me, i);
    }
    for (int i = 0; i < seller.length; i++) {
      String name = seller[i];
      int profit = 100 * amount[i];
      while (!name.equals("-")) {
        int profitForParent = profit / 10;
        int nowProfit = profit - profitForParent;
        answer[memberInfo.get(name)] += nowProfit;
        name = parentMap.get(name);
        profit /= 10;
        if (profit < 1) {
          break;
        }
      }
    }
    return answer;
  }

  Map<String, Integer> indexMap;
  int[] benefit;
  int[] parent;

  public int[] solution2(String[] enroll, String[] referral, String[] seller, int[] amount) {
    int n = enroll.length;
    benefit = new int[n];
    parent = new int[n];
    indexMap = new HashMap<>();

    for (int i = 0; i < n; i++) {
      indexMap.put(enroll[i], i);
    }

    for (int i = 0; i < n; i++) {
      if (!referral[i].equals("-")) {
        parent[i] = indexMap.get(referral[i]);
      } else {
        parent[i] = -1;
      }
    }
    for (int i = 0; i < seller.length; i++) {
      int cur = indexMap.get(seller[i]);
      int totalBenefit = amount[i] * 100;
      while (cur != -1) {
        int share = totalBenefit / 10;
        if (share < 1) {
          benefit[cur] += totalBenefit;
          break;
        } else {
          benefit[cur] += totalBenefit - share;
          totalBenefit = share;
          cur = parent[cur];
        }
      }
    }

    return benefit;
  }
}
