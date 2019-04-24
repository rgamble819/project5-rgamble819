import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GHDDrawPanel extends JPanel {

	ArrayList<GHDLines> drawingComponents;

	/**
	 * Paints the drawing lines on the Screen/Panel
	 */
	public void paintComponent(Graphics g) {
		g.drawString("Left-Click and hold anywhere to draw", 15, 15);
		//g.drawString("Enter R-G-B Value and click enter to change colors", 0, 785);   
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

	/*
	JTextField r = new JTextField("0");
	JTextField g = new JTextField("0");
	JTextField b = new JTextField("0");
	*/
	
	/**
	 * Constructs the drawPanel
	 */
	public GHDDrawPanel() {
		super();
		drawingComponents = new ArrayList<>();
		setBackground(Color.WHITE);
		setBounds(450, 20, 500, 800);
		setLayout(null);
		addMouseMotionListener(new GHDDrawListener(this));
		setLocation(450, 20);
	/*
		r.setBounds(325, 775, 35, 25);
		g.setBounds(375, 775, 35, 25);
		b.setBounds(425, 775, 35, 25);
		add(r);
		add(g);
		add(b);
	*/
	}
	
	public void clear() 
	{
		drawingComponents = new ArrayList<GHDLines>();
		repaint();
	}
	
	//TODO:
	/*
	public void changeColor(int r, int g, int b) 
	{
		float[] hsb = new float[3];
		Color.RGBtoHSB(r, g, b, hsb);
		changeColor = Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
	}
	*/
}
