package study.w64;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchRanking {
  public int[] solution(String[] info, String[] query) {
    List<People> peopleList = new ArrayList<>();
    for (String s : info) {
      String[] split = s.split(" ");
      peopleList.add(
          new People(split[0], split[1], split[2], split[3], Integer.parseInt(split[4])));
    }
    int[] result = new int[query.length];
    for (int i = 0; i < query.length; i++) {
      String[] split = query[i].split(" ");
      String lang = split[0];
      List<People> filter = new ArrayList<>(peopleList);
      if (!lang.equals("-")) {
        filter = filter.stream().filter(people -> people.lang.equals(lang)).toList();
      }
      String position = split[2];
      if (!position.equals("-")) {
        filter = filter.stream().filter(people -> people.position.equals(position)).toList();
      }
      String career = split[4];
      if (!career.equals("-")) {
        filter = filter.stream().filter(people -> people.career.equals(career)).toList();
      }
      String food = split[6];
      if (!food.equals("-")) {
        filter = filter.stream().filter(people -> people.food.equals(food)).toList();
      }
      String num = split[7];
      if (!num.equals("-")) {
        int number = Integer.parseInt(num);
        filter = filter.stream().filter(people -> people.num >= number).toList();
      }
      result[i] = filter.size();
    }

    return result;
  }

  static class People {
    String lang;
    String position;
    String career;
    String food;
    int num;

    public People(String lang, String position, String career, String food, int num) {
      this.lang = lang;
      this.position = position;
      this.career = career;
      this.food = food;
      this.num = num;
    }
  }

  // String: 조건
  // ArrayList: 점수
  Map<String, ArrayList<Integer>> infoMap = new HashMap<>();
  int[] answer;

  void combination(String[] info, int depth, String s) {
    if (depth == 4) {
      if (!infoMap.containsKey(s)) infoMap.put(s, new ArrayList<>());
      infoMap.get(s).add(Integer.parseInt(info[4]));
      return;
    }

    combination(info, depth + 1, s + "-");
    combination(info, depth + 1, s + info[depth]);
  }

  public int[] solution2(String[] info, String[] query) {
    answer = new int[query.length];

    for (String in : info) {
      combination(in.split(" "), 0, "");
    }

    for (Map.Entry<String, ArrayList<Integer>> entry : infoMap.entrySet())
      entry.getValue().sort(null);

    for (int i = 0; i < query.length; i++) {
      String[] q = query[i].split(" ");
      String key = q[0] + q[2] + q[4] + q[6];
      int score = Integer.parseInt(q[7]);

      ArrayList<Integer> list = infoMap.getOrDefault(key, new ArrayList<>());
      int start = 0, end = list.size();

      while (start < end) {
        int mid = (start + end) / 2;

        if (list.get(mid) < score) start = mid + 1;
        else end = mid;
      }

      answer[i] = list.size() - start;
    }

    return answer;
  }

  public static void main(String[] args) {
    SearchRanking searchRanking = new SearchRanking();
    searchRanking.solution2(
        new String[] {
          "java backend junior pizza 150",
          "python frontend senior chicken 210",
          "python frontend senior chicken 150",
          "cpp backend senior pizza 260",
          "java backend junior chicken 80",
          "python backend senior chicken 50"
        },
        new String[] {
          "java and backend and junior and pizza 100",
          "python and frontend and senior and chicken 200",
          "cpp and - and senior and pizza 250",
          "- and backend and senior and - 150",
          "- and - and - and chicken 100",
          "- and - and - and - 150"
        });
  }
}
