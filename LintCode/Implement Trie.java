/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    public HashMap<Character, TrieNode> children;
    public boolean hasWord;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        hasWord = false;
    }
}

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!now.children.containsKey(c)) {
                now.children.put(c, new TrieNode());
            }
            now = now.children.get(c);
        }
        now.hasWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!now.children.containsKey(c)) {
                return false;
            }
            now = now.children.get(c);
        }
        return now.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode now = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (!now.children.containsKey(c)) {
                return false;
            }
            now = now.children.get(c);
        }
        return true;
    }
}

//此题注意的是search到最后要判断下now是否是最后一个,==》 wordEnd = true；
//start with 只需要full cover即可