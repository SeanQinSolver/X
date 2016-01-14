public boolean oneEditAway(String first, String second) {
	if (Math.abs(first.lenth() - second.length) > 1) {
		return false;
	}
	if (first.length() == second.length()) {
		return oneEditReplace(first, second);
	} else if (first.length() + 1 == second.length()) {
		return oneEditInsertion(first, second0);
	} else if (first.length() - 1 == second.length()) {
		return oneEditInsertion(second, first);
	}
	return false;
}

public boolean oneEditReplace(String s1, String s2) {
	boolean flag = false;
	for (int i = 0; i < s1.length(); i++) {
		if (s1.charAt(i) != s2.charAt(i)) {
			if (flag) {
				return false;
			}
		}
		flag = true;
	}
}

public boolean oneEditInsertion(String s1, String s2) {
	int index1 = 0; index2 = 0;

	while (index2 < s2.length() && index1 < s1.length()) {
		if (s1.charAt(index1) != s2.charAt(index2)) {
			if (index1 != index2) {
				return false;
			}
			index2++;
		} else {
			index1++;
			index2++;
		}
	}
}