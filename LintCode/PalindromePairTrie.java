import java.util.*;

public class PalindromePairTrie {

	public static void main(String[] args) {
		String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
		PalindromePairTrie ppt = new PalindromePairTrie();
		List<List<Integer>> result = ppt.palindromePairs(words);
		for (List<Integer> list : result) {
			for (Integer i : list) {
				System.out.print(words[i] + "  ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		if (words == null || words.length == 0) return null;

		TrieNode root = new TrieNode();

		for (int i = 0; i < words.length; i++) {
			addWord(root, words[i], i);
		}

		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < words.length; i++) {
			searchWord(root, words, i, list);
		}
		return list;
	}

	private void addWord(TrieNode root, String word, int index) {
		for (int i = word.length() - 1; i >= 0; i--) {

			int j = word.charAt(i) - 'a';
			// 0, 1
			if (root.next[j] == null) root.next[j] = new TrieNode();
			if (isPalindrome(word, 0, i)) root.indexList.add(index);
			
			root = root.next[j];
		}
		root.indexList.add(index);
		root.index = index;
	}


	private void searchWord(TrieNode root, String[] words, int i, List<List<Integer>> list) {
		// each character
		for (int j = 0; j < words[i].length(); j++) {
			// root.index >= 0 valid number in array
			// root.index != i not number itself.
			if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
				list.add(Arrays.asList(i, root.index));
			}
			int next = words[i].charAt(j) - 'a';
			root = root.next[next];
			if (root == null) return;
		}

		for (int j : root.indexList) {
			if (i == j) continue;
			list.add(Arrays.asList(i, j));
		}
	}



	private boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) return false;
		}
		return true;
	}

	private static class TrieNode {
		TrieNode[] next;
		int index;
		List<Integer> indexList;
		TrieNode() {
			this.index = -1;
			this.indexList = new ArrayList<>();
			this.next = new TrieNode[26];
		}
	}
}

// index -> is there a valid number
// indexList -> 1. each word has a suffix represented by current Trie node, 2 the rest of word forms panlidrome