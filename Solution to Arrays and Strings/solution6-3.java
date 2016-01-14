public String compressBetter(String s) {
	int finalLength = countCompression(str);
	if (finalLength >= s.length()) return s;

	StringBuilder compressed = new StringBuilder(finalLength);
	int count = 0;
	for (int i = 0; i < finalLength; i++) {
		count++;
		if (i + 1 > s.length() || str.charAt(i) != str.charAt(i + 1)) {
			compressed.append(s.charAt(i));
			compressed.append(count);
			count = 0;
		}
	}
	return compressed.toString();
}

public int countCompression(String str) {
	int compressedLength = 0;
	int count = 0;

	for (int i = 0; i < str.length(); i++) {
		count++;

		if (i + 1 > str.length() || str.charAt(i) != str.charAt(i + 1)) {
			compressedLength += String.valueOf(count).length() + 1;
			count = 0; 
		}
	}
	return compressedLength;9
}