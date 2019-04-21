import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JComboBox;

public class GHDUtilities {

	/**
	 * 
	 * @param stationsList
	 *            - Over-sized array of stations (Must be initialized by Estimated
	 *            Words Constant).
	 * @return int - The number of words in the over-sized array
	 * @throws IOException
	 *             - when Mesonet.txt does not exist
	 */
	public static int getMesonetStations(String[] stationsList) throws IOException {
		// wordCount keeps track of how many words are added to the over-sized array
		int wordCount = 0;

		// Read the file and add the station IDs to the array
		BufferedReader fr = new BufferedReader(new FileReader("Mesonet.txt"));
		String line = fr.readLine();

		while (line != null) {
			stationsList[wordCount] = line;
			line = fr.readLine();
			wordCount++;
		}
		fr.close();

		// returns the length of the over-sized array
		return wordCount;
	}
	/**
	 * Returns the Hamming Distance between two station IDs.
	 * 
	 * @param StID
	 *            - String ID of the station
	 * @param toCompare
	 *            - String ID of the station to compare against
	 * @return int - The Hamming Distance between the two station IDs
	 * @throws IOException
	 *             when Mesonet.txt does not exist
	 */
	public static int calcDist(String StID, String toCompare) throws IOException {
		int dist = 0;
		for (int wordIndex = 0; wordIndex < StID.length(); wordIndex++) {
			if (StID.toUpperCase().charAt(wordIndex) != toCompare.toUpperCase().charAt(wordIndex)) {
				dist++;
			}
		}
		return dist;
	}
	
	/**
	 * 
	 * @param dropMenu
	 *            updates the contents in the ComboBox
	 * @throws IOException
	 *             when Mesonet.txt does not exist
	 */
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

	/**
	 * Stores distance of all stations compared to STID in the array. Formatted
	 * [distance0, distance1, distnace2, distance3, distance4]
	 * 
	 * @return int[] returns integer array of differences in distance of all
	 *         stations including itself
	 * @throws IOException
	 */
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
