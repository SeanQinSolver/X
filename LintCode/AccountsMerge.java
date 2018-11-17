import java.util.*;
public class AccountsMerge {

	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
		List<String> l2 = new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com"));
		List<String> l3 = new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
		List<String> l4 = new ArrayList<>(Arrays.asList("Mary", "mary@mail.com"));

		List<List<String>> input = new ArrayList<>();
		input.add(l1);
		input.add(l2);
		input.add(l3);
		input.add(l4);

		AccountsMerge am = new AccountsMerge();
		List<List<String>> res = am.accountsMerge(input);

		for (List<String> list : res) {
			for (String s : list) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		HashMap<String, List<Integer>> map = new HashMap<>();
		// build the map
		buildMap(accounts, map);

		Set<String> visited = new HashSet<>();
		List<List<String>> result = new ArrayList<>();
		// go through the emails
		for (String email : map.keySet()) {
			List<String> emails = new ArrayList<>();
			dfs(accounts, map, email, visited, emails);
			if (emails.size() != 0) {
				Collections.sort(emails);
				emails.add(0, accounts.get(map.get(email).get(0)).get(0));
				result.add(emails);
			}
		}
		return result;
	}

	// dfs the graph
	private void dfs(List<List<String>> accounts, HashMap<String, List<Integer>> map, String email, Set<String> visited, List<String> list) {
		if (visited.contains(email)) return;
		list.add(email);
		visited.add(email);
		for (Integer index : map.get(email)) {
			List<String> account = accounts.get(index);
			for (int i = 1; i < account.size(); i++) {
				String asideEmail = account.get(i);
				if (!email.equals(asideEmail)) {
					dfs(accounts, map, asideEmail, visited, list);
				}
			}
		}
	}
	// build the map
	private void buildMap(List<List<String>> accounts, HashMap<String, List<Integer>> map) {
		for (int i = 0; i < accounts.size(); i++) {
			List<String> account = accounts.get(i);
			for (int j = 1; j < account.size(); j++) {
				String email = account.get(j);
				List<Integer> indexList = map.getOrDefault(email, new ArrayList<Integer>());
				indexList.add(i);
				map.put(email, indexList);
			}
		}
	}
}


// ["John", "johnsmith@mail.com", "john00@mail.com"]

// "johnsmith@mail.com" -> 0, 2
// "john00@mail.com" -> 0
// "johnnybravo@mail.com" -> 0
// "john_newyork@mail.com" -> 2
// "mary@mail.com" -> 3


// Input: 
// accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
// Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
// Explanation: 
// The first and third John's are the same person as they have the common email "johnsmith@mail.com".
// The second John and Mary are different people as none of their email addresses are used by other accounts.
// We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
// ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.