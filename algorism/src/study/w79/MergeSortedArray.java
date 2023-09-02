package study.w79;

import java.util.Arrays;

public class MergeSortedArray {
  public static void main(String[] args) {
    //    int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
    //    int[] nums2 = new int[] {2, 5, 6};
    int[] nums1 = new int[] {1};
    int[] nums2 = new int[] {};
    merge2(nums1, 1, nums2, 0);
    System.out.println(Arrays.toString(nums1)); // [1, 2, 2, 3, 5, 6]을 출력
  }

  // Merge and sort
  public static void merge1(int[] nums1, int m, int[] nums2, int n) {
    if (n >= 0) System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1);
  }

  // 3 pointers + new Array
  public static void merge2(int[] nums1, int m, int[] nums2, int n) {
    int[] nums1Copy = new int[nums1.length];
    System.arraycopy(nums1, 0, nums1Copy, 0, m);

    int x = 0;
    int y = 0;
    for (int i = 0; i < nums1.length; i++) {
      if (y >= n || (x < m && nums1Copy[x] < nums2[y])) {
        nums1[i] = nums1Copy[x++];
      } else {
        nums1[i] = nums2[y++];
      }
    }
  }

  // 3 pointers + back
  public static void merge3(int[] nums1, int m, int[] nums2, int n) {
    int x = m - 1, y = n - 1;
    for (int i = m + n - 1; i >= 0; i--) {
      if (y < 0) { // y가 0일 때 0 ~ x 범위가 남아 있으므로
        break;
      }
      if (x >= 0 && nums1[x] > nums2[y]) {
        nums1[i] = nums1[x--];
      } else {
        nums1[i] = nums2[y--];
      }
    }
  }
}
