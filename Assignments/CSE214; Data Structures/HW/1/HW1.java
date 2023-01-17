/**
 * Name: Taehyun Park
 * SBU ID: 115242740
 * Do not use any external packages other than the ones provided below!
*/
import java.io.BufferedReader;
import java.io.FileReader;

public class HW1 {
	private Student[] rawData;
	
	/* 
	 * This is the maximum possible # of elements. 
	 * There should never be more than this many students in the record.
	 * TODO: You MUST observe this limit.
	 */
	public static final int MAX_LEN = 20;

	
	/* 
	 * You may add any variables that you find necessary, but add only what you need. 
	 */
	public HW1(String filePath) {
		rawData = new Student[MAX_LEN];
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = br.readLine()) != null) //Stop if last index meets the MAX
				{
				String[] tokens = line.split("\\s");
				// 'tokens' is now an array of Strings.
				// TODO: use the values in 'tokens' to populate rawData

				//Array 'tokens' to 'rawData'. Each index will represent Name, Major,Id
				Student temp = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
				addStudent(temp);
			}
			br.close();
		} catch(Exception e) {
			System.err.println("File error: " + e.getMessage());
			System.exit(-1);
		}
	}

	// TODO: Implement the following empty methods.
	/**
	 * Insert a student from the record. 
	 * If the array is already full or if a record already exists, insertion fails. 
	 * @param s Student instance
	 * @return true if addition is successful, false otherwise.
	 * TODO: Don't allow duplicates
	 */
	public boolean addStudent(Student s) {
		if(find(s) == null){
			for(int i=0;i< rawData.length;i++){
				if(rawData[i] == null){ //fill in the first index that is empty
					rawData[i] = s;
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 * Remove a student from the record if the record exists. 
	 * @param s Student instance
	 * @return true if deletion is successful, false otherwise
	 */	
	public boolean removeStudent(Student s) {
		for(int i =0;i< rawData.length;i++){
			if (s.equals(rawData[i])) { //find s in array and if checked, delete
				rawData[i] = null;
				return true;
			}
		}		return false;
	}
	
	/**
	 * For a match, all fields must be equal. i.e., same name, same id, same major.
	 * @param s Student class
	 * @return A student in rawData that matches s or a null otherwise.
	 */
	public Student find(Student s) {
		for(Student k:rawData){
			if(k!=null) {  //To prevent comparing with null index
				if (s.equals(k)) return k;
			}
		}
		return null;
	}

	/**
	 * Return a Student instance that has the first matching ID.
	 * @param s Student class
	 * @return A student in rawData that matches id or a null otherwise.
	 */
	public Student findByID(int id) {
		for(int i =0;i< rawData.length;i++){
			if (id == rawData[i].getId()) {
				return rawData[i];
			}
		}
		return null;
	}
	
	/**
	 * Return a Student instance that has the first matching major.
	 * @param s Student class
	 * @return A student in rawData that matches major or a null otherwise.
	 */
	public Student findByMajor(String major) {
		for(int i =0;i< rawData.length;i++){
			if (major.equals(rawData[i].getMajor())) {
				return rawData[i];
			}
		}
		return null;
	}
	
	/**
	 * Return the total number of students currently stored in the DB.
	 * @return The number of records stored.
	 */
	public int len() {
		int count=0;
		for(Student s:rawData){
			if(s==null) continue; //Does not count Index that is empty
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		//HW1 hw = new HW1(args[1]);
		HW1 hw = new HW1("db.txt");
		HW1Test test = new HW1Test(hw);
		// This is where you can add codes to test your implementation.
		// e.g., try 'hw.findByID(...)' or build your own Student instance to try 'hw.find(...)'.
		test.Test();
		hw.removeStudent(hw.rawData[4]);
		hw.addStudent(new Student("Taehyun","CSE",115242740));
		if(hw.findByID(115242740).equals(hw.findByMajor("CSE"))) {
			System.out.println(hw.len());;
			System.out.println(hw.rawData[MAX_LEN-1].getName());
		}else {
			System.out.println("OMG");
		}

	}
}

class Student {
	private String name;
	private String major;
	private int id;
	
	// TODO: Add whatever method you think is necessary. 
	// In particular, you must override the .equals(...) method and make use of it.   
	public Student(String name, String major, int id) {
		this.name = name;
		this.major = major;
		this.id = id;
	}

	public String getName(){
		return this.name;
	}
	public String getMajor(){
		return this.major;
	}
	public int getId(){
		return this.id;
	}

	public boolean equals(Student s){
		if(this==null) return false;
		if (s.getId() == this.getId()
				&& s.getName().equals(this.getName())
				&& s.getMajor().equals(this.getMajor())) {
					return true; //return true if all the values are same
			}
		return false;
	}
		
}