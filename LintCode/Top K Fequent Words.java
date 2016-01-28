import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Elem {
	protected int value;
	protected String key;
	public Elem(String key,  int value) {
		this.value = value;
		this.key = key;
	}
}


public class Top_K_Fequent_Words {
	public String[] topKFrequentWords(String[] words, int k) {
		if (k == 0) {
			return new String[0];
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {	
				int temp = map.get(words[i]);
				temp++;
				map.put(words[i], temp);
				continue;
			}
			map.put(words[i], 1);
		}
		
		Comparator<Elem> comp = new Comparator<Elem>() {
			@Override
			public int compare(Elem o1, Elem o2) {
				if (o1.value != o2.value) {
					return o1.value - o2.value;
				}
				return o2.key.compareTo(o1.key);
			}
		};
		
		PriorityQueue<Elem> q = new  PriorityQueue<Elem>(k, comp);
		for (String word : map.keySet()) {
			Elem front = q.peek();
			Elem elem1 = new Elem(word, map.get(word));
			if (q.size() < k) {q.add(elem1);}
			else if (comp.compare(elem1, front) > 0) {
				q.poll();
				q.add(elem1);
			}
		}
		
		String[] result = new String[k];
		int index = 0;
		while (!q.isEmpty()) {
			result[index++] = q.poll().key;
		}
		
		for(int i = 0; i < index / 2; i++) {
			String temp = result[i];
			result[i] = result[index - i - 1];
			result[index - i - 1] = temp;
		}

		return result;
		
		
	}
	
	public static void main(String[] args) {
		Top_K_Fequent_Words tkf = new Top_K_Fequent_Words();
		String[] words = new String[14];
		words[0] = "yes";
		words[1] = "lint";
		words[2] ="code";
		words[3] = "yes";
		words[4] = "code";
		words[5] = "baby";
		words[6] = "you";
		words[7] = "baby";
		words[8] = "chrome";
		words[9] = "safari";
		words[10] = "code";
		words[11] = "body";
		words[12] = "lint";
		words[13] = "code";
		String[] str = tkf.topKFrequentWords(words, 4);
		for (String str1 : str) {
			System.out.println(str1);
		}
	}
}
