package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import entities.LogEntry;

public class Program {
	public static void main(String[] args) 
	{
		//DateTimeFormatter dateTimeFormat1 = DateTimeFormatter.ISO_INSTANT;
		String filePath = "/tmp/log.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			Set<LogEntry> set = new HashSet<>(); // choose HashSet because it is fast and in this problem we don't need order

			String fileLine = br.readLine();
			String [] fields;
		
			while (fileLine != null) {
				fields = fileLine.split(" ");
				
				LogEntry logEntry = new LogEntry(fields[0], Instant.parse(fields[1]));
				
				set.add(logEntry);
				
				fileLine = br.readLine();
			}
			
			System.out.print("Total unique users: " + set.size());
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		
		
	}
}
