package study.w18;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {

  private static final String[] DIGIT_TO_LETTERS = {
    "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
  };

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return new ArrayList<>();
    }
    List<String> result = new ArrayList<>();
    backtrack("", digits, 0, result);

    return result;
  }

  private void backtrack(String current, String digits, int index, List<String> result) {
    if (index == digits.length()) {
      result.add(current);
      return;
    }

    String letters = DIGIT_TO_LETTERS[digits.charAt(index) - '2'];
    for (int i = 0; i < letters.length(); i++) {
      backtrack(current + letters.charAt(i), digits, index + 1, result);
    }
  }

  public List<String> letterCombinations2(String digits) {
    String[] digitletter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();

    if (digits.length() == 0) return result;
    result.add("");
    for (int i = 0; i < digits.length(); i++)
      result = combine(digitletter[digits.charAt(i) - '0'], result);

    return result;
  }

  public List<String> combine(String digit, List<String> l) {
    List<String> result = new ArrayList<>();

    for (int i = 0; i < digit.length(); i++) {
      for (String x : l) {
        result.add(x + digit.charAt(i));
      }
    }

    return result;
  }
}
