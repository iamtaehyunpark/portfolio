public class Dog implements Animal{
    private String name;
    private int age;
    private int topRunningSpeed;
    private String description;
    private String noise;

    public Dog (String name, int age, int topRunningSpeed, String description){
        this.name = name;
        this.age = age;
        this.topRunningSpeed = topRunningSpeed;
        this.description = description;
        if(topRunningSpeed > 10){
            this.noise = "Rough,Rough...";
        } else {
            this.noise = "Yip, Yip...";
        }
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public String describe(){
        return description;
    }
    public void makeNoise(){
        System.out.println(noise);
    }
    public int landSpeed(){
        return topRunningSpeed;
    }

}