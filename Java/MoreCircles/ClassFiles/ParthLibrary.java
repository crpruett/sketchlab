import java.util.Scanner;
import java.io.*;
  
public class ParthLibrary{
  /*
 public static int max(int num1, int num2){
  int result;
 
  if (num1 >num2)
   result = num1;
  else
   result = num2;
  return result;
  }//end max 
  */
@SuppressWarnings("unchecked") public static Comparable max(Comparable num1, Comparable num2){
 Comparable result;
 
  if (num1.compareTo(num2)>0)
   result = num1;
  else
   result = num2;
  return result;
  }//end max 

public static void print_array_of_objects(Comparable [] Sarray) {
  for (int i = 0; i < Sarray.length; i++) {
    System.out.println("Object[" + i + "]" + Sarray[i]);
  }//end for loop
}//end print array

public static void get_array_of_Circles(Comparable [] gArray) {
  Scanner get= new Scanner(System.in);
  for (int i = 0; i < gArray.length; i++){
    System.out.println("Please Enter a radius"); 
     //Circle A = new Circle(a);
    gArray[i] = new Circle (get.nextDouble());
   }//end for
}//end get array


public static int sum(int num1, int num2){
 int result;
 result = num1+num2;
 return result;
 }//end sum

public static float average (float num1, float num2){
 //pre condition num1 and num2 are not equal
 float result;// creating an object called result
 result=(num1+num2)/2;
 return result;
 }//end average

public static void swap ( int n1, int n2){
 System.out.println("\tInside the swap method");
 System.out.println("\t\tBefore swapping n1 is " + n1
  + " n2 is " + n2);

int temp = n1;
n1 = n2;
n2 = temp;

 System.out.println("\t\tAfter swapping n1 is " + n1
  + " n2 is " + n2);
 }//end swap

public static int GetArrayFromFile(double[] D) {
  Scanner fileInput;
  int i = 0;
  File inFile = new File("radius.numberdata");
  
  try {
    fileInput = new Scanner(inFile);
    while(fileInput.hasNext()){
    D[i] = fileInput.nextDouble();
    i++;
    }
    fileInput.close();
  }
  
  catch (FileNotFoundException e) {
   System.out.println(e);
  }
  return i;
}

public static void print_array_of_doubles(double[] D, int size){
  for (int i = 0; i < size; i++){
    System.out.println("Array element [" + i + "] = " + D[i]);
  }
}

public static void WriteArrayOfDoublesToFile(double[] C, int size) {
  try{
  PrintWriter output = new PrintWriter(new FileWriter("doit.write"));
  for (int i = 0; i < size; i++){
   output.println("Object [" + i + "] =" + C[i]);
  }
  output.close();
  }
  catch(IOException e){
    System.out.println(e);
  }
}

@SuppressWarnings("unchecked") public static int linearSearch(Comparable[] list, Comparable key){
  for (int i = 0; i < list.length; i++){
   // if(key == list[i])
    if (key.compareTo(list[i]) == 0)
      return i;
  }
  return -1;
}
}//end ParthLibrary