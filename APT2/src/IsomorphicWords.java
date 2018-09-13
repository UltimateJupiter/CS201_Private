import java.util.HashMap;

public class IsomorphicWords {
	public int countPairs(String[] words) {
        int cnt = 0;
        
        for (String i : words) {
        	for (String j : words) {
        		int suc = 1;
        		char[] iList = i.toCharArray();
        		char[] jList = j.toCharArray();
        		HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        		HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        		
        		for (int k = 0; k < jList.length; k++) {
        			if (! map1.containsKey(iList[k])) {
        				map1.put(iList[k], jList[k]);
        			}
        			else {
        				if (jList[k] != map1.get(iList[k]))
        					suc = 0;
        			}	
    				if (! map2.containsKey(jList[k])) {
        				map2.put(jList[k], iList[k]);
        			}
        			else {
        				if (iList[k] != map2.get(jList[k]))
        					suc = 0;
        			}
        		}
        		cnt += suc;
        	}
        }
        
        return (cnt - words.length)/2;
    }
}
