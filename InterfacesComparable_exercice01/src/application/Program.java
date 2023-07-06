package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.entities.Employee;


public class Program 
{
	public static void main(String[] args) 
	{
		Locale.setDefault(Locale.US);
		List <Employee> employees = new ArrayList<Employee>();	
		
		String filePath = "c:\\temp\\employees.txt";
	
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String fileLine = br.readLine();

			while (fileLine != null) {
				
				String [] lines = fileLine.split(",");
				
				Employee employee = new Employee(lines[0], Double.parseDouble(lines[1]));
				
				employees.add(employee);
				
				fileLine = br.readLine();
			}
			
			//Collections.sort(names);
			
			for(Employee e: employees) {
				System.out.println(e);
			}
			
			
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}
