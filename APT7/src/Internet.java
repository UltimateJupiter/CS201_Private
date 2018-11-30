import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Internet {
	
	public int groupCount(Map<String, ArrayList<String>> map) {
		List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
		List<String> keys = new ArrayList<String>(map.keySet());
		Collections.sort(keys);
		
		while (keys.size() > 0) {
		    int p_size = keys.size();
			ArrayList<String> group = new ArrayList<String>();
			group.add(keys.get(0));
			// System.out.println(group.toString());
			
			while (true) {
				for (int i = 0; i < group.size(); i++) {
					String key = group.get(i);
					keys.remove(key);
					if (! map.containsKey(key)) continue;
					for (String new_key: map.get(key)) {
						if (! group.contains(new_key)) {
							group.add(new_key);
						}
					}
				}
				if (p_size == keys.size()) break;
				p_size = keys.size();
			}
			total.add(group);
		}
		System.out.println(total.size());
		return total.size();
	}
	
	public int articulationPoints(String[] routers) {
		Map<String, ArrayList<String>> map_gen = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < routers.length; i++) {
			String tmp = routers[i];
			ArrayList<String> tmp_ls = new ArrayList<String>();
			for (String str: tmp.split("\\s+")) {
				tmp_ls.add(str);
			}
			map_gen.put(Integer.toString(i), tmp_ls);
		}
		int base_amount = groupCount(map_gen);
		int cnt = 0;
		for (int i = 0; i < map_gen.size(); i++) {
			String key = Integer.toString(i);
			ArrayList<String> tmp = map_gen.get(key);
			map_gen.remove(key);
			if (groupCount(map_gen) > base_amount) cnt += 1;
			map_gen.put(key, tmp);
		}
		
		return cnt;
	}
}
