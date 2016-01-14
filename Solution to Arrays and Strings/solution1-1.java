public boolean isUniqueChar(String s) {
	if (s == null || s.length() == 0) {
		return false;
	}
	/*如果s长度大于128，则有重复的 */
	if (s.length > 128) {
		return false;
	}

	boolean[] resultSet = new boolean[128];
	for (int i = 0; i < s.length(); i++) {
		int cInt = (int)(s.charAt[i]);
		if(resultSet[cInt]) {
			return false;
		}
		resultSet[cInt] = true;
	}
	return true;
}