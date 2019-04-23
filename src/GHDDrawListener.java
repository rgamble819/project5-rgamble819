import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GHDDrawListener implements MouseMotionListener {

	private DrawPanel drawPanel;

	private boolean isDrawing;

	Lines line = null;

	public GHDDrawListener(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (isDrawing && line != null) {
			line.addPoint(e.getLocationOnScreen());
			drawPanel.drawingComponents.add(line);
			line = null;
			/*
			line.addPoint(e.getLocationOnScreen());
			System.out.println("Old line");*/
		} else {
			if (isDrawing) {
				line = new Lines(e.getLocationOnScreen());
			/*	System.out.println("New line created");
				line = new Lines(e.getLocationOnScreen());
				drawPanel.drawingComponents.add(new Lines(line));*/

			}
		}
		drawPanel.repaint();
		isDrawing = true;

	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{	
		drawPanel.repaint();
		line = null;
		isDrawing = false;
	}
}
