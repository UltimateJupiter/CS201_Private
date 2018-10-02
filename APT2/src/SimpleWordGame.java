import java.util.ArrayList;
import java.util.Arrays;

public class SimpleWordGame {
    public int points(String[] player, String[] dictionary) {
        int scr = 0;
        ArrayList<String> assigned = new ArrayList<String>();
        ArrayList<String> dList = new ArrayList<String>(Arrays.asList(dictionary));
        
        for (String i : player) {
        	if (assigned.contains(i)) continue;
        	if (dList.contains(i)) scr += i.length()*i.length();
        	assigned.add(i);
        }
    	
    	// you write code here
    	return scr;
    }
}