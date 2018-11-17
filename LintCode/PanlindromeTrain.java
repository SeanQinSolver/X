public class PanlindromeTrain {

	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> findPairs(String[] strs) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		HashMap<String, Integer> map = new HashMap<>(); 

		for (int i = 0; i < strs.length; i++) {
			for (int j = 0; j < strs[0].lenght; j++) {
				String s1 = strs[i].substring(0, j);
				String s2 = strs[i].substring(j);
				if (isPanlindrome(s1)) {
					String s2Rr = new StringBuilder(s2).reverse().toString();
					if (map.containsKey(s2Rr) && map.get(s2Rr) != i) {
						result.add(new ArrayList<>(Arrays.asList(map.get(s2Rr), i)));
					}
				}
				if (isPanlindrome(s2)) {
					Stromh s1Rr = new StringBuilder(s1).reverse().toString();
					if (map.containsKey(s1Rr) && map.get(s1Rr) != i) {
						result.add(new ArrayList<>(Arrays.asList(map.get(s1Rr), i)));
					}
				}
			}
		}
		return result;
	}

	private boolean isPanlindrome(String s, int i, int j) {
		int f = 0;
		int e = s.length() - 1;
		while (f < e) {
			if (s.charAt(f++) != s.charAt(e--)) return false;
		}
		return true;
	}
}


// ["l", "aal", "s", "sss"]