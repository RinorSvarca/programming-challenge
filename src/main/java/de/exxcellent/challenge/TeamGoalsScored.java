package de.exxcellent.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamGoalsScored {

	public TeamGoalsScored() {

		String filename = "src/main/resources/de/exxcellent/challenge/football.csv";
		File file = new File(filename);

		ArrayList<String> myArrayList = new ArrayList<String>();

		int smallestAbsoluteDifference = Integer.MAX_VALUE;
		String teamWithSmallestAbsDifference = "";

		Scanner scanner;
		try {
			scanner = new Scanner(file);
			scanner.nextLine();
			while (scanner.hasNextLine()) {

				myArrayList.add(scanner.nextLine());

				for (int i = 1; i < myArrayList.size(); i++) {

					String[] parts = myArrayList.get(i).split(",");

					String team = parts[0];

					int goals = Integer.parseInt(parts[4]);
					int goalsAllowed = Integer.parseInt(parts[5]);

					int diff = Math.abs(goals - goalsAllowed);

					if (diff < smallestAbsoluteDifference) {
						smallestAbsoluteDifference = diff;
						teamWithSmallestAbsDifference = team;
					}

				}
			}
			scanner.close();
			System.out.println(teamWithSmallestAbsDifference
					+ " has the smallest absolute difference in goals. Difference is: " + smallestAbsoluteDifference);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
