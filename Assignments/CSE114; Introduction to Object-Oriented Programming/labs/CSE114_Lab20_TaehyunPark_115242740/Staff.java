public class Staff extends Employee{
    private String role;
    public Staff(String name, int num, String email, int office, int salary, String role){
        super(name, num, email, office, salary);
        this.role = role;
    }

    public String toString() {
        return super.toString() + "," + role;
    }


    }