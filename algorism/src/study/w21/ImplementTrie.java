package study.w21;

public class ImplementTrie {
  class Trie {
    private final Trie[] children = new Trie[26];
    private boolean isEndOfWord = false;
    public Trie() {
    }

    public void insert(String word) {
      insert(word, 0);
    }

    public boolean search(String word) {
      return search(word, 0);
    }

    public boolean search(String word, int index) {
      if(index == word.length()) return isEndOfWord;
      int i = word.charAt(index) - 'a';
      if(children[i] == null) return false;
      return children[i].search(word, index + 1);
    }

    public boolean startsWith(String prefix) {
      return startsWith(prefix, 0);
    }

    public boolean startsWith(String prefix, int index) {
      if(index == prefix.length()) return true;
      int i = prefix.charAt(index) - 'a';
      if(children[i] == null) return false;
      return children[i].startsWith(prefix, index + 1);
    }



    private void insert(String word, int index){
      if(index == word.length()) {
        isEndOfWord = true;
        return;
      }
      int i = word.charAt(index) - 'a';
      if(children[i] == null) children[i] = new Trie();
      children[i].insert(word, index + 1);
    }
  }
}
