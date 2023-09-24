package study.w21;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
    System.out.println(
        longestConsecutiveSequence.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
  }

  public int longestConsecutive(int[] nums) {
    Arrays.sort(nums);
    int result = 0;
    int max = 0;
    if (nums.length <= 1) return nums.length;
    for (int i = 0; i < nums.length - 1; i++) {
      if (Math.abs(nums[i] - nums[i + 1]) == 1) max++;
      else if (nums[i] != nums[i + 1]) {
        result = Math.max(result, max);
        max = 0;
      }
    }
    return Math.max(result, max) + 1;
  }

  public int longestConsecutive2(int[] nums) {
    Set<Integer> num_set = new HashSet<>();
    for (int num : nums) {
      num_set.add(num);
    }

    int longestStreak = 0;

    for (int num : num_set) {
      if (!num_set.contains(num-1)) {
        int currentNum = num;
        int currentStreak = 1;

        while (num_set.contains(currentNum+1)) {
          currentNum += 1;
          currentStreak += 1;
        }

        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }

    return longestStreak;
  }
}
