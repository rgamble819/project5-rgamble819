import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;

public class GHDButtonListener implements ActionListener {

	private GHDFrame ghd;

	/**
	 * 
	 * @param GHDFrame
	 *            ghdFrame - The frame the listener corresponds to.
	 */
	public GHDButtonListener(GHDFrame ghdFrame) {
		ghd = ghdFrame;
	}

	/**
	 * Performs actions based on what button is pressed on the menu.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() instanceof JButton) {
				JButton jb = (JButton) e.getSource();
				if (jb.getText().equals("Show Station")) {
					String[] stationsList = new String[GHDFrame.EST_NUM_OF_WORDS];
					int wordCount = GHDUtilities.getMesonetStations(stationsList);

					ArrayList<String> equalDist = new ArrayList<>();
					String StID = (String) ghd.dropMenu.getSelectedItem();
					int distance = ghd.slider.getValue();

					for (int index = 0; index < wordCount; index++) {
						if (GHDUtilities.calcDist(StID, stationsList[index]) == distance) {
							equalDist.add(stationsList[index]);
						}
					}

					ghd.showStationText.setText("");
					for (String equals : equalDist) {
						ghd.showStationText.setText(ghd.showStationText.getText() + "\n" + equals);
					}
				} else if (jb.getText().equalsIgnoreCase("Calculate HD")) {
					int[] dist = GHDUtilities.calcDistanceArray((String) ghd.dropMenu.getSelectedItem());
					ghd.dist0.setText(" " + dist[0]);
					ghd.dist1.setText(" " + dist[1]);
					ghd.dist2.setText(" " + dist[2]);
					ghd.dist3.setText(" " + dist[3]);
					ghd.dist4.setText(" " + dist[4]);
					ghd.showStationText.setText("");
				} else if (jb.getText().equals("Add Station")) {

					String stationToAdd = ghd.addName.getText();
					PrintWriter pw;

					try {
						pw = new PrintWriter(new FileWriter("Mesonet.txt", true));

						pw.println(stationToAdd);
						pw.close();

					} catch (IOException e1) {
						System.out.println(e1.getMessage());
					}

					GHDUtilities.refreshMenu(ghd.dropMenu);
					ghd.showStationText.setText("");
				}
			}
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}
}
