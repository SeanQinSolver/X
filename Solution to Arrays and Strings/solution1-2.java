public boolean isUniqueChar(String s) {
	if (s == null && s.length() == 0) {
		return false;
	}
	if (s.length() > 128) {
		return false;
	}
	int checker = 0;
	for (int i = 0; i < s.length(); i++) {
		if (checker & (1 << val) > 0) {
			return false;
		}
		checker = checker | (1 << val);
	}
	return true;
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            