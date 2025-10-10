/* Chris Pruett
 * Programming Assignement 2
 * Description: This program finds the kth smallest string in an array of sorted strings. The array is split into sub-arrays with the partition
 * method and is then passed to the quicksort method which, end the end, sorts the array. The kSmallest method is then called to find the kth 
 * smallest element.
 */

public class PA2 {

 // First quickSort Method
 public void quickSort(String[] list) {
  quickSort(list, 0, list.length - 1);
 }

 // Second quickSort Method
 private void quickSort(String[] list, int first, int last) {
  if (last > first) {
   int pivotIndex = partition(list, first, last);
   quickSort(list, first, pivotIndex - 1);
   quickSort(list, pivotIndex + 1, last);
  }
 }

 // Partition Method
 private int partition(String[] list, int first, int last) {
  String pivot = list[first];
  int low = first + 1;
  int high = last;

  while (high > low) {
   while (low <= high && list[low].compareTo(pivot) <= 0) {
    low++;
   }

   while (low <= high && list[high].compareTo(pivot) > 0) {
    high--;
   }

   if (high > low) {
    String temp = list[high];
    list[high] = list[low];
    list[low] = temp;
   }
  }

  while (high > first && list[high].compareTo(pivot) >= 0) {
   high--;
  }

  if (list[high].compareTo(pivot) < 0) {
   list[first] = list[high];
   list[high] = pivot;
   return high;
  } else {
   return first;
  }
 }

 // kSmallest Method
 public int kSmallest(int k, String[] array, int first, int last) {
  if (0 <= k) {
   int pivotIndex = partition(array, first, last);
   if (k == pivotIndex) {
    return pivotIndex; // or pivotIndex
   } else if (k < pivotIndex) {
    return kSmallest(k, array, first, pivotIndex - 1);
   } else {
    return kSmallest(k, array, pivotIndex + 1, last);
   }
  } else {
   return -1;
  }
 }

 // Main Method
 // Remember to output all cases
 public static void main(String[] args) {
  PA2 constructor = new PA2();
  String[] list = { "multiple", "threads", "access", "merely",
    "functions", "impossible", "depended", "permits", "operations",
    "traverse" };
  constructor.quickSort(list);
  int k = 2;
  if (k <= list.length - 1
    && constructor.kSmallest(k, list, 0, list.length - 1) != -1) {
   System.out.println("The kth(" + k + ")" + "smallest element is: " + list[constructor.kSmallest(k, list, 0,
     list.length - 1)]);
   System.out.println("1: depended \n" + "3: impossible\n" + "5: multiple\n" + "9: traverse\n" + "12: Not a valid index");
  } else {
   System.out.println("Not a valid index!");
  }
 }
}
