import java.util.ArrayList;
import java.util.List;

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        
        List<String> tmp = new ArrayList<String>();
        for (String str : list) {
        	if (str.length() >= minLength && (! tmp.contains(str))) tmp.add(str);
        }
    	String[] out = new String[tmp.size()];
        out = tmp.toArray(out);
        
        return out;
    }
}