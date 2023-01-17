public class Employee extends Person{
    protected int office;
    protected int salary;

    public Employee(String name, int num, String email, int office, int salary){
        super(name, num, email);
        this.office = office;
        this.salary = salary;
    }
    
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public String toString() {
        return super.toString() + "," + salary;
    }

    }