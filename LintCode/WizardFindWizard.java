import java.util.*;

// 1 + 4 - 1 + 64 - 4 = 64
// 1 + 4 - 1 + 9 - 4 + 64 - 9

// BFS  打印路线？

public class WizardFindWizard {

	int min = Integer.MAX_VALUE;
	List<Wizard> shortPath = new ArrayList<>(); 

	public static void main(String[] args) {
		Wizard w1 = new Wizard(0, 0);
		Wizard w2 = new Wizard(1, 1);
		Wizard w3 = new Wizard(2, 2);
		Wizard w4 = new Wizard(3, 3);
		Wizard w5 = new Wizard(4, 4);
		Wizard w6 = new Wizard(5, 5);
		Wizard w7 = new Wizard(6, 6);
		Wizard w8 = new Wizard(7, 7);
		Wizard w9 = new Wizard(8, 8);
		Wizard w10 = new Wizard(9, 9);

		w1.heKnows.add(w2);
		w2.heKnows.add(w3);
		w3.heKnows.add(w1);
		w3.heKnows.add(w4);
		w4.heKnows.add(w9);
		w3.heKnows.add(w9);

		Wizard[] w = {w1, w2, w3, w4, w9};

		List<Wizard> list = new ArrayList<>();

		WizardFindWizard wfw = new WizardFindWizard();
		int res = wfw.lowestCostToKnowAWizard(list, w1, w9);
		System.out.println(res);
	}


	public int lowestCostToKnowAWizard(List<Wizard> list, Wizard start, Wizard end) {
		if (start == end) return 0;
		HashSet<Integer> visited = new HashSet<>();
		visited.add(start.num);
		list.add(start);
		dfs(start, end, list, visited, 0);

		for (Wizard w : shortPath) {
			System.out.print(w.num + "->");
		}

		return min;
	}

	private void dfs(Wizard start, Wizard end, List<Wizard> list, HashSet<Integer> visited, int sum) {
		if (start.num == end.num) {
			if (sum < min) {
				min = sum;
				shortPath = new ArrayList<Wizard>(list);
				return;
			}
		}
		for (Wizard w : start.heKnows) {
			if (visited.contains(w.num)) continue;
			visited.add(w.num);
			list.add(w);
			int expense = calExpense(w, start);
			sum += expense;
			dfs(w, end, list, visited, sum);
			list.remove(w);
			visited.remove(w.num);
			sum -= expense;
		}
	}

	private int calExpense(Wizard w1, Wizard w2) {
		return (int)(Math.pow(w1.level - w2.level, 2));
	}

	private static class Wizard {
		int num;
		int level;
		Set<Wizard> heKnows;
		public Wizard(int num, int level) {
			this.num = num;
			this.level = level;
			this.heKnows = new HashSet<>();
		}
	}
}