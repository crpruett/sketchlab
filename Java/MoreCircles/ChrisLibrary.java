import java.util.Scanner;

public class ChrisLibrary{    
  
  public static Comparable max (Comparable object1, Comparable object2){
      //If 'object1' is greater, return 'object2'.
      if (object1.compareTo(object2) > 0)
        return object1;
      //Else return 'object2'.
      else 
        return object2;
  }//End method max.
   
  public static void WildPrintArray(Comparable[] Sarray) {
    for (int i = 0; i < Sarray.length; i++) {
    System.out.println("Object[" + i + "]" + Sarray[i]);
    }
  }//End WildPrintArray method
  
  public static void WildGetArray(Comparable[] Garray) {
    Scanner get = new Scanner(System.in);
    for (int i = 0; i < Garray.length; i++) {
     System.out.println("Please enter the radius: ");
     //Circle A = new Circle(a);
     Garray[i] = new Circle(get.nextDouble());
    }
  }
  
  
}//End ChrisLibrary