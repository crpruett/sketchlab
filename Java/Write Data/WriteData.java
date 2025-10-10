import java.io.*;

public class WriteData{
  
 public static int Sum = 0;
 public static int Row = 0;
 
 public WriteData(){

   
 }

 public static void arraySum(double[][] tda){ //zsco is a reference to zArray in main

  File file = new File("write.rtf"); // create a new file

  /* Uncomment this once you are done testing, this restricts rewriting to file.
  if (file.exists()){
   System.out.println("file already exist");
   System.exit(0);
  }
  */
  try{
   PrintWriter output = new PrintWriter(file); // open file
   for (int i =0; i< tda.length; i++){
     output.print("Row: ");
     for(int j =0; j < tda[i].length; j++) {
     output.printf("%1.0f,", tda[i][j]);//precision
     Sum += tda[i][j];
     
     }
     output.print(": Sum is " + Sum);
     Sum = 0;
     output.println();
   }
   output.close();
  }
  catch (FileNotFoundException e){

   System.out.println(e);
  }
 }

 public static void main (String[] args){

  // arrays can be initialized using an initializer list.
  double zArray[][] = {{2,4,9,16},{1,3,5,7,9},{1,1,2,3,5},{1,2,4,8,16,32}};
  for(int i = 0; i < zArray.length; i++) {
    //System.out.print("Row " + (Row+=1) + ": ");
    System.out.print("Row: " + "[");
    for(int j = 0; j < zArray[i].length; j++) {
  System.out.print(zArray[i][j] + ",");
  
  arraySum(zArray); // invoke the method and pass the array
    }
    System.out.println("]");
  }
 }
}
// Questions: Why did he put java.io.~~~ for everything?