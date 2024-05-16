package com.exterro.Loging_Project1.sample_prgm;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHanlding {

	public static void main(String[] args) {
		try {
			// creating a file
			File f0 = new File("C:\\Users\\nraman\\Desktop\\Flowers.txt");
			if (f0.createNewFile()) {
				System.out.println("File " + f0.getName() + " is created successfully.");

			} else {
				System.out.println("File is already exist in the directory.");
				System.out.println("hi" + f0.getAbsolutePath());
				f0.delete();
				System.out.println("success");
			}

			// writing a file
			FileWriter myWriter = new FileWriter("C:\\Users\\nraman\\Desktop\\Flowers.txt");
			myWriter.write("Rose,Jasmine,Marry gold,Sun flower, cauli flower");
			System.out.println("file written successfully");
			myWriter.append("daisy");
			myWriter.close();

			// reading a file
			FileReader fr = new FileReader("C:\\Users\\nraman\\Desktop\\Flowers.txt");
			int i;
			// Holds true till there is nothing to read
			while ((i = fr.read()) != -1)

				// Print all the content of a file
				System.out.print((char) i);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}