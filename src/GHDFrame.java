import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GHDFrame {
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
}
