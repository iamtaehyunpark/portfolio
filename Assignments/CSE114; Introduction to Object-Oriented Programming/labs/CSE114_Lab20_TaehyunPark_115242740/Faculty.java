public class Faculty extends Employee{
    private String department;
    private String faculty;
    private String rank;
    public Faculty(String name, int num, String email, int office, int salary, String department, String faculty, String rank){
        super(name, num, email, office, salary);
        this.department = department;
        this.faculty = faculty;
        this.rank = rank;
    }
    
    public String toString(){
        return  "," + department + "," + faculty + "," + rank;
    }

    }