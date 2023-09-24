package study.w21;

public class ImplementTrie2 {
  class Node {
    Node[] children = new Node[26];
    boolean isEndOfWord = false;
  }

  class Trie {

    private final Node root;

    public Trie() {
      root = new Node();
    }

    public void insert(String word) {
      Node node = root;
      for (char c : word.toCharArray()) {
        int i = c - 'a';
        if (node.children[i] == null) node.children[i] = new Node();
        node = node.children[i];
      }
      node.isEndOfWord = true;
    }

    public boolean search(String word) {
      return find(word, true);
    }

    public boolean startsWith(String prefix) {
      return find(prefix, false);
    }

    public boolean find(String word, boolean findMode) {
      Node node = root;
      for (char c : word.toCharArray()) {
        int i = c - 'a';
        if (node.children[i] == null) return false;
        node = node.children[i];
      }
      return !findMode || node.isEndOfWord;
    }
  }
}
