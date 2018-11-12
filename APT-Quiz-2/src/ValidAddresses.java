import java.util.ArrayList;
import java.util.List;

public class ValidAddresses {
    
	List<String> ret = new ArrayList<String>();
	
	private String assemble(List<String> input) {
		return input.get(0) + "." + input.get(1) + "." + input.get(2) + "." + input.get(3);
	}
	
	private void valid_h(String remaining, int count, List<String>already) {
		
		if (count == 1) {
			if (remaining.length() > 3) return;
			if (remaining.length() < 1) return;
			if (Integer.parseInt(remaining) < 256 && Integer.parseInt(remaining) >= 0 && (remaining.equals("0") || !remaining.substring(0, 1).equals("0"))) {
				already.add(remaining);
				ret.add(assemble(already));
				System.out.println(assemble(already));
			}
			return;
		}
		
		if (remaining.length() < count) return;
		
		for (int step = 1; step <= 3; step ++) {
			List<String> new_already = new ArrayList<String>();
			new_already.addAll(already);
			if (remaining.length() < step) return;
			String parse = remaining.substring(0, step);
			String new_remain = remaining.substring(step, remaining.length());
			
			if (Integer.parseInt(parse) < 256) {
				if (parse.equals("0") || !parse.substring(0, 1).equals("0")) {
					new_already.add(parse);
				    valid_h(new_remain, count - 1, new_already);
				}
			}
		}
		
	}
	
	public String[] valid(String possible){
        valid_h(possible, 4, new ArrayList<String>());
        String[] fin_ret = new String[ret.size()];
        fin_ret = ret.toArray(fin_ret);
        return fin_ret;
    }
}