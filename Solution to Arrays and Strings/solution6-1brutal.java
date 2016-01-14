public String compressBad(String str) {
	String compressedString = "";
	int count = 0;

	for (int i = 0; i < str.length(); i++) {
		count++;
		if (str.charAt(i) != str.charAt(i + 1)) {
			/*n2 runtime because it generate 1 + 2 + ..... + n String */
			compressedString += " " + str.charAt(i) + count;
			count = 0;
		}
	}
	return compressedString.length() < str.length ? compressedString : str;
}