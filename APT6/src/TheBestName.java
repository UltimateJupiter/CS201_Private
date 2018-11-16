import java.util.Arrays;
import java.util.Comparator;

public class TheBestName {
	
	public class comp implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			if (o1.equals("JOHN")) return -1;
			if (o2.equals("JOHN")) return 1;
			
			int c1 = 0;
			for (int i = 0; i < o1.length(); i++) {
				c1 += (int) o1.charAt(i) - 'A' + 1;
			}
			
			int c2 = 0;
			for (int i = 0; i < o2.length(); i++) {
				c2 += (int) o2.charAt(i) - 'A' + 1;
			}
			
			if (c1 == c2) return o1.compareTo(o2);
			return c2 - c1;
		}
		
	}
	
    public String[] sort(String[] names) {
    	Arrays.sort(names, new comp());
    	return names;
    }
}
