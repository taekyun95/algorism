package study.leedcode;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix.length == 0) return result;

    int rowBegin = 0;
    int rowEnd = matrix.length - 1;
    int colBegin = 0;
    int colEnd = matrix[0].length - 1;


    while ( result.size() < matrix.length * matrix[0].length ) {
      // 오른쪽으로 이동
      for (int j = colBegin; j <= colEnd; j++) {
        result.add(matrix[rowBegin][j]);
      }
      rowBegin++;
      
      for (int j = rowBegin; j <= rowEnd; j++) {
        result.add(matrix[j][colEnd]);
      }
      colEnd--;
      if (rowBegin <= rowEnd) {
        for (int j = colEnd; j >= colBegin; j--) {
          result.add(matrix[rowEnd][j]);
        }
      }
      rowEnd--;
      // 위로 이동
      if (colBegin <= colEnd) {
        for (int j = rowEnd; j >= rowBegin; j--) {
          result.add(matrix[j][colBegin]);
        }
      }
      colBegin++;
    }
    return result;
  }
}
