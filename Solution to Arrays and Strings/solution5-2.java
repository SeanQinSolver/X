public boolean oneEditAway(String first, String second) {
	if (Math.abs(first.length() - second.length() > 1) {
		return false;
	}
	int index1 = 0, index2 = 0;
	/*s1为短边*/
	String s1 = first.length() - second.length() < 0 ? first : second;
	/*s2为长边*/
	String s2 = first.length() - second.length() > 0 ? first : second;

	boolean flag = false;
	
	while (index2 < s2.length() && index1 < s1.length()) {
		if (s1.charAt(index1) != s2.charAt(index2)) {
			if (flag) {
				return false;
			}
			flag = true;

			if (s1.length() == s2.length()) {
				index1++;
			}

		} else {
			index1++;
		}
		index2++;
	}
	return true;
}