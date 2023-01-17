

public class UseStudent {

	public static void main(String[] args) {
	    Student[] theStudents = new Student[10];

	    theStudents[0] = new Student("Jessica Jones", "TSM", 654321, 2.9, 2024);
	    theStudents[1] = new Student("Yong", "TSM", 123457, 3.2, 2024);
	    theStudents[2] = new Student("Moe", "BA", 123458, 2.9, 2023);
	    theStudents[3] = new Student("Larry", "ME", 123459, 3.3, 2023);
	    theStudents[4] = new Student("Curly", "AMS", 123460, 2.7, 2023);
	    theStudents[5] = new Student("Nicholas Cage", "BA", 123461, 3.1, 2024);
	    theStudents[6] = new Student("Billy Joel", "CS", 123463, 3.2, 2025);
	    theStudents[7] = new Student("Ron Stoppable", "CS", 123464, 2.9, 2023);
	    theStudents[8] = new Student("Jim Bob", "BA", 123465, 2.95, 2025);
	    theStudents[9] = new Student("Jim Bob", "AMS", 123466, 3.3, 2024);

	    System.out.println("Students: ");

	    for (int i = 0; i < theStudents.length; i++) {
		System.out.println(theStudents[i]);
	    }
	    
	    Selection.selectionSort(theStudents);

	    for (int i = 0; i < theStudents.length; i++) {
		System.out.println(theStudents[i]);
	    }


	}
}
