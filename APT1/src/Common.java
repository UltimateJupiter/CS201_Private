import java.util.HashSet;
import java.util.Set;

public class Common {
	
	public int seg (String[] ls, String letter) {
		int cnt = 0;
		for (int i = 0; i < ls.length; i++) {
			if (ls[i].equals(letter)) cnt += 1;
		}
		return cnt;
	}
	
	public int count (String a, String b) {
		String[] ls_a = a.split(""); String[] ls_b = b.split("");
		String[] letter_ls = "abcdefghijklmnopqrstuvwxyz".split("");
		/*Set<String> letter_set = new HashSet<String>();
		for (int i = 0; i < ls_a.length; i++) letter_set.add(ls_a[i]);
		for (int i = 0; i < ls_b.length; i++) letter_set.add(ls_b[i]);
		String[] letter_ls = (String[]) letter_set.toArray();*/
		
		int sum = 0;
		for (int i = 0; i < letter_ls.length; i++) {
			String letter = letter_ls[i];
			sum += Math.min(seg(ls_a, letter), seg(ls_b, letter));
		}
		
		
        return sum;
    }
}
