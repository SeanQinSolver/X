public String sort(String s) {
	char[] content = s.toCharArray();
	Arrays.sort(content);
	return new String(content);
}

public permutation(String s, String t) {
	if (s == null || s.length() == 0 || t == null || t.length() == 0) {
		return false;
	}
	if (s.length() != t.length()) {
		return false;
	}
	return sort(s).equals(sort(t));
}