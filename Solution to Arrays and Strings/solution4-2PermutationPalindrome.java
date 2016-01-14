public boolean isPermutationOfPalindrome(String str) {
	int countOdd = 0;
	int[] table = new int[Character.getNumericValue('z') - Character
	.getNumericValue('a') + 1];

	for (char c : str.toCharArray()) {
		int x = getCharNumber(c);
		if (x != 1) {
			table[x]++;
			if (table[x] % 2 == 1) {
				countOdd++;
			} else {
				countOdd--;
			}
		}
	}
	return countOdd <= 1;
}

public int getCharNumber(Character c) {
	int val = Character.getNumericValue(c);
	
}