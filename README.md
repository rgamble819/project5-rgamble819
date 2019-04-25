/**
	 * 
	 * @param stationsList
	 *            - Over-sized array of stations (Must be initialized by Estimated
	 *            Words Constant).
	 * @return int - The number of words in the over-sized array
	 * @throws IOException
	 *             - when Mesonet.txt does not exist
	 */
	public static int getMesonetStations(String[] stationsList)
	
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
	public static int calcDist(String StID, String toCompare)
  
  
  /**
	 * 
	 * @param dropMenu
	 *            updates the contents in the ComboBox
	 * @throws IOException
	 *             when Mesonet.txt does not exist
	 */
	public static void refreshMenu(JComboBox<String> dropMenu)
	
  /**
	 * Stores distance of all stations compared to STID in the array. Formatted
	 * [distance0, distance1, distnace2, distance3, distance4]
	 * 
	 * @return int[] returns integer array of differences in distance of all
	 *         stations including itself
	 * @throws IOException
	 */
	public static int[] calcDistanceArray(String STID)

	
