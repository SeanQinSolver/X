public boolean isPermutationPalindrome(String str) {
	int[] table = buildCharFrequencyTable(str);
	return checkMaxOneOdd(table);
}
/*check whether it appear even or odds*/
public boolean checkMaxOneOdd(int[] table) {
	boolean flag = false;
	for (int i : table) {
		if (i % 2 == 1) {
			if (flag == true) {
				return false;
			}
			flag = true;
		}
	}
	return true;
}

/*Count how many time each char appears*/
public int[] buildCharFrequencyTable(String str) {
	int[] table = new int[Charactor.getNumericValue('z') - Charactor
	.getNumericValue('a') + 1];
	for (char c : str.toCharArray()) {
		if (c != null) {
			table[c]++;
		}
	}
	return table;
}