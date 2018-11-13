import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpreadingNews {
	
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	
    private int getMinTime(int head) {
    	
    	if (! map.keySet().contains(head)) return 0;
    	
    	List<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < map.get(head).size(); i++) {
			tmp.add(getMinTime(map.get(head).get(i)));
		}
		Collections.sort(tmp, Collections.reverseOrder());
		for (int i = 0; i < map.get(head).size(); i++) {
			tmp.add(i + 1 + tmp.get(i));
		}
		return Collections.max(tmp);
	}
	
	public int minTime(int[] supervisors) {
    	
    	for (int i = 0; i < supervisors.length; i++) {
    		map.putIfAbsent(supervisors[i], new ArrayList<Integer>());
    		map.get(supervisors[i]).add(i);
    	}
    	return getMinTime(0);
    }
}
