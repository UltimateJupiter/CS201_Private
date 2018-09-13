import java.util.*;


public class Anonymous {
	
	private HashMap<Character, Integer> convert_to_charmap(String str) {
		HashMap<Character, Integer> map = new HashMap();
		char[] chars = str.toCharArray();
		for (char i : chars) {
			if (i != ' ') {
				if (i >= 97) {
					char tmp = (char) (i - 32);
					i = tmp;
				}
				if (! map.containsKey(i)) map.put(i, 1);
				else map.put(i, map.get(i) + 1);
			}
		}
		return map;
	}
	
	public int howMany(String[] headlines, String[] messages) {
		
		int cnt = 0;
		
		ArrayList<HashMap<Character, Integer>> message_maps = new ArrayList<HashMap<Character, Integer>>();
		String concat_line = headlines[0];
		if (headlines.length > 1) {
			for (int i = 1; i < headlines.length; i++) {
				concat_line = concat_line.concat(headlines[i]);
			}
		}
		
		HashMap<Character, Integer> hdlns_map = convert_to_charmap(concat_line);
		Set<Character> hdlns_set = hdlns_map.keySet();
		
		for (String msg : messages) {
			HashMap<Character, Integer> msg_map = convert_to_charmap(msg);
			
			int res = 1;
			for (char key : msg_map.keySet()) {
				if (! hdlns_set.contains(key)) {
					res = 0;
					break;
				}
				else if (hdlns_map.get(key) < msg_map.get(key)) {
					res = 0;
					break;
				}
			}
			cnt += res;
		}
        return cnt;
    }
}
