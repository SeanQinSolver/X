//solution1 add the missing subsets element to current one n2n time and space
public class Solution {
	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubsets;
		if (set.size() == index) {
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>());
		} else {
			allSubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allSubsets) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moreSubsets.add(newSubset);
			}
			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}
}

//solution2 use binary string and convert it into arraylist

public class Solution {
	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();

		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subSet = convertIntToSet(k, set);
			allSubsets.add(subSet);
		}
		return allSubsets;
	}

	public ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) subset.add(set.get(index));
		}
		index++;
	}
	return subset   
}