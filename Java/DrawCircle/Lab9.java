import java.util.Scanner;
public class Lab9 {
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
		if (A.compareTo(B) > 0)
		 System.out.println("Circle A is greater than Circle B");
		else if (A.compareTo(B) < 0)
		 System.out.println("Circle B is greater than Circle A");
		else 
		 System.out.println("Cirlce A and Cirlce B are the same");
	   
   }//close main
  
  
  
  
}//end Lab9