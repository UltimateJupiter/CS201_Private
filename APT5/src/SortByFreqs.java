import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortByFreqs {
	
	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	public class comp implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			
			if (map.get(o1) != map.get(o2)) return map.get(o2) - map.get(o1);
			return o1.compareTo(o2);
		}
		
	}
	
    public String[] sort(String[] data) {
        for (String str: data) {
        	map.putIfAbsent(str, 0);
        	map.put(str, map.get(str) + 1);
        }
        String[] ret = new String[map.keySet().size()];
        int i = 0;
        for (String key: map.keySet()) {
        	ret[i] = key;
            i++;
        }
        Arrays.sort(ret, new comp());
        return ret;
    }
}