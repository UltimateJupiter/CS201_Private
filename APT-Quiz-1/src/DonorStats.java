import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DonorStats {
    
	private String split_info(String input) {
	    String[] raw_split = input.split(":");
	    String[] cnt = raw_split[1].split(",");
	    int sum = 0;
	    for (String num : cnt) {
	    	sum += Integer.parseInt(num);
	    }
	    return raw_split[0] + " " + cnt.length + " " + sum;
	}
	
	public String[] calculate(String[] donations) {
        Map<String, Integer> map_cnt = new HashMap<String, Integer>();
        Map<String, Integer> map_total = new HashMap<String, Integer>();
        List<String> names = new ArrayList<String>();
        
        for (String info : donations) {
        	String ret = split_info(info);
        	String[] splitted_ret = ret.split("\\s+");
        	String name = splitted_ret[0];
        	
        	int count = Integer.parseInt(splitted_ret[1]);
        	int total = Integer.parseInt(splitted_ret[2]);
        	
        	if (! map_cnt.containsKey(splitted_ret[0])) {
        		map_cnt.put(name, 0);
        		names.add(name);
        	}
        	
        	if (! map_total.containsKey(splitted_ret[0])) {
        		map_total.put(name, 0);
        	}
        	
        	map_total.put(name, map_total.get(name) + total);
        	map_cnt.put(name, map_cnt.get(name) + count);
        }
        Collections.sort(names);
        String[] ret = new String[names.size()];
        for (int i = 0; i < names.size(); i++) {
        	ret[i] = String.format("%s:%d:%d", names.get(i), map_cnt.get(names.get(i)), map_total.get(names.get(i)));
        }
        
        return ret;
    }
}