package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {

		String inputPath = "C:\\Temp\\java.csv";

		Map<String,Integer> totalVotes = new LinkedHashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {

			String fileLine = br.readLine();

			while (fileLine != null) {

				String[] lineArray = new String [2]; 
				lineArray = fileLine.split(",", 2);
				
				// putIfAbsent returns "null" if the value doesn't exist and the current value when it does
				Integer currentValue = totalVotes.putIfAbsent(lineArray[0], Integer.parseInt(lineArray[1]));
				if (currentValue != null) {			
					totalVotes.replace(lineArray[0], currentValue + Integer.parseInt(lineArray[1]));
				}
				
				
				fileLine = br.readLine();
				
			}
			
			System.out.println("Alex Blue: " + totalVotes.get("Alex Blue"));
			System.out.println("Bob Brown: " + totalVotes.get("Bob Brown"));
			System.out.println("Maria Green: " + totalVotes.get("Maria Green"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
