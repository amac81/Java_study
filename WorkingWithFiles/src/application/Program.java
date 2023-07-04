package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * ### READ ###
 * 
 * FileReader (character reading stream from files)
 * BufferedReader (instantiated from FileReader and implements some optimizations, using memory buffering - faster)
 * 
 * ### WRITE ###
 * 
 * FileWriter (character writing stream to files)
 * BufferedWriter (instantiated from FileWriter and implements some optimizations, using memory buffering - faster)
 * 
 * 
 * */

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		// fileReadExample01();
		// fileReadExample02();
		// fileReadExample03();

		//fileWriteExample(true);
		
		
		folderListExample(strPath);
		
		System.out.println(".............................................................");
		
		fileListExample(strPath);
		
		System.out.println(".............................................................");
		
		boolean success = folderCreateExample(strPath, "subdir1");
		
		if(success) {
			System.out.println("Directory created sucessfully !");	
		}
		else {
			System.out.println("Directory not created");
		}
		
		sc.close();
	}

	
	public static boolean folderCreateExample(String strPath, String dirName) {
		return new File(strPath + "\\" + dirName).mkdir();
	}
	
	public static void fileListExample(String strPath) {
		File path = new File(strPath);
		File [] files = path.listFiles(File::isFile);
		System.out.println("FILES: ");
		for(File file: files) {
			System.out.println(file);
		}
	}

	
	public static void folderListExample(String strPath) {
		File path = new File(strPath);
		File [] folders = path.listFiles(File::isDirectory);
		System.out.println("FOLDERS: ");
		for(File folder: folders) {
			System.out.println(folder);
		}
	}
	
		
	public static void fileWriteExample(boolean append) {
		String filePath = "C:\\temp\\fileOut.txt";
		
		String[] linesToWrite = new String[] { "Lorem Ipsum is simply dummy text of the printing",
				"It was popularised in the 1960s", "Content here, content here" };
		
		/*
		 * FileWriter(String fileName, boolean append)
		 * Constructs a FileWriter object given a file name with a boolean indicating whether or not to append the data written.
		 */
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, append))) {

		for(String strLine: linesToWrite) {
			bw.write(strLine);
			bw.newLine();
		}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * With try-with-resources: Clean code; Better way!
	 */
	public static void fileReadExample03() {
		String filePath = "C:\\temp\\file1.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String fileLine = br.readLine();

			while (fileLine != null) {
				System.out.println(fileLine);
				fileLine = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public static void fileReadExample02() {
		String filePath = "C:\\temp\\file1.txt";
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

			String fileLine = br.readLine();

			while (fileLine != null) {
				System.out.println(fileLine);
				fileLine = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void fileReadExample01() {
		File file1 = new File("C:\\temp\\file1.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file1);

			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

}
