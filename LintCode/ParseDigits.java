import java.util.*;

public class ParseDigits {
	public static void main(String[] args) {
		int[] array = {4, 6, 7};
		int lowerBound = 500;
		ParseDigits pd = new ParseDigits();
		int result = pd.parse(array, lowerBound);
		System.out.println(result);
	}

	public int parse(int[] array, int lowerBound) {
		if (array == null || array.length == 0) return -1;
		Arrays.sort(array);

		StringBuilder sb = new StringBuilder();
		int min = Integer.MAX_VALUE;
		HashSet<Integer> set = new HashSet<>();
		ArrayList<Integer> result = new ArrayList<>();
		dfs(lowerBound, array, sb, set, result);
		
		for (Integer value : result) {
			min = Math.min(value, min);
		}
		return min;
	}

	private void dfs(int lowerBound, int[] array, StringBuilder sb, HashSet<Integer> set, ArrayList<Integer> result) {
		if (sb.length() == array.length ) {
			if (Integer.valueOf(sb.toString()) > lowerBound) {
				
				//System.out.println(sb.toString());
				result.add(Integer.valueOf(sb.toString()));
			}
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			if (set.contains(i)) continue;
			set.add(i);
			sb.append(array[i]);
			dfs(lowerBound, array, sb, set, result);
			sb.deleteCharAt(sb.length() - 1);
			set.remove(i);
		}
	}
}