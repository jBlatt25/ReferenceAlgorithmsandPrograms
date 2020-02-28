import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class convex_hull {
public static class Point implements Comparable<Point>{
private int x;
private int y;
public Point(int x, int y) { //instantiate a point with values
    this.x = x;
    this.y = y;
}
@Override
	public int compareTo(Point a) { //compare the x variales
		return Integer.compare(x, a.x);
	}
	@Override
	public String toString() { //format the final output
		return String.format("(%d,%d", x,y);
	}
}
private static List<Point> convexHull(List<Point> p) { //convethull algorithm method
    p.sort(Point::compareTo);
    List<Point> hull = new ArrayList<>();

    // lower hull
    for (Point pt : p) {
        while (hull.size() >= 2 && !ccw(hull.get(hull.size() - 2), hull.get(hull.size() - 1), pt)) {
            hull.remove(hull.size() - 1);
        }
        hull.add(pt);
    }

    // upper hull
    int t = hull.size() + 1;
    for (int i = p.size() - 1; i >= 0; i--) {
        Point pt = p.get(i);
        while (hull.size() >= t && !ccw(hull.get(hull.size() - 2), hull.get(hull.size() - 1), pt)) {
            hull.remove(hull.size() - 1);
        }
        hull.add(pt);
    }

    hull.remove(hull.size() - 1);
    return hull;
}
    private static boolean ccw(Point a, Point b, Point c) { //compare points 
        return ((b.x - a.x) * (c.y - a.y)) > ((b.y - a.y) * (c.x - a.x));
    }
	public static void main(String[] args) {
		 List<Point> points = Arrays.asList(new Point(16, 3), //test values to test the algorithm
                 new Point(12, 17),
                 new Point(0, 6),
                 new Point(-4, -6),
                 new Point(16, 6),

                 new Point(16, -7),
                 new Point(16, -3),
                 new Point(17, -4),
                 new Point(5, 19),
                 new Point(19, -8),

                 new Point(3, 16),
                 new Point(12, 13),
                 new Point(3, -4),
                 new Point(17, 5),
                 new Point(-3, 15),

                 new Point(-3, -9),
                 new Point(0, 11),
                 new Point(-9, -3),
                 new Point(-4, -2),
                 new Point(12, 10));
List<Point> hull = convexHull(points); //call the convex hull methods
System.out.printf("Convex Hull: %s\n", hull); //display final result
	}

}
