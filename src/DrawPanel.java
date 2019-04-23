import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {

	protected ArrayList<Lines> drawingComponents;
	HashMap<Integer, Integer> segments;

	Point middleMan;

	boolean isCompleted = false;

	int numSegmentsDrawn = 0;

	/**
	 * Paints the drawing lines on the Screen/Panel
	 */
	public void paintComponent(Graphics g) {
		g.drawString("Left-Click and hold anywhere to draw", 15, 15);
		g.drawRect(0, 0, 500, 800);
		for (int i = 0; i < drawingComponents.size() - 1; i++) {
			Point[] p = drawingComponents.get(i).getLine();
			if (i > 1) {
				Point[] p2 = drawingComponents.get(i - 1).getLine();
				if(!(Math.abs(p2[1].x - p[0].x) > 5 && Math.abs(p2[1].y - p[0].y) > 5)) {
				g.drawLine(p2[1].x - 485, p2[1].y - 50, p[0].x - 485, p[0].y - 50);
				}
			}
			g.drawLine(p[0].x - 485, p[0].y - 50, p[1].x - 485, p[1].y - 50);
		}
	}

	/**
	 * Constructs the drawPanel
	 */
	public DrawPanel() {
		super();
		drawingComponents = new ArrayList<>();
		segments = new HashMap<Integer, Integer>(1);
		setBackground(Color.WHITE);
		setBounds(450, 20, 500, 800);
		setLayout(null);
		addMouseMotionListener(new GHDDrawListener(this));
		this.setLocation(450, 20);
	}
}
