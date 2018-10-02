
public class Point {
	private double myX;
	private double myY;
	
	public Point(double x, double y) {
		myX = x;
		myY = y;
	}
	
	public Point() {
		myX = 0;
		myY = 0;
	}
	
	public String howFarAway() {
		Point origin = new Point();
		double distance = this.distanceFrom(origin);
		if (distance <= 10) {
			return "close";
		}
		else if (distance <= 100) {
			return "not close";
		}
		else {
			return "far";
		}
	}
	
	public double distanceFrom(Point other) {
		double dx = myX - other.myX;
		double dy = myY - other.myY;
		return Math.sqrt(dx*dx + dy*dy);
		
	}
	
	public double getX() {
		return myX;
	}
	
	public double getY() {
		return myY;
	}
	
	public String toString() {
		return String.format("(%2.3f,%2.3f)", myX, myY);
	}
}
