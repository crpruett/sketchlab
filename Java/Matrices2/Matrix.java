/* Chris Pruett
 * Lab 1
 * This program generates two 3 x 3 2D arrays. Matrix1 get's it's values from integerdata.txt and Matrix2 get't it's values from Math.random().
 * Both of these 2d arrays are then multiplied to get the values from Matrix3. Matrix 3 is then printed to matrixoutput.txt.
 */

import java.util.Scanner;
import java.io.*;

public class Matrix {
    public static final int size = 3;
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] matrix3;
    Scanner input;
    
/* This(Matrix Constructor) method below initializes matrix1-3 with integer data using Scanner.
 * Also generates a random integer between 1 and 5. 
 */
    public Matrix(){
        matrix1 = new int[size][size];
        matrix2 = new int[size][size];
        matrix3 = new int[size][size];
        
        
    
        ReadFile();
        for(int i = 0; i < size; i++)
            for( int j = 0; j < size; j++){
                matrix2[i][j] = (int) (Math.random() * 5);


        }// end for...
    } // end constructor
  
    // The ReadFile method reads the data from integerdata.txt and inputs it into Matrix1.
    public void ReadFile() {
    
        File file = new File("integerdata.txt");
        Scanner infile;
        try {
            infile = new Scanner(file);
            int i = 0;
            while ( infile.hasNext() && i < matrix1.length){
                int j = 0;
                while (infile.hasNext() && j < matrix1[i].length) {
                     matrix1[i][j] = infile.nextInt();
                    j++;
              }
               i++;
            }
            infile.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
      }
    
    
    
    /* This(Multiply) method gets the product of matrix1 and matrix2 and stores it
 * into matrix3.
 */
    public void Multiply(){
        for (int i = 0; i < matrix1.length; i++)
            for (int j = 0; j < matrix2[0].length; j++){
                matrix3[i][j] = 0;
                for (int k = 0; k < matrix1[0].length; k++)
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
            }
    }
/* This(Output) method creates a text file named "matrixoutput.txt" and prints
 * matrix3 to it. It throws out any exception unless the file already exists. If the file
 * already exists it says "File already exists". Also aligns the output.
 */
    public void Output() throws Exception {
        java.io.File file = new java.io.File("matrixoutput.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                output.printf("%6d", matrix3[i][j]);
            }// End for
            output.println();
        }//End for
        output.close();
    }//End output method
}
