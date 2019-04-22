import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GHDFrame extends JFrame {
	private static final int FRAME_HEIGHT = 1000;
	private static final int FRAME_WIDTH = 500;
	protected static final int EST_NUM_OF_WORDS = 500;

	private GHDPanel containerPanel;

	protected JTextField sliderText;
	protected JSlider slider;

	protected JButton showStation;
	protected JScrollPane showStationPane;
	protected JTextArea showStationText;

	protected JComboBox<String> dropMenu;
	protected JButton calcHD;

	protected JTextField dist0;
	protected JTextField dist1;
	protected JTextField dist2;
	protected JTextField dist3;
	protected JTextField dist4;

	protected JButton addStation;
	protected JTextField addName;

	private final class GHDPanel extends JPanel {
		/**
		 * Paints the background
		 */
		public void paintComponent(Graphics g) {
			/* =================== Words On Pane =========== */
			g.drawString("Enter Hamming Distance: ", 50, 25);
			g.drawString("Compare with:", 50, 450);

			for (int dist = 0; dist <= 4; dist++) {
				g.drawString("Distance " + dist, 50, 550 + dist * 50);
			}
			/* ============================================== */
		}

		/**
		 * Adds components to the GUI
		 * 
		 * @throws IOException
		 */
		public GHDPanel() throws IOException {
			setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
			setLayout(null);

			/* =========Create All Components======== */
			sliderText = new JTextField(" 2\t");
			sliderText.setEditable(false);
			sliderText.setBounds(225, 10, 100, 25);

			slider = new JSlider(0, 4);
			slider.setBounds(100, 50, 250, 50);
			slider.setSnapToTicks(true);
			slider.setMajorTickSpacing(1);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);

			showStation = new JButton("Show Station");
			showStation.setBounds(150, 100, 150, 25);

			showStationText = new JTextArea("");
			showStationPane = new JScrollPane(showStationText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			// showStationPane.setLayout(null);
			showStationPane.setBounds(50, 150, 250, 250);
			showStationText.setBounds(5, 0, 250, 500);
			showStationPane.add(showStationText);
			showStationText.setEditable(false);
			showStationPane.setViewportView(showStationText);

			dropMenu = new JComboBox<>();

			// Add Stations to drop menu
			GHDUtilities.refreshMenu(dropMenu);

			dropMenu.setSelectedItem("NRMN");
			dropMenu.setEditable(false);
			dropMenu.setBounds(175, 435, 100, 25);

			calcHD = new JButton("Calculate HD");
			calcHD.setBounds(50, 485, 200, 25);

			dist0 = new JTextField();
			dist1 = new JTextField();
			dist2 = new JTextField();
			dist3 = new JTextField();
			dist4 = new JTextField();

			dist0.setEditable(false);
			dist1.setEditable(false);
			dist2.setEditable(false);
			dist3.setEditable(false);
			dist4.setEditable(false);

			dist0.setBounds(150, 535, 100, 25);
			dist1.setBounds(150, 585, 100, 25);
			dist2.setBounds(150, 635, 100, 25);
			dist3.setBounds(150, 685, 100, 25);
			dist4.setBounds(150, 735, 100, 25);

			addStation = new JButton("Add Station");
			addStation.setBounds(25, 785, 100, 25);

			addName = new JTextField("ZERO");
			addName.setBounds(150, 785, 100, 25);

			add(slider);
			add(sliderText);
			add(showStation);
			add(showStationPane);
			add(dropMenu);
			add(calcHD);
			add(dist0);
			add(dist1);
			add(dist2);
			add(dist3);
			add(dist4);
			add(addStation);
			add(addName);
			/* ================================== */
		}
	}

	/**
	 * Adds Listeners and sets up GUI
	 * 
	 * @throws IOException
	 */
	public GHDFrame() throws IOException {
		super("Hamming Distance");

		containerPanel = new GHDPanel();
		add(containerPanel);

		slider.addChangeListener(new GHDSliderListener(this));
		addStation.addActionListener(new GHDButtonListener(this));
		showStation.addActionListener(new GHDButtonListener(this));
		calcHD.addActionListener(new GHDButtonListener(this));

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		new GHDFrame();

	}
}
