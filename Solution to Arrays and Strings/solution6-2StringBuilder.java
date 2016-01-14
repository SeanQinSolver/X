public String compressGood(String str) {
	StringBuilder strBui = new StringBuilder;
	int count = 0;
	for (int i = 0; i < str.length(); i++) {
		count++;
		if (str.charAt(i) != str.charAt(i + 1) || i + 1 > str.length()) {
			strBui.append(str.charAt(i));
			strBui.append(count);
			count = 0;
		}
	}
	return strBui.length() < str.length ? strBui.toString() : str;
}