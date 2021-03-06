import java.util.Arrays;
import java.util.List;

public class SandwichBar
{
    // public static int whichOrder(String[] available, String[] orders){
    public int whichOrder(String[] available, String[] orders){
    	
    	List<String> available_list = Arrays.asList(available);
    	for (int i = 0; i < orders.length; i++) {
    		String[] keys = orders[i].split(" ");
    		int success = 0;
    		
    		for (int j = 0; j < keys.length; j++) {
    			// System.out.println(keys[j]);
    			if (available_list.contains(keys[j]) == false) {
    				success += 1;
    			}
    		}
    		if(success == 0) return i;
    	}
    	return -1;
    }
    /*
    public static void main(String[] args) {
    	String[] s1 = { "cheese", "cheese", "cheese", "tomato" };
    	String[] s2 = { "ham ham ham", "water", "pork", "bread", "cheese tomato cheese", "beef" };
    	int res = whichOrder(s1, s2);
    	System.out.println(res);
    }*/
}