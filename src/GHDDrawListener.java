import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GHDDrawListener implements MouseMotionListener{

	private DrawPanel drawPanel;

	boolean isDrawing;

	int numPoints = 0;
	
	Lines line = null;
	
	/**
	 * 
	 * @param drawPanel
	 *            - The panel that you want to make a draw area (Must be of type
	 *            DrawPanel)
	 */
	public GHDDrawListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}

	/**
	 * Mouse dragged event - Creates a Line object when the mouse does action
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if (isDrawing && line != null) {
			line.addPoint(e.getLocationOnScreen());
			drawPanel.drawingComponents.add(line);
			line = null;
			drawPanel.segments.put(drawPanel.numSegmentsDrawn, numPoints);
		} else {
			if (isDrawing) {
				line = new Lines(e.getLocationOnScreen());
				numPoints++;
			}
		}
		drawPanel.repaint();
		isDrawing = true;
	}

	/**
	 * Stops the draw Event
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		drawPanel.numSegmentsDrawn++;
		line = null;
		isDrawing = false;
	}
}
