import java.awt.Point;
import java.util.ArrayList;

public class Lines {

	//private ArrayList<Point> points;
	
	private Point[] points;
	
	public Lines(Point locationOnScreen) {
		/*points = new ArrayList<>();
		points.add(locationOnScreen);*/
		points = new Point[2];
		points[0] = locationOnScreen;
		points[1] = locationOnScreen;
	}
	
	public Point[] getLine() 
	{
		return points;
	}
	
	public Lines(Lines line) {
	//	line.getAllPoints();

	}

	public void addPoint(Point locationOnScreen) {
		points[1] = locationOnScreen;
	}
	
	

	/*public void addPoint(Point p) 
	{
		points.add(p);
		points.add(p);
	}

	public Point[] getLine(int i) 
	{
		return points;
	}
	
	public int getnPoints() 
	{
		return points.size();
	}
	
	public ArrayList<Point> getAllPoints()
	{
		return points;
	}*/
}
