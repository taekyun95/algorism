package study.w63

class SearchLyrics {

    /**
     * @param words 가사들
     * @param queries 검색어
     * @return 검색된 가사들의 갯수
     */
    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        val tries = Array(10001) { Trie() }
        val reverseTries = Array(10001) { Trie() }

        for (word in words) {
            tries[word.length].insert(word)
            reverseTries[word.length].insert(word.reversed())
        }

        return queries.map { query ->
            if (query.first() != '?') {
                tries[query.length].search(query)
            } else {
                reverseTries[query.length].search(query.reversed())
            }
        }.toIntArray()
    }

    class TrieNode {
        var child = Array<TrieNode?>(26) { null }
        var count = 0
    }

    class Trie {
        private var root = TrieNode()

        fun insert(word: String) {
            var node = root

            for (i in word.indices) {
                node.count++
                val index = word[i] - 'a'
                if (node.child[index] == null) {
                    node.child[index] = TrieNode()
                }
                node = node.child[index]!!
            }
            node.count++
        }

        fun search(query: String): Int {
            var node = root

            for (i in query.indices) {
                if (query[i] == '?') break
                val index = query[i] - 'a'
                if (node.child[index] == null) {
                    return 0
                }
                node = node.child[index]!!
            }

            return node.count
        }
    }
}

fun main() {
    val searchLyrics = SearchLyrics()
    val solution = searchLyrics.solution(
        arrayOf("frodo", "front", "frost", "frozen", "frame", "kakao"),
        arrayOf("fro??", "????o", "fr???", "fro???", "pro?"),
    )
    print(solution)
}
