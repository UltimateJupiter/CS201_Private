import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SyllableSorting {
	
	public List<String> seg(String str){
		String base = "aeiou";
		List<String> ls = new ArrayList<String>();
		int start = 0, end = 1;
		
		for (int i = 1; i < str.length(); i++) {
			
			/*
			System.out.println("");
			System.out.println(str.substring(i - 1));
			System.out.println(str.substring(i));
			System.out.println(base.contains(str.substring(i - 1)));
	        System.out.println(base.contains(str.substring(i)));
			*/
			end += 1;
			
			if (end >= str.length() - 1) {
				// System.out.println("Horay");
				ls.add(str.substring(start, str.length()));
				break;
			}
			
		    if (base.contains(str.substring(i, i + 1)) && (!base.contains(str.substring(i + 1, i + 2)))){
				ls.add(str.substring(start, end));
				start = end;
			}
		}
		return ls;
	}
	
	public class comp implements Comparator<String>{

		
		public int compare(String o1, String o2) {
			
			
			String base = "aeiou";
			List<String> l1 = seg(o1);
			List<String> l2 = seg(o2);
			List<String> l1_S = new ArrayList<String>();
			List<String> l2_S = new ArrayList<String>();
			l1_S.addAll(l1);
			l2_S.addAll(l2);
			if (o1.equals("ra") && o2.equals("zi")) {
				System.out.println("\n---");
				System.out.println(o1);
				System.out.println(l1.toString());
			}
		
			Collections.sort(l1_S);
			Collections.sort(l2_S);
			
			//System.out.println(l1_S.toString());
			if (l1_S.equals(l2_S)) {
				l1_S = l1;
				l2_S = l2;
				// System.out.println("Weird");
			}
			
			// if (l1_S.size() != l2_S.size()) return l1_S.size() - l2_S.size();
			for (int i = 0; i < Math.max(l2_S.size(), l1_S.size()); i++) {
				if (i == l1_S.size()) return -1;
				if (i == l2_S.size()) return 1;
				if (l1_S.get(i).compareTo(l2_S.get(i)) != 0) return l1_S.get(i).compareTo(l2_S.get(i));
			}
			return 0;
		}
		
	}
    public String[] sortWords(String[] words) {
        Arrays.sort(words, new comp());
        return words;
    }
}