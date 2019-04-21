import java.io.IOException;

import javax.swing.JComboBox;

public class GHDUtilities {

	public static int getMesonetStations(String[] stationsList) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int calcDist(String stID, String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void refreshMenu(JComboBox<String> dropMenu) throws IOException {

		// TODO: Only show duplicates once
		// TODO: Put in Alphabetical Order.

		// Get the list of words from file
		String[] stidlist = new String[GHDFrame.EST_NUM_OF_WORDS];
		int words = GHDUtilities.getMesonetStations(stidlist);

		// Add the list of words to the menu
		for (int index = 0; index < words; index++) {
			dropMenu.addItem(stidlist[index]);
		}
	}

	public static int[] calcDistanceArray(String STID) throws IOException {
		int[] distanceArray = new int[5];
		String[] array = new String[GHDFrame.EST_NUM_OF_WORDS];
		int wordCount = getMesonetStations(array);

		int hDist = 0;
		for (int index = 0; index < wordCount; index++) {
			hDist = new Integer(calcDist(STID, array[index]));
			if (hDist == 0) {
				distanceArray[0] = distanceArray[0] + 1;
			} else if (hDist == 1) {
				distanceArray[1] = distanceArray[1] + 1;
			} else if (hDist == 2) {
				distanceArray[2] = distanceArray[2] + 1;
			} else if (hDist == 3) {
				distanceArray[3] = distanceArray[3] + 1;
				;
			} else if (hDist == 4) {
				distanceArray[4] = distanceArray[4] + 1;
				;
			}
		}
		return distanceArray;
	}
}
