package etc.string;

public class P120895 {
  public String solution(String my_string, int num1, int num2) {
    char[] chars = my_string.toCharArray();
    char temp = chars[num1];
    chars[num1] = chars[num2];
    chars[num2] = temp;
    return new String(chars);
  }
}
