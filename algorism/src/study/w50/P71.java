package study.w50;

import java.util.ArrayDeque;
import java.util.Deque;

public class P71 {

  public static void main(String[] args) {
    P71 p71 = new P71();
    System.out.println(p71.simplifyPath("/home/").equals("/home"));
  }

  public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    for (String s : path.split("/")) {
      if (!s.equals("")) {
        stack.addLast(s);
      } else if (s.equals("..")) {
        stack.pollLast();
      }
    }

    return "/" + String.join("/", stack);
  }
}
