public class Student extends Person {
    private String classYear;
    private String major;
    
    public Student (String name, int num, String email, String classYear, String major){
        super(name, num, email);
        this.classYear = classYear;
        this.major = major;
    }
    
    
    
    
    
    public String toString() {
        return super.toString() + "," + classYear + "," + major;
    }
}