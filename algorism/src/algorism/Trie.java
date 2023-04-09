package algorism;

public class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      // 자식에게 해당 알바벳이 없다면 생성
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new TrieNode();
      }
      node = node.children[c - 'a'];
      node.count++;
    }
    node.isEndOfWord = true;
  }

  public boolean search(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        return false;
      }
      node = node.children[c - 'a'];
    }
    return node.isEndOfWord;
  }

  class TrieNode {

    // 크기가 26인 이유는 알파벳를 기준으로하기 때문입니다.
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
    /*
    최소한의 입력을 확인하기 위해

    자동 완성 시스템의 목표는 가능한 최소한의 입력으로 원하는 단어를 찾는 것입니다.
    count 변수를 사용하여 해당 노드를 거쳐가는 단어들이 몇 개인지 확인할 수 있습니다.
    만약 count가 1이라면 해당 노드에서 시작하는 나머지 문자열이 하나뿐이므로 이 시점에서 입력을 멈추고 원하는 단어를 찾을 수 있습니다.
     */
    int count = 0;
  }
}
