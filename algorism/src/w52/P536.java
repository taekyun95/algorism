package w52;

public class P536 {

  int index = 0;

  public TreeNode str2tree(String s) {
    if (s == null || s.length() == 0) {
      return null;
    }
    // 음수
    char c = s.charAt(index);
    boolean isNegative = false;
    if (c == '-') {
      isNegative = true;
      index++;
    }
    int num = 0;
    TreeNode treeNode = new TreeNode();
    while (index < s.length()) {
      c = s.charAt(index);
      if (c == '(') {
        treeNode.left = str2tree(s);
        if (index < s.length() && s.charAt(index) == '(') {
          index++;
          treeNode.right = str2tree(s);
        }
      } else if (c == ')') {
        break;
      } else {
        num = num * 10 + Character.getNumericValue(c);
      }
    }
    treeNode.val = isNegative ? -num : num;

    return treeNode;
  }
}

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
