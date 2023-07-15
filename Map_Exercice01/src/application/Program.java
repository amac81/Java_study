package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import entities.Candidat;


public class Program {
	public static void main(String[] args) 
	{

		String filePath = "c:\\temp\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			
			Map<String, Integer> votesMap = new HashMap<>(); // choose HashSet because it is fast and in this problem we don't need order
			List<Candidat> candidats = new ArrayList<> ();

			String fileLine = br.readLine();
			String [] fields;
			Integer nVotes = 0;
		
			//read from file to List;
			while (fileLine != null) {
				fields = fileLine.split(",");
				candidats.add(new Candidat(fields[0], Integer.parseInt(fields[1])));
				fileLine = br.readLine();
			}

			for(Candidat c: candidats) {
				votesMap.put(c.getName(), 0);
			}
			
			//sum number of votes by candidat
			for(Candidat c: candidats) {
				if(votesMap.containsKey(c.getName())) {
					nVotes = votesMap.get(c.getName());
					votesMap.put(c.getName(), c.getNumVotes() + nVotes);
				}
			}
			
			
			Map<String, Integer> sortedMap = votesMap.entrySet().stream()
                    .sorted(Entry.comparingByValue())
                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e2, e1) -> e1, LinkedHashMap::new));
			
			for(String s: sortedMap.keySet()) {
				System.out.printf("%s: %d%n", s ,sortedMap.get(s));
			}
			
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		
		
	}
}