package study.w64;

public class RotateMatrixBorders {
  public int[] solution(int rows, int columns, int[][] queries) {
    int[][] map = new int[rows][columns];

    // Initialize the map
    int count = 1;
    for(int i=0; i<rows; i++) {
      for(int j=0; j<columns; j++) {
        map[i][j] = count++;
      }
    }

    // Process each query
    int[] result = new int[queries.length];
    for(int i=0; i<queries.length; i++) {
      result[i] = rotate(map, queries[i]);
    }

    return result;
  }

  private int rotate(int[][] map, int[] query) {
    int x1 = query[0] - 1;
    int y1 = query[1] - 1;
    int x2 = query[2] - 1;
    int y2 = query[3] - 1;

    // Save the top-left corner value
    int temp = map[x1][y1];
    int minVal = temp;

    for(int i=x1; i<x2; i++) {
      map[i][y1] = map[i+1][y1];
      minVal = Math.min(minVal, map[i][y1]);
    }
    for(int i=y1; i<y2; i++) {
      map[x2][i] = map[x2][i+1];
      minVal = Math.min(minVal, map[x2][i]);
    }
    for(int i=x2; i>x1; i--) {
      map[i][y2] = map[i-1][y2];
      minVal = Math.min(minVal, map[i][y2]);
    }
    for(int i=y2; i>y1; i--) {
      map[x1][i] = map[x1][i-1];
      minVal = Math.min(minVal, map[x1][i]);
    }

    map[x1][y1+1] = temp;

    return minVal;
  }

  public static void main(String[] args) {
    RotateMatrixBorders rotateMatrixBorders = new RotateMatrixBorders();
    rotateMatrixBorders.solution(6, 6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
    rotateMatrixBorders.solution(100, 97, new int[][] {{1, 1, 100, 97}});
  }
}
