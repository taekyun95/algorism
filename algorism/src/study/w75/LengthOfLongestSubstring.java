package study.w75;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
  public static void main(String[] args) {
    LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
    lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
  }

  public int lengthOfLongestSubstring(String s) {
    int answer = 0;
    ArrayDeque<Character> deque = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
      if (deque.contains(c)) {
        while (!deque.isEmpty() && deque.peek() != c) {
          deque.pollFirst();
        }
        if (!deque.isEmpty() && deque.peek() == c) {
          deque.pollFirst();
        }
      }
      deque.addLast(c);
      answer = Math.max(answer, deque.size());
    }

    return answer;
  }

  public int lengthOfLongestSubstring2(String s) {
    int n = s.length(), ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int right = 0, left = 0; right < n; right++) {
      if (map.containsKey(s.charAt(right))) {
        left = Math.max(map.get(s.charAt(right)), left);
      }
      ans = Math.max(right - left + 1, ans);
      map.put(s.charAt(right), right + 1);
    }

    return ans;
  }
}
