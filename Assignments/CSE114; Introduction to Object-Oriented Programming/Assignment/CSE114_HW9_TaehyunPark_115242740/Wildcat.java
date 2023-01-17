public class Wildcat implements Animal {
    private String name;
    private int age;
    private int topRunningSpeed;
    private String description;
    private String noise;
    private boolean hasMane;

    public Wildcat (String name, int age, int topRunningSpeed, String description){
        this.name = name;
        this.age = age;
        this.topRunningSpeed = topRunningSpeed;
        this.description = description;
        this.hasMane = false;
        this.noise = "Growl...";
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setMane(boolean hasMane){
        this.hasMane = hasMane;
        if(hasMane){
            noise = "Majestic Roar!!!";
        }
    }
    public String describe() {
        if(hasMane) {
            return description + " and has a Mane!";
        }else{
            return description + " and does not have a Mane";
        }
    }
    public void makeNoise() {
        System.out.println(noise);
    }
    public int landSpeed() {
        return topRunningSpeed;
    }

}