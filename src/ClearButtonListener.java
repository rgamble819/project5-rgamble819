import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonListener implements ActionListener {

	private GHDDrawPanel ghdDrawPanel;
	
	/**
	 *  Constructs Clear button listener
	 * @param ghdDrawPanel
	 */
	public ClearButtonListener(GHDDrawPanel ghdDrawPanel) {
		this.ghdDrawPanel = ghdDrawPanel;
	}

	/**
	 * action of clear button activated
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ghdDrawPanel.clear();
	}
}
