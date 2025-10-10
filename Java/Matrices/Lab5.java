/* Chris Pruett
 * Lab 5
 * Description: This program uses two different algorithms to multiply matrices. (Markov Chains)
 */

import java.util.Scanner;

public class Lab5 {

	public static final int SIZE = 3;
	public static double[][] matrix = { { 0.9, 0.05, 0.05 },
			{ 0.05, 0.9, 0.05 }, { 0.05, 0.05, 0.9 } };
	public static double[][] tempmatrix = { { 0.9, 0.05, 0.05 },
			{ 0.05, 0.9, 0.05 }, { 0.05, 0.05, 0.9 } };
	public static double[][] m = new double[SIZE][SIZE];
	public static double[][] savestate = new double[SIZE][SIZE];

	// Algorithm1 has a O(N^3) time complexity which is a cubic algorithm.
	public static void Algorithm1() {

		for (int k = 1; k < 51; k++) {
			System.out.print("Q" + (k + 1) + " = ");
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					m[i][j] = 0;
					for (int z = 0; z < SIZE; z++) {
						m[i][j] += matrix[i][z] * tempmatrix[z][j];
					}

				}
			}
			if (k < 5 || k > 44) {
				output(m);
			}
			// Copy tempmatrix to m. Could use System.arraycopy();
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					tempmatrix[i][j] = m[i][j];
				}
			}
			System.out.println();
		}

	}

	public static void output(double[][] array) {
		System.out.println();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.printf("%1.4f ", array[i][j]);
			}
			System.out.println();
		}

	}

	// Algorithm2 has a O(N^3) time complexity which is a cubic algorithm.
	public static void Algorithm2() {
		for (int k = 0; k < 5; k++) {
			System.out.print("Q = ");
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					m[i][j] = 0;
					for (int z = 0; z < SIZE; z++) {
						if (k < 2) {
						m[i][j] += matrix[i][z] * tempmatrix[z][j];
						} else {
							m[i][j] += savestate[i][z] * tempmatrix[z][j];
						}
					}
				}
			}
			output(m);
			// Copy tempmatrix to m. Could use System.arraycopy();
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {

					if (k == 1) {
						savestate[i][j] = tempmatrix[i][j];
					}
					tempmatrix[i][j] = m[i][j];
					// Use another empty array to keep track of previous step
				}
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Press 1 for Algorithm1 and press 2 for Algorithm2: ");
		int choice = input.nextInt();
		if (choice == 1) {
			Algorithm1();
		} else {
			Algorithm2();
		}
	}
}
