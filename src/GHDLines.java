import java.awt.Point;

public class GHDLines {
	
	private Point[] points;
	
	/**
	 *  Creates a line object that will be drawn onto screen. Consists of 2 points
	 * @param locationOnScreen - From mouse Event
	 */
	GHDLines(Point locationOnScreen) {
		points = new Point[2];
		points[0] = locationOnScreen;
		points[1] = locationOnScreen;
	}
	
	/**
	 * 
	 * @return Point array of the points the line consists of. [Point1, Point2]
	 */
	Point[] getLine() 
	{
		return points;
	}
	
	/**
	 * 
	 * @param locationOnScreen - Used by mouseListener to add the second point to the Line
	 */
	void addPoint(Point locationOnScreen) {
		points[1] = locationOnScreen;
	}
}
