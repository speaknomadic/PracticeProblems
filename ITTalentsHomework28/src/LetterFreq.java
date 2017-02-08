import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterFreq {

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	private static final int MAX_BAR_SIZE = 100;

	private static String text = "Terrorist is a 1985 political novel written by British novelist Doris Lessing. It was first published in September 1985 in the United Kingdom by Jonathan Cape, and in the United States by Alfred A. Knopf. The story examines events in the life of Alice, a nave and well-intentioned squatter, who moves in with a group of radicals in London, and is drawn into their terrorist activities. Lessing was inspired to write The Good Terrorist by the Irish Republican Army (IRA) bombing of the Harrods department store in London in 1983. She had been a member of the British Communist Party in the early 1950s, but later grew disillusioned with communism. Three reviewers labelled The Good Terrorist as a satire, while Lessing called it humorous. Some critics called the novel's title an oxymoron, stating that it highlights Alice's ambivalent nature, and that she is neither a good person, nor a good revolutionary.";

	public static void main(String[] args) {

		Map<Character, Integer> counters = new HashMap<Character, Integer>();

		for (Character c : text.toCharArray()) {
			/*
			 * 
			 */
			if (c.isAlphabetic(c) == false) {
				continue;
			}

			/*
			 * 
			 */
			c = c.toUpperCase(c);

			/*
			 * 
			 */
			if (counters.containsKey(c) == false) {
				counters.put(c, 0);
			}

			/*
			 * 
			 */
			counters.put(c, counters.get(c) + 1);

		}

		// for (Map.Entry<Character, Integer> entry : counters.entrySet()) {
		// System.out.println(entry.getKey() + " : " + entry.getValue());
		// }

		Map<Character, Integer> sorted = sortByValue(counters);
		int maxValue = Collections.max(sorted.values());
		for (Map.Entry<Character, Integer> entry : sorted.entrySet()) {
			System.out.print(entry.getKey() + " : " + entry.getValue() + "\t");

			for (int i = 0; i < MAX_BAR_SIZE * entry.getValue() / maxValue; i++) {
				System.out.print("#");
			}

			System.out.println();
		}
	}
}
