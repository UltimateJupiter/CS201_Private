import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetAside {
	
    private boolean contains_word(String word, String longword) {
    	String[] tmp = longword.split("\\s+");
    	List<String> tmp_ls = new ArrayList<String>(Arrays.asList(tmp));
    	return tmp_ls.contains(word);
    }
	public String common(String[] list) {
    	Set<String> all_words = new HashSet<String>();
    	for (String str : list) {
    		String[] sub_split = str.split("\\s+");
    		for (String str1 : sub_split) {
    			all_words.add(str1);
    		}
    	}
    	
    	List<String> ret = new ArrayList<String>();
    	
    	for (String word : all_words) {
    		int pass = 1;
    		for (String str : list) {
    			if (! contains_word(word, str)) pass = 0;
    		}
    		if (pass == 1) ret.add(word);
    	}
    	
    	Collections.sort(ret);
    	
    	String base = "";
    	for (String str : ret) {
    		base += str;
    		base += " ";
    	}
    	
    	if (base.length() > 0) base = base.substring(0, base.length() - 1);
        return base;
    }
}