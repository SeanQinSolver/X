public class Solution {
	public void checkDuplicates(int[] array) {
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int num0 = num - 1;
			if (bs.get(num0)) {
				System.out.println(num);
			} else {
				bs.set(num0);
			}
		}
	}

	public BitSet {
		int[] bitset;
		public BitSet(int size) {
			bitset = new int[(size >> 5) + 1];
		}

		public boolean get(int pos) {
			int wordNumber = (pos >> 5);
			int bitNumber = (pos & 0x1F);
			return (bitset[wordNumber] & (1 << bitNumber)) != 0;
		}

		public void set(int pos) {
			int wordNumber = (pos >> 5);
			int bitNumber = (pos & 0x1F);
			bitset[wordNumber] |= 1 << bitNumber;
		}
	}
}