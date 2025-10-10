public class Circle implements Comparable {
  //data numbers
  private double radius = 1.0;
  //operations on data-tasks are methods
  
  private static int numberOfCircles = 0;
  public Circle(){//default constructor
   numberOfCircles++; 
  }
  //construct a circle object
  public Circle(double r) {//constructor with parameters
    radius = r;
     numberOfCircles++; 
    }//end Circle
  public Circle(Circle C){//the copy constructor
    radius = C.radius;
     numberOfCircles++; 
  }
  //accessor methods
  public double get_radius(){
   return radius; 
  }//end get_radius
  public static int number_of_circles(){
   return numberOfCircles; 
  }
  //Mutator methods
  public void change_radius(double newRadius){
    radius = newRadius;
  }
  /* ("%15s%10.2f\n",  "* radius = " , radius, 
          "%15s%10.2f\n",  "* diamter = " , diameter(),
          "%15s%10.2f\n",  "* circumference = " , circumference(),
          "%15s%10.2f\n",  "* area = " , area(),
           "************************************" );
   * 
   */
  public String toString(){
    return ("*\n\t radius = " + radius + 
            "*\n\t diamter = " + diameter()+
            "*\n\t circumference = " + circumference()+
            "*\n\t area = " + area()+
            "*\n\t ************************************" );
    
  }//end toString
  public double diameter(){
    return 2*radius;
  }
  public double circumference(){
   return 2*Math.PI*radius; 
  }
  public double area(){
   return Math.PI*Math.pow(radius,2); 
  }
  
  public int compareTo(Object o) {
    
   if (radius > (((Circle)o).radius))
     return 1;
   else if (radius < (((Circle)o).radius))
     return -1;
   else 
     return 0;
  }
    
    }//end class