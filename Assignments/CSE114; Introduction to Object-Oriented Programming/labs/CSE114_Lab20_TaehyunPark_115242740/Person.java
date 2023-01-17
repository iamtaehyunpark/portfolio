public class Person {
    protected String name;
    protected int num;
    protected String email;
    
    public Person (String name, int num, String email){
        this.name = name;
        this.num = num;
        this.email= email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String toString() {
        return name;
    }
}