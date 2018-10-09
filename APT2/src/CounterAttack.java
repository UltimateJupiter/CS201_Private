import java.util.HashMap;

public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        String[] sep = str.split(" ");
    	int[] sums = new int[words.length];
    	
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	
    	for (String i : words) {
    		map.put(i, 0);
    	}
    	for (String i : sep) {
    		if (! map.containsKey(i)) {
    			map.put(i, 1);
    		}
    		else {
    			map.put(i, map.get(i) + 1);
    		}
    	}
    	
    	for (int j = 0; j < words.length; j++) {
    		System.out.println(words[j]);
    		sums[j] = map.get(words[j]);
    	}
    	

        return sums;
    }
}