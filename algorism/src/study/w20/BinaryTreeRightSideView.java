package study.w20;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
  List<Integer> rightside = new ArrayList<>();

  public void helper(TreeNode node, int level) {
    // 현재 레벨에서 가장 오른쪽에 있는 노드의 값을 했는가 확인후 추가한다.
    if (level == rightside.size()) rightside.add(node.val);

    if (node.right != null) helper(node.right, level + 1);
    if (node.left != null) helper(node.left, level + 1);
  }

  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return rightside;

    helper(root, 0);
    return rightside;
  }

  public List<Integer> rightSideView2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, result, 0);
    return rightside;
  }

  private void dfs(TreeNode root, List<Integer> result, int i) {
    if (root == null) return;
    if (i == result.size()) result.add(root.val);
    dfs(root.right, result, i + 1);
    dfs(root.left, result, i + 1);
  }

  private void rightSideView(TreeNode root, List<Integer> result) {
    if (root == null) return;
    result.add(root.val);
    rightSideView(root.right, result);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
