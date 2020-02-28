package de.exxcellent.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WeatherCalculation {
	
	public WeatherCalculation() {
		

		String filename = "src/main/resources/de/exxcellent/challenge/weather.csv";
		File file = new File(filename);
		
		ArrayList<String> myArrayList = new ArrayList<String>();
		
		int smallestDifference = Integer.MAX_VALUE;
		int dayWithSmallestDifference = -1;

		Scanner scanner;
		try {
			scanner = new Scanner(file);
			scanner.nextLine();
			while (scanner.hasNextLine()) {

				myArrayList.add(scanner.nextLine());

				for (int i = 1; i < myArrayList.size(); i++) {

					String[] parts = myArrayList.get(i).split(",");

					int day = Integer.parseInt(parts[0]);

					int mxt = Integer.parseInt(parts[1]);
					int mnt = Integer.parseInt(parts[2]);

					int diff = Math.abs(mxt - mnt);

					if (diff < smallestDifference) {
						smallestDifference = diff;
						dayWithSmallestDifference = day;
					}

				}
			}
			scanner.close();
			System.out.println("Day "+ dayWithSmallestDifference + " has the smallest temperature spread. Difference is: " + smallestDifference );

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
