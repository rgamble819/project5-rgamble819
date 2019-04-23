import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {

	protected ArrayList<Lines> drawingComponents;
	
	Point middleMan;
	
	/**
	 * Paints the drawing lines on the Screen/Panel
	 */
	public void paintComponent(Graphics g) {
		for (int i = 0; i < drawingComponents.size() - 1; i++) {
			Point[] p = drawingComponents.get(i).getLine();
			if(i>1) {
			Point[] p2 = drawingComponents.get(i-1).getLine();
			g.drawLine(p2[1].x - 485, p2[1].y - 50, p[0].x - 485, p[0].y - 50);

			
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
		setBackground(Color.WHITE);
		setBounds(450, 20, 500, 800);
		setLayout(null);
		addMouseMotionListener(new GHDDrawListener(this));
		this.setLocation(450, 20);
	}
}
