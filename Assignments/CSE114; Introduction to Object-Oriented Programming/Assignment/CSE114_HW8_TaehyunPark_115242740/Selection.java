public class Selection {

    // This method is declared to be public since the designer of this
    // class intented that selectionSort will be available outside this class.
    // That is, selectionSort can be called from a method in a different class.
    public static void selectionSort (Student[] a) {
      System.out.println("\nSelection sort:");

      // A simpler version
      for (int i = 0; i < a.length; i++) {
        // find the smallest and swap
        for (int j = i + 1; j < a.length; j++) {
	    if (a[j].compareTo(a[i]) < 0) {
		swap(a, i, j);
          }
        }
      }
    }

    // This method is declared to be private since it is intended to be
    // used only inside this class.  In fact, it is being used by selectionSort
    // which itself is a public method, which is okay.  The only imposed
    // meaning for private is that it is not visible outside this class.
    // Any method inside this class can call this.
    private static void swap(Student x[], int i, int j) {
	Student temp = x[i];
	x[i] = x[j];
	x[j] = temp;
    }

    // Run this program like this:
    //
    //    prompt> java Selection 20
    //
    public static void main (String[] args) {

	Student[] sdnts = new Student[18];
	
	// Build array
	sdnts[0] = new Student("John Smith", "CS", 12345, 2.7,2023);
	sdnts[1] = new Student("Joe Cool", "TSM", 12346, 3.5,2023);
	sdnts[2] = new Student("Doris Day", "FIT", 12349, 3.7,2024);
	sdnts[3] = new Student("Chuck Norris", "CS", 12331, 3.25,2022);
	sdnts[4] = new Student("Amy Irving", "AMS", 12358, 1.2,2024);
	sdnts[5] = new Student("Mimi Rogers", "AMS", 12322, 1.3,2026);
	sdnts[6] = new Student("Bob Newhart", "CS", 12333, 2.9,2027);
	sdnts[7] = new Student("Rosario Dawson", "CS", 12405, 4.0,2024);
	sdnts[8] = new Student("Max Von Sydow", "AMS", 12408, 3.9,2023);
	sdnts[9] = new Student("Terrence Stamp", "AMS", 12301, 2.9,2024);
	sdnts[10] = new Student("Gates McFadden", "BM", 12302, 2.71,2022);
	sdnts[11] = new Student("Guy Williams", "TSM", 12399, 3.1,2025);
	sdnts[12] = new Student("Doris Day", "FIT", 12400, 1.97,2024);
	sdnts[13] = new Student("Chuck Norris", "CS", 12444, 2.72,2023);
	sdnts[14] = new Student("Bruce Willis", "BM", 12191, 2.78,2023);
	sdnts[15] = new Student("Jerry O'Donnel", "AMS", 12302, 1.38,2025);
	sdnts[16] = new Student("William Shatner", "BM", 12303, 2.95,2024);
	sdnts[17] = new Student("Leonard Nimoy", "CS", 12415, 4.1,2024);
	
	


	// Print array
	ArrayTools.printArray(sdnts, "\n\nBefore sorted:");

	long startSortTime = System.currentTimeMillis();
	selectionSort(sdnts);  // selection sort
	// isort(ints);        // insertion sort
        // java.util.Arrays.sort(ints);  // quick sort
	System.out.println("\n\nSorting Time: "
			   + (System.currentTimeMillis()
			      - startSortTime)
			   + " milliseconds");
	ArrayTools.printArray(sdnts, "\nAfter sorted:");

    }

}

/* Note that I am using printArray method defined in ArrayTools class
   like this: ArrayTools.printArray(...).

   This is analogous to using Math.sin(...).

   Note that I used 'private' in front of swap because I wanted to limit
   accesses to swap only to the methods in this class.  That is, if you
   try Selection.swap(...) from another class, it will be illegal, i.e.,
   Java compiler will complain.

   However, Selection.selectionSort(...) would be legal from another class as
   we will see from Search.java a little later because selectionSort is declared
   to be public.

   I will say more about public and private later, but this much should
   be understandable for now.
*/


/* Note that when you put multiple class definitions in a single file,
   the name of one of the classes must match the name of the file that
   contains the classes.  That one class must have the keyword 'public'
   in the line the class is defined, e.g., Selection has 'public'.
   All the other classes will NOT have the keyword 'public', e.g.,
   ArrayTools class definition does not start with the keyword 'public'.
 */
 class ArrayTools {

   // Returns an array of n random integers.  The integers are
   // chosen from the interval [0..range)
   public static int[] randomArray (int size, int range) {
     int[] a = new int[size];
     java.util.Random r = new java.util.Random();
     for (int i = 0; i < a.length; i++) {
       a[i] = r.nextInt(range);
     }
     return a;
   }

   public static void printArray(Student[] a, String msg) {
     System.out.println(msg);
     for (int i = 0; i < a.length; i++) {
       System.out.println(a[i] + " ");
     }
     System.out.println();
     System.out.println();
     System.out.println();
   }

 }
