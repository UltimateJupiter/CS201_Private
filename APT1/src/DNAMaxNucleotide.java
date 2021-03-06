
public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {
    	
    	String output = "";
    	int max_num = 0, max_length = 0;
    	for (int i = 0; i < strands.length; i++) {
    		
    		int num = 0;
    		String[] ls = strands[i].split("");
    		for (int j = 0; j < ls.length; j++) {
    			if (ls[j].equals(nuc)) num += 1;
    		}
    		
    		if (num > max_num || (num == max_num && num > 0 && ls.length > max_length)) {
    			output = strands[i];
    			max_num = num; max_length = ls.length;
    		}
    	}
    	
        return output;
    }
}
