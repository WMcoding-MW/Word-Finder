
/**
 * William Marks
 * March 26, 2020
 * The goal of this program is to be able to take user input for a certain word, and with
 * the data from a text file, search that text file and see if the word exists anywhere, if it does
 * print out the whole line.
 */

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordFinder {

	public static void main(String[] args) throws FileNotFoundException {
		// declaring variables
		Scanner input = new Scanner(System.in);
		String WORD = null;
		System.out.print("What is the word you're searching for?: ");
		if (input.hasNext()) {
			WORD = input.nextLine();
		}
		
		int lineNum = 0;

		int Quit = 0;
		String fileName = null;

		do {

			System.out.print("Please enter a file name you'd like to search: "); //requesting the file to search
			if (input.hasNext()) {
				fileName = input.next();
			}
			
			try {
				FileInputStream InputFile = new FileInputStream(fileName); //tries to see if it can find the file
				try {
					Scanner in = new Scanner(InputFile); //if found it tries to generate a scanner with it

					while (in.hasNextLine()) { //loops through the .txt file until it's done every line
						String word = in.nextLine();
						lineNum++;
						if (word.contains(WORD)) { //if the word is found in the line, it prints out that line
							System.out.println("File " + fileName + " & line number " + lineNum + ": " + word);
						}
					}
					in.close();
				} catch (NoSuchElementException e) {
				}
			} catch (FileNotFoundException e) {
				System.out.println("Error: File could not be found.");

			}

			System.out.print("Would you like to search another file (1 for yes, 0 for no) : ");
			if (input.hasNextInt()) {    //asks the user if they would like to search another file for the word.
				Quit = input.nextInt(); 
				lineNum = 0;
				if (Quit == 0 || Quit == 1) {

				} else {
					System.out.println("Error: Invalid input for again.");
				}
			} else {
				System.out.println("Error: invalid input for again.");
			}
		} while (Quit != 0);

	}

}
