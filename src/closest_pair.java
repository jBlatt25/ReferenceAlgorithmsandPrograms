import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class closest_pair {

	
	public static class point{ //initializes a point
	public final double x;
	public final double y;

public point(double x, double y) { //creates a point with values
	this.x = x;
	this.y = y;
}
public String toString()
{  
	return "(" + x + ", " + y + ")";  }
}
public static class Pair{ //initializes first points as null
	public point point1 = null;
	public point point2 = null;
	public double distance = 0;
public Pair() {
	
}
public Pair(point point1, point point2) { //gets two points then finds the distance between them
	this.point1 = point1;
	this.point2 = point2;
	calcDistance();
}
public void update(point point1, point point2, double distance) {
	this.point1 = point1;
	this.point2 = point2;
	this.distance = distance;
}
public void calcDistance() { //calculates the distance
	this.distance = distance(point1,point2);
}

public static double distance( point point1, point point2) { //calculates the distance between the two points using pythag theorum (done using math.hypo)
	double xdist = point2.x - point1.x;
	double ydist = point2.y - point1.y;
	return Math.hypot(xdist, ydist);
}
public static Pair bruteForce(List<? extends point> points) { //bruteforce algorithm
	int numpoints = points.size();
	if (numpoints < 2) {
		return null;
	}
		Pair pair = new Pair(points.get(0), points.get(1));
		if (numpoints > 2) {
			for (int i = 0; i < numpoints - 1; i++)
		      {
		        point point1 = points.get(i);
		        for (int j = i + 1; j < numpoints; j++)
		        {
		          point point2 = points.get(j);
		          double distance = distance(point1, point2);
		          if (distance < pair.distance)
		            pair.update(point1, point2, distance);
		        }
		}
	}
	return pair;
} 
public String toString()
{  
	return point1 + "-" + point2 + " : " + distance;  
}
	public static void main(String[] args) {
		 int numPoints = 50;
		    List<point> points = new ArrayList<point>();
		    Random r = new Random();
		    for (int i = 0; i < numPoints; i++)
		      points.add(new point(r.nextDouble(), r.nextDouble()));
		    System.out.println("Generated " + numPoints + " random points");
		    long startTime = System.currentTimeMillis();
		    Pair bruteForceClosestPair = bruteForce(points);
		    long elapsedTime = System.currentTimeMillis() - startTime;
		    System.out.println("Brute force (" + elapsedTime + " ms): " + bruteForceClosestPair);
	}

}
}