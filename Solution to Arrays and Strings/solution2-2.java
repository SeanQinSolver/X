public boolean permutation(String s, String t) {
	if (s == null || s.length() == 0 || t == null || t.length() == 0) {
		return false;
	}
	if (s.length() == 0) {
		return false;
	}
	int[] letters = new int[128];

	char[] char = s.toCharArray();

	for (int i = 0; i < char.length(); i++) {
		letters[c]++;
	}

	for (int i = 0; i < t.length(); i++) {
		int c = (int)t.charAt(i);
		letters[c]--;
		if (letters[c] < 0) {
			return false;
		}
	}
	return true;
}