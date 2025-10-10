/* Chris Pruett
 * Programming Assignement 4
 * 4/12/11
 */

import java.io.*;
import java.util.Scanner;
import java.lang.Character;

public class Parser {

	public static Scanner inputStream = new Scanner(System.in);

	public static void main(String args[]) {
		// Declare and populate the array of MyLinkedLists
		MyLinkedList<String>[] dictionary = (MyLinkedList<String>[]) new MyLinkedList[26];
		for (int i = 0; i < 26; i++) {
			dictionary[i] = new MyLinkedList<String>();
		}

		// Variables
		double wordsFound = 0;
		double wordsNotFound = 0;
		double compsFound = 0;
		double compsNotFound = 0;

		try {

			// More Variables
			char let;
			String str = "";
			int n = 0;
			int j = 0;

			// While loop for prompting the user for the dictionary and the file
			// to compare
			while (j < 2) {
				// Ask the user for the filename
				System.out.print("Enter the file name to be read: ");
				String fileName = inputStream.next();
				FileInputStream inf = new FileInputStream(new File(fileName));

				// While there are things to be read
				while ((n = inf.read()) != -1) {
					let = (char) n;

					if (Character.isLetter(let)) {
						str += Character.toLowerCase(let);
					}

					if ((Character.isWhitespace(let) || let == '-')
							&& !str.isEmpty()) {
						// If use user inputs the dictionary, add the elements
						// to the MyLinkedList array
						if (fileName.equals("random_dictionary.txt")) {
							dictionary[((int) str.charAt(0)) - 97].add(str);
							str = "";
						}

						// If user inputs oliver, compare the dictionary with
						// that file.
						if (fileName.equals("oliver.txt")) {
							if (dictionary[((int) str.charAt(0)) - 97]
									.contains(str)) {
								wordsFound++;
								compsFound += dictionary[((int) str.charAt(0)) - 97]
										.getCount();

							} else {
								wordsNotFound++;
								compsNotFound += dictionary[((int) str
										.charAt(0)) - 97].getCount();

							} // End Else
							str = "";
						} // End If

					} // End If
				} // End While
				inf.close();
				j++;
			} // End While

		} catch (IOException e) {
			e.printStackTrace();
		} // End Catch

		/*
		 * System.out.println("Words found: " + wordsFound);
		 * System.out.println("Words not found: " + wordsNotFound); double
		 * compAvg = (compsFound / wordsFound);
		 * System.out.println("Average for words found: " + compAvg); double
		 * newavg = (compsNotFound / wordsNotFound);
		 * System.out.println("Average for words not found " + newavg);
		 */

	}

}

/*
 * Words found: 939674.0 Words not found: 52466.0 Average for words found:
 * 3500.9218324653016 Average for words not found 7401.696412915031
 */