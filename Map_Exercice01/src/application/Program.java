package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Program {
	public static void main(String[] args) {

		String filePath = "/tmp/in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			Map<String, Integer> votesMap = new LinkedHashMap<>();

			String fileLine = br.readLine();
			String[] fields;
			Integer nVotes = 0;
			String candidatName;

			// read from file to List;
			while (fileLine != null) {
				fields = fileLine.split(",");
				candidatName = fields[0];
				nVotes = Integer.parseInt(fields[1]);

				if (votesMap.containsKey(candidatName)) {
					votesMap.replace(candidatName, votesMap.get(candidatName) + nVotes);
				} else {
					votesMap.put(candidatName, nVotes);
				}

				fileLine = br.readLine();
			}

			for (String key : votesMap.keySet()) {
				System.out.println(key + ": " + votesMap.get(key));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}