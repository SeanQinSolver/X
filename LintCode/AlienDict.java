import java.util.*;

public class AlienDict {

	public static void main(String[] args) {
		String[] words = {"wrt",
						  "wrf",
						  "er",
						  "ett",
						  "rftt"};
		AlienDict ad = new AlienDict();
		String result = ad.alienOrder(words);
		System.out.println(result);

	}
	


	public String alienOrder(String[] words) {
		if (words == null || words.length == 0) return "";
		HashMap<Character, Set<Character>> map = new HashMap<>();
		HashMap<Character, Integer> indegree = new HashMap<>();

		for (String word : words) {
			for (char c : word.toCharArray()) {
				indegree.put(c, 0);
			}
		}
		
		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			int index = 0;
			while (index < word1.length() && index < word2.length()) {
				if (word1.charAt(index) != word2.charAt(index)) break;
				index++;
			}
			char c1 = word1.charAt(index);
			char c2 = word2.charAt(index);

			Set<Character> set = map.getOrDefault(c1, new HashSet<>());
			set.add(c2);
			map.put(c1, set);
			indegree.put(c2, indegree.get(c2) + 1);
		}


		Queue<Character> queue = new LinkedList<>();

		for (Character c : indegree.keySet()) {
			if (indegree.get(c) == 0) {
				queue.offer(c);
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!queue.isEmpty()) {
			char c = queue.poll();
			sb.append(c);

			if (map.containsKey(c)) {
				for (char cc : map.get(c)) {
					indegree.put(cc, indegree.get(cc) - 1);
					if (indegree.get(cc) == 0) {
						queue.offer(cc);
					}
				}
			}
		}

		return sb.length() == indegree.size() ? sb.toString() : "";
    }
}

// 儒 习性
// 道 欲望
// 佛 情绪



//[
//        "wrt",
//        "wrf",
//        "er",
//        "ett",
//        "rftt"
// ]


// t -> f
// w -> e
// r -> t
// e -> r
// t -> f

// w -> e -> r -> t -> f 


//        "wertf"