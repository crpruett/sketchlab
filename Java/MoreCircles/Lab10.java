import java.util.Scanner;
public class Lab10 {
  public static void main(String[] args){
      Scanner get = new Scanner(System.in);
  System.out.print("Please enter the radius for Circle A: ");
  double a = get.nextDouble();
  System.out.print("Please enter the radius for Circle B: ");
  double b = get.nextDouble();
  
  Circle A = new Circle(a);
  Circle B = new Circle(b);
  System.out.println("Circle A: " + A);
  System.out.println("Circle B: " + B);
  
  //Declare an array of circles
  System.out.println("How many circles do you want?: ");
  int size = get.nextInt();
  Circle [] Carray = new Circle[size];
  
  if (A.compareTo(B) > 0)
   System.out.println("Circle A is greater than Circle B");
  else if (A.compareTo(B) < 0)
   System.out.println("Circle B is greater than Circle A");
  else 
   System.out.println("Circle A and Circle B are the same");
    
  ChrisLibrary.WildGetArray(Carray);
  ChrisLibrary.WildPrintArray(Carray);
   }//close main
  
  
  
  
}//end Lab9