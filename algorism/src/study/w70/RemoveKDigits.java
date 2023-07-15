package study.w70;

import java.util.Stack;

class RemoveKDigits {

  public static void main(String[] args){
    RemoveKDigits removeKDigits = new RemoveKDigits();
    String s = removeKDigits.removeKdigits("1432219", 3);
    System.out.println("s = " + s);
  }

  public String removeKdigits(String num, int k) {
    if (k == num.length()) return "0";

    Stack<Character> stack = new Stack<>();
    int i = 0;

    while (i < num.length()) {
      while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
        stack.pop();
        k--;
      }

      stack.push(num.charAt(i));
      i++;
    }

    while (k-- > 0) stack.pop();

    StringBuilder sb = new StringBuilder();
    for (char c : stack) sb.append(c);

    while (sb.length() > 1 && sb.charAt(0) == '0') {
      sb.deleteCharAt(0);
    }

    return sb.toString();
  }
}
