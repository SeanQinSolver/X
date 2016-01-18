//solution store the anagrams into HashMapList
public class Solution {
	public void sort(String[] array) {
		HashMapList<String, String> mapList = new HashMapList<String, String>();
		//group the anagram
		for (String s : array) {
			//有序的KEY
			String key = sortChars(s);
			mapList.put(key, s);  
		}
		//convert the hashtable into array
		int index = 0;
		for (String key : mapList.keySet()) {
			ArrayList<String> list = mapList.get(key);
			for (String t : list) {
				array[index] = t;
				index++;
			}
		}
	}

	public Strng sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
}