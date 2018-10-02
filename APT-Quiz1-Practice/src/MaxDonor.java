import java.util.HashMap;
import java.util.Map;

public class MaxDonor {
    public String generous(String[] orgs, int[] amount) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < orgs.length; i++) {
        	if (! map.containsKey(orgs[i])) {
        		map.put(orgs[i], amount[i]);
        	}
        	else {
        		map.put(orgs[i], map.get(orgs[i]) + amount[i]);
        	}
        }
        
        int max = 0;
        for (int i: map.values()) {
        	if (i > max) max = i;
        }
        
        for (String str : map.keySet()) {
        	if (map.get(str) == max) {
        		return str + ":$" + max;
        	}
        }
        
        return "";
    }
}