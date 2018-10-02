import java.util.List;
import java.util.ArrayList;

public class HashTaggery {
	
	private double check_exist(String[] tags, String[] words) {
		List<String> tmp_ls = new ArrayList<String>();
		for (String word : words) {
			String last = word.substring(word.length() - 1);
			if (last == "." || last == ",") word = word.substring(0, word.length() - 1);
			tmp_ls.add(word);
		}
		for (String tag : tags) {
			if (tmp_ls.contains(tag)) return 1;
		}
		return 0;
	}
	
    public String maxTag(String[] tags, String[] messages) {
        double cnt = 0;
        
        for (String str : messages) {
        	String[] raw = str.split("\\s+");
        	cnt += check_exist(tags, raw);
        }
        double full = messages.length;
        
        if (cnt / full < 0.75) return "missed";
        
        return "tagged";
    }
}