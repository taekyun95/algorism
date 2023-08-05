package study.w71;

import java.util.*;

public class ThreeSum {
  int[] nums;
  List<List<Integer>> res = new ArrayList<>();

  // 1. nums 정렬
  // 2. 0 ~ nums.length - 1까지 순회
  // 3. index를 index + 1부터 nums.length - 1까지 순회하면서 (단 index + 1 < nums.length - 1)
  // 4. nums[index] + nums[left] + nums[right] == 0인 경우를 찾는다.
  // 찾는 경우 res에 추가 / left, right를 한칸씩 이동한다.
  // 중복을 방지하기 위해 left 한칸 이동하기 전과 이동후 left 값이 같은지 확인한다.
  // 같을 경우 left (오른쪽) 한칸 이동한다.
  public List<List<Integer>> threeSum(int[] nums) {
    this.nums = nums;
    Arrays.sort(nums);
    // 정렬된 상태에서 index기준 오른쪽에서만 값을 찾기 때문에
    // nums[i]가 0보다 크면 무조건 0보다 큰 값이 나올 수 밖에 없다.
    for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
      if (i == 0 || nums[i - 1] != nums[i]) {
        twoSumII(i);
      }
    }
    return res;
  }

  private void twoSumII(int index) {
    int currentNum = nums[index];
    int left = index + 1;
    int right = nums.length - 1;
    while (left < right) {
      int sum = currentNum + nums[left] + nums[right];
      if (sum < 0) {
        ++left;
      } else if (sum > 0) {
        --right;
      } else {
        res.add(Arrays.asList(currentNum, nums[left++], nums[right--]));
        while (left < right && nums[left] == nums[left - 1]) {
          ++left;
        }
      }
    }
  }

  private void twoSumII2(int index) {
    Set<Integer> set = new HashSet<>();
    for (int i = index + 1; i < nums.length; i++) {
      int complement = -nums[index] - nums[i];
      if (set.contains(complement)) {
        res.add(Arrays.asList(nums[index], nums[i], complement));
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) ++i;
      }
      set.add(nums[i]);
    }

    int currentNum = nums[index];
    int left = index + 1;
    int right = nums.length - 1;
    while (left < right) {
      int sum = currentNum + nums[left] + nums[right];
      if (sum < 0) {
        ++left;
      } else if (sum > 0) {
        --right;
      } else {
        res.add(Arrays.asList(currentNum, nums[left++], nums[right--]));
        while (left < right && nums[left] == nums[left - 1]) {
          ++left;
        }
      }
    }
  }
}
