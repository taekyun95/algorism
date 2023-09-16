package study.w17;


import algorism.TreeNode;

public class LowestCommonAncestor {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
    TreeNode rightRes = lowestCommonAncestor(root.right, p, q);

    if ((leftRes != null && rightRes != null) || (root == p || root == q)) {
      return root;
    } else {
      return leftRes != null ? leftRes : rightRes;
    }
  }
}
