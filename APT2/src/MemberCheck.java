import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class MemberCheck {
      public String[] whosDishonest(String[] club1, 
                                    String[] club2, 
                                    String[] club3) {
    	  
    	  ArrayList<String> ls = new ArrayList<String>();
    	  ArrayList<String> all = new ArrayList<String>();
    	  ArrayList<String> got = new ArrayList<String>();
    	  HashSet<String> c1 = new HashSet<String>(Arrays.asList(club1));
    	  HashSet<String> c2 = new HashSet<String>(Arrays.asList(club2));
    	  HashSet<String> c3 = new HashSet<String>(Arrays.asList(club3));
    	  ArrayList<String> c1l = new ArrayList<String>(c1);
    	  ArrayList<String> c2l = new ArrayList<String>(c2);
    	  ArrayList<String> c3l = new ArrayList<String>(c3);
    	  
    	  all.addAll(c1l);
    	  all.addAll(c2l);
    	  all.addAll(c3l);
    	  
    	  for (String i : all) {
    		  if (got.contains(i) && (! ls.contains(i))) ls.add(i);
    		  got.add(i);
    	  }

    	  String[] ls_array = new String[ls.size()];
    	  Collections.sort(ls);
    	  ls_array = ls.toArray(ls_array);
    	  return ls_array;
      }
}