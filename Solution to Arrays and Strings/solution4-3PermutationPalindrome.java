public boolean isPermutationOfPanlidrome(String str) {
	int bitVector - createBitVector(str);
	return bitVector == 0 || checkExactlyOneBitSet(bitVector);
}

public int createBitVector(String str) {
	int bitVector = 0;
	for (Char c : str.toCharArray()) {
		int x = getCharNumber(c);
		bitVector = toggle(bitVector, x);
	}
	return bitVector;
}

public int toggle(int bitVector, int index) {
	if (index < 0) return bitVector;
	
	int max = 1 << index;
	if ((bitVector & mask) == 0) {
		bitVector |= mask; /*某个字母出现奇数次，则bitVector变为1*/
	} else {
		bitVector &= ~mask; /*若某个字母出现偶数次，则bitVector变为0*/
	}
	return bitVector;
}

public boolean checkExactlyOneBitSet(int bitVector) {
	return (bitVector & (bitVector - 1)) == 0;
}