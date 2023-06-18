package application;

import java.util.Locale;
import java.util.Scanner;

import entities.StudentGuest;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		// vector with 10 positions
		StudentGuest[] vStudentsGuests = new StudentGuest[10];

		System.out.print("How many rooms to rent ? ");
		int nOfRents = sc.nextInt();
		sc.nextLine();//clear buffer

		String studentName = null;
		String studentEmail = null;
		int roomNumber;

		for (int i = 0; i < nOfRents; i++) {
			System.out.printf("RENT #%d: ", i + 1);
			
			System.out.printf("%nName: ", i + 1);
			studentName = sc.nextLine();

			System.out.printf("Email: ", i + 1);
			studentEmail = sc.nextLine();

			do {
				System.out.printf("Room number [1 .. 10] :");
				roomNumber = sc.nextInt();
				sc.nextLine();//clear buffer
				
				if((roomNumber < 1) || (roomNumber > 10)) {
					System.out.println("\nChoose a room number between 1 and 10!");
				}
				
			} while ((roomNumber < 1) || (roomNumber > 10));

			roomNumber --; //to adjust to vector positions [0..9] 
			
			vStudentsGuests[roomNumber] = new StudentGuest(studentName, studentEmail);

		}

		System.out.println("\nBusy Rooms:");
		
		for (int i = 0; i < 10; i++) {
			if(vStudentsGuests[i] != null)
				System.out.printf("%d: %s %n", i + 1, vStudentsGuests[i]);
		}

		sc.close();
	}

}
