import java.util.ArrayList;

public class Starter {
     public int begins(String[] words, String first) {
         int cnt = 0;
         char target = first.toCharArray()[0];
         ArrayList<String> tmp = new ArrayList<String>();
         
         for (String i : words) {
        	 if (i.toCharArray()[0] == target && (! tmp.contains(i))) {
        		 cnt += 1;
        		 tmp.add(i);
        	 }
         }
		 return cnt;
     }
 }