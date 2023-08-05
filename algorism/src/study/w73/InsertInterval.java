package study.w73;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
  int[][] intervals;
  int[] newInterval;

  public int[][] insert(int[][] intervals, int[] newInterval) {
    this.intervals = intervals;
    this.newInterval = newInterval;

    List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
    int index = upperBound();
    if (index != intervals.length) {
      list.add(index, newInterval);
    } else {
      list.add(newInterval);
    }

    List<int[]> answer = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      int[] currInterval = {intervals[i][0], intervals[i][1]};
      // Merge until the list gets exhausted or no overlap is found.
      while (i < intervals.length && doesIntervalsOverlap(currInterval, intervals[i])) {
        currInterval = mergeIntervals(currInterval, intervals[i]);
        i++;
      }
      // Decrement to ensure we don't skip the interval due to outer for-loop incrementing.
      i--;
      answer.add(currInterval);
    }

    return answer.toArray(new int[answer.size()][2]);
  }

  int upperBound() {
    if (this.intervals.length == 0) {
      return 0;
    }
    int start = 0, end = intervals.length - 1;
    int ans = intervals.length;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (intervals[mid][0] > newInterval[0]) {
        ans = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return ans;
  }

  boolean doesIntervalsOverlap(int[] a, int[] b) {
    return b[0] >= a[1];
  }

  int[] mergeIntervals(int[] a, int[] b) {
    int[] newInterval = {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    return newInterval;
  }
}
