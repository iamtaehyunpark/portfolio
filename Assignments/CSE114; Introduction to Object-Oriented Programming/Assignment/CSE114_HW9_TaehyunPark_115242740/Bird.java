class Bird implements Animal{
    private String name;
    private int age;
    private String description;
    private int topRunningSpeed;
    private String noise;

    public Bird (String name, int age, String description){
        this.name = name;
        this.age = age;
        this.description = description;
        this.topRunningSpeed = 0;
        this.noise = "Chirp, chirp...";
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String describe() {
        return description;
    }
    public void makeNoise() {
        System.out.println(noise);
    }
    public int landSpeed() {
        return topRunningSpeed;
    }

}