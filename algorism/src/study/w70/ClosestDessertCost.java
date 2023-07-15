package study.w70;

import java.util.Arrays;

public class ClosestDessertCost {

  int target;
  int[] toppingCosts;
  private int closest = Integer.MAX_VALUE;

  public static void main(String[] args) {
    ClosestDessertCost closestDessertCost = new ClosestDessertCost();
    int i;
    //    i = closestDessertCost.closestCost(new int[] {1, 7}, new int[] {3, 4}, 10);
    i = closestDessertCost.closestCost(new int[] {10}, new int[] {1}, 1);
    System.out.println("i = " + i);
  }

  public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
    Arrays.sort(toppingCosts);
    this.toppingCosts = toppingCosts;
    this.target = target;
    for (int baseCost : baseCosts) {
      backtrack(baseCost, 0);
    }

    return closest;
  }

  private void backtrack(int current, int index) {
    if (index == toppingCosts.length || current - target >= closest - target) {
      if (Math.abs(target - current) < Math.abs(target - closest)
          || (Math.abs(target - current) == Math.abs(target - closest) && current < closest)) {
        closest = current;
      }

      if (index == toppingCosts.length || current >= target) {
        return;
      }
    }

    // add 0, 1, or 2 toppings
    for (int i = 0; i <= 2; ++i) {
      backtrack(current + i * toppingCosts[index], index + 1);
    }
  }
}
