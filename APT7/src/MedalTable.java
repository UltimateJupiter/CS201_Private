import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedalTable {
    
    Map<String, Country> map = new HashMap<String, Country>();
    
    class Country {
        String name;
        int g = 0, s = 0, b = 0;
        
        Country(String n){
            name = n;
        }
        
        public String gn() {
            return name;
        }
        
        public void ag() {
            g++;
        }
        
        public void as() {
            s++;
        }
        
        public void ab() {
            b++;
        }
        
        public int gg() {
            return g;
        }
        
        public int gs() {
            return s;
        }
        
        public int gb() {
            return b;
        }
        
        public String toString() {
            return name + " " + Integer.toString(g) + " " + Integer.toString(s) + " " + Integer.toString(b);
        }
        
    }
    
    public String[] generate(String[] results) {
        for (String str: results) {
            String[] tmp = str.split("\\s+");
            map.putIfAbsent(tmp[0], new Country(tmp[0]));
            map.putIfAbsent(tmp[1], new Country(tmp[1]));
            map.putIfAbsent(tmp[2], new Country(tmp[2]));
            map.get(tmp[0]).ag();
            map.get(tmp[1]).as();
            map.get(tmp[2]).ab();
        }
        
        List<Country> ls = new ArrayList<Country>();
        for (String str: map.keySet()) {
            ls.add(map.get(str));
        }
        
        Collections.sort(ls, Comparator.comparing(Country::gn));
        Collections.sort(ls, Comparator.comparing(Country::gb).reversed());
        Collections.sort(ls, Comparator.comparing(Country::gs).reversed());
        Collections.sort(ls, Comparator.comparing(Country::gg).reversed());
        
        String[] ret = new String[ls.size()];
        for(int i = 0; i < ls.size(); i++) {
        	ret[i] = ls.get(i).toString();
        }
        return ret;
    }    
}
