//solution1 permutation from first n-1 characters n! runntime
public class Solution {
	public ArrayList<String> getPerms(String str) {
		if (str == null) return null;

		ArrayList<String> permutations = new ArrayList<String>();
		if(str.length() == 0) {
			permutations.add("");
			return permutations;
		}

		char first = str.CharAt(0);
		String remainder = str.subString(1);
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; i <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}

	public String insertCharAt(String word, char c, int i) {
		String start = word.subString(0, i);
		String end = word.subString(i);
		return start + c + end;
	}
}

//solution2

public class Solution {
	public ArrayList<String> getPerms(String remainder) {
		int len = reminder.length();
		ArrayList<String> result = new ArrayList<String>();

		if (len == 0) {
			result.add("");
			return result;
		}

		for (int i = 0; i < len; i++) {
			String before = remainder.subString(0, i);
			String after = remainder.subString(i + 1, len);
			ArrayList<String> partials = getPerms(before + after);

			for (String s : partials) {
				resutl.add(remainder.charAt(i) + s);
			}
		}
		return result;
	}
}