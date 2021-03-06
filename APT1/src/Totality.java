
public class Totality {
	public int sum(int[] a, String stype) {
        int sum = 0;
        
        int start = 0;
        int lapse = 1;
        
        if (stype.equals("odd")) {
        	start = 1;
        	lapse = 2;
        }
        if (stype.equals("even")) {
        	start = 0;
        	lapse = 2;
        }
        
        for(int k=start; k<a.length; k+=lapse) {
        	sum += a[k];
        }
        return sum;
    }
}