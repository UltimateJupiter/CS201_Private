import java.util.HashMap;
import java.util.Map;

public class BSTcount {
	Map<Integer, Long> map = new HashMap<Integer, Long>();
	
	private long getResults(int n) {
		if (map.keySet().contains(n)) return map.get(n);
		if (n < 2) return 1;
		long count = 0;
		for (int i = 0; i < n; i++) {
			count += getResults(i) * getResults(n - 1 - i);
		}
		map.put(n, count);
		return count;
	}
	
    public long howMany(int[] values) {
    	return getResults(values.length);
    }
}
