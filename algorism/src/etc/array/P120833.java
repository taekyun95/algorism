package etc.array;

public class P120833 {

  public int[] solution(int[] numbers, int num1, int num2) {
    int length = num2 - num1 + 1;
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      result[i] = numbers[num1 + i];
    }
    return result;
  }
}
