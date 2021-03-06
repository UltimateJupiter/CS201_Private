
public class CirclesCountry {
	
	public boolean border_detect(double cx, double cy, double cr, double px, double py ) {
	    double dist = Math.sqrt(Math.pow(cx - px, 2) + Math.pow(cy - py, 2));
	    boolean result = dist < cr;
		return result;
	}
	
    public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			boolean res = (border_detect(x[i], y[i], r[i], x1, y1) == border_detect(x[i], y[i], r[i], x2, y2));
			int val = res? 0 : 1;
			sum += val;
		}
		return sum;
    }
    /*
    public static void main(String[] args){
    	int x[] = {1,-3,2,5,-4,12,12};
    	int y[] = {1,-1,2,5,5,1,1};
    	int r[] = {8,1,2,1,1,1,2};
    	int x1 = -5, y1 = 1, x2 = 12, y2 = 1;
    	int res = leastBorders(x, y, r, x1, y1, x2, y2);
    	System.out.println(res);
    }*/
    
 }