import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GHDDrawListener implements MouseMotionListener{

	private GHDDrawPanel drawPanel;

	boolean isDrawing;
	
	GHDLines line;
	
	/**
	 * 
	 * @param drawPanel
	 *            - The panel that you want to make a draw area (Must be of type
	 *            DrawPanel)
	 */
	public GHDDrawListener(GHDDrawPanel drawPanel) {
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
		} else {
			if (isDrawing) {
				line = new GHDLines(e.getLocationOnScreen());
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
		line = null;
		isDrawing = false;
	}
}
