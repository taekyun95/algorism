package study.w57;

import java.util.ArrayList;
import java.util.List;

public class SortFileName {

  public static void main(String[] args) {
    SortFileName sortFileName = new SortFileName();
    sortFileName.solution(new String[]{"F-123456"});
  }

  public String[] solution(String[] files) {
    List<File> fileList = new ArrayList<>();

    for (String file : files) {
      int numberStart = 0;
      int numberEnd = 0;

      for (int i = 0; i < file.length(); i++) {
        if (Character.isDigit(file.charAt(i))) {
          numberStart = i;
          break;
        }
      }
      for (int i = numberStart; (i < numberStart + 5 && i < file.length()); i++) {
        if (!Character.isDigit(file.charAt(i))) {
          break;
        }
        numberEnd++;
      }
      numberEnd += numberStart;

      String head = file.substring(0, numberStart);
      String number = file.substring(numberStart, numberEnd);
      String tail = file.substring(numberEnd);

      fileList.add(new File(file, head, Integer.parseInt(number), tail));
    }

    fileList.sort((o1, o2) -> {
      int headValue = o1.head.compareToIgnoreCase(o2.head);
      if (headValue == 0) {
        return o1.number - o2.number;
      } else {
        return headValue;
      }
    });

    String[] result = new String[files.length];
    for (int i = 0; i < fileList.size(); i++) {
      result[i] = fileList.get(i).fullName;
    }

    return result;
  }

  class File {

    String fullName;
    String head;
    int number;
    String tail;

    public File(String fullName, String head, int number, String tail) {
      this.fullName = fullName;
      this.head = head;
      this.number = number;
      this.tail = tail;
    }
  }
}
