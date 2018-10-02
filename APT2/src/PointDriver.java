
public class PointDriver {
    public static void main (String[] args) {
    	Point a = new Point(0,0);
    	Point b = new Point(3,4);
    	
    	System.out.printf("%s\n%s\n",a,b);
    	System.out.printf("%1.3g\n", b.getX());
    	System.out.printf("%1.3g\n", b.getY());
    	
    	System.out.printf("%1.3g\n", b.distanceFrom(a));
    	
    	Point c = new Point();
    	System.out.println(c);
    	
    	System.out.printf("\n");
    	
    	Point x = new Point(6,8);
    	Point y = new Point(300,400);
    	Point z = new Point(0,99);
    	
    	
    	System.out.println(x.howFarAway());
    	System.out.println(y.howFarAway());
    	System.out.println(z.howFarAway());
    	
    	
    }
}
