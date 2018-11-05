import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortedFreqs {
    public int[] freqs(String[] data) {
    	
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	
    	for (String str: data) {
        	map.putIfAbsent(str, 0);
        	map.put(str, map.get(str) + 1);
        }
        String[] tmp = new String[map.keySet().size()];
        int k = 0;
        for (String key: map.keySet()) {
        	tmp[k] = key;
            k++;
        }
        Arrays.sort(tmp);
        
        int[] ret = new int[map.keySet().size()];
        for (int i = 0; i < map.keySet().size(); i++) {
        	ret[i] = map.get(tmp[i]);
        }
        
        return ret;
    }
}