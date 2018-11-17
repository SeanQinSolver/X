public class PanTrie {

	public List<List<Integer>> panlindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<>();
		
		TrieNode root = new TrieNode();

		for (int i = 0; i < words.length; i++) {
			addWord(root, words[i], i);
		}

		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < words.length; i++) {
			search(root, words, i, list);
		}
		return list;
	}

	private void addWord(TrieNode root, String word, int index) {
		for (int i = word.length() - 1; i >= 0; i--) {
			int j = word.charAt(i) - 'a';

			if (root.next[j] == null) root.next[j] = new TrieNode();
			if (isPan(word, 0, i)) root.indexList.add(index);

			root = root.next[j];
		}
		root.indexList.add(index);
		root.index = index;
	}

	private void searchWord(TrieNode root, String[] words, int i, List<List<Integer>> list) {
		for (int j = 0; j < words[i].length; j++) {
			if (root.index >= 0 && root.index != i && isPan(words[i], j, words[i].length() - 1)) {
				list.add(Arrays.asList(i, root.index));
			}
			int next = words[i].charAt(j) - 'a';
			root = root.next[next];
			if (root == null) return;
		}
	}


	private boolean isPan(String s, int i, int j) {
		int f = 0;
		int e = s.length() - 1;
		while (f < e) {
			if (s.charAt(f++) != s.charAt(e--)) return false;
		}
		return true;
	}


	private static class TrieNode {
		// next nodes
		TrieNode[] next;
		int index;
		// 
		List<Integer> list;

		TrieNode() {
			this.next = new TrieNode[26];
			this.index = -1;
			this.list = new ArrayList<>();
		}
	}
}