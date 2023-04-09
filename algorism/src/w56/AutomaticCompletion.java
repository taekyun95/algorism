package w56;

import java.util.HashMap;

public class AutomaticCompletion {

  public static void main(String[] args) {
    AutomaticCompletion automaticCompletion = new AutomaticCompletion();
    int solution = automaticCompletion.solution(new String[]{"go", "gone", "guild"});
    System.out.println(solution);
  }

  public int solution(String[] words) {
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }
    int answer = 0;

    for (String word : words) {
      answer +=trie.search(word);
    }

    return answer;
  }

  class Trie{
    HashMap<Character, Trie> children = new HashMap<>();
    int count = 0;

    void insert(String word) {
      Trie currentNode = this;

      for (int i = 0; i < word.length(); i++) {
        currentNode = currentNode.children.computeIfAbsent(word.charAt(i), c -> new Trie());
        currentNode.count++;
      }
    }

    public int search(String word) {
      Trie currentNode = this;
      int level = 0;
      for (int i = 0; i < word.length(); i++) {
        currentNode = currentNode.children.get(word.charAt(i));
        level++;
        if (currentNode.count==1){
          return level;
        }
      }
      return level;
    }
  }
}
