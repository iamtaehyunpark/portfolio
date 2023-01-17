public class Jet implements Comparable{ //implements here(Jet.java) so that there is no need to
                                        //implement again in subclasses since they extend this.
    protected String manufacturer;
    protected String Model;
    protected int year;
    protected String owner;
    protected int grossWeightEmpty;
    protected int lastOverhaul;
    protected int numOverhauls;
    protected int maxRecommendedFlightHours;

    public Jet (String manufacturer, String Model, int year, String owner, int grossWeightEmpty,
                int lastOverhaul, int numOverhauls, int maxRecommendedFlightHours){
        this.manufacturer = manufacturer;
        this.Model = Model;
        this.year = year;
        this.owner = owner;
        this.grossWeightEmpty = grossWeightEmpty;
        this.lastOverhaul = lastOverhaul;
        this.numOverhauls = numOverhauls;
        this.maxRecommendedFlightHours = maxRecommendedFlightHours;
    }
    public String getModel(){
        return Model;
    }


    public void sellTo(String owner){
        this.owner = owner;
    }
    public void overhaul() {
        this.lastOverhaul = 0;
        this.numOverhauls++;
    }
    public int timeTillOverhaul() {
        return maxRecommendedFlightHours - lastOverhaul;
    }
    public void fly(int flownHour){
        lastOverhaul += flownHour;
    }
    public boolean needsOverhaul(){
        return (maxRecommendedFlightHours - lastOverhaul) < 150;
    }
    public boolean isAging() {
        return (2022 - year) > 15 && numOverhauls >= 25;
    }
    public int compareTo(Object o2) {
        if (this.grossWeightEmpty < ((Jet)o2).grossWeightEmpty) {
            return -1;
        } else if (this.grossWeightEmpty == ((Jet)o2).grossWeightEmpty) {
            return 0;
        } else {
            return 1;
        }
    }



    public static void main(String[] args){
        Jet j1 = new Jet("Boeing","747",2019,"Asiana",280000,3700,3,3800);
        Jet j2 = new Jet("Lockheed","Dc-10",2004,"US Air Force",7000,0,26,1000);
        j2.sellTo("KR Army");
        if(j1.needsOverhaul()){
            j1.overhaul();
        }
        if(j2.isAging()){
            System.out.println(j2.getModel() + " should be destroyed");
        }
    

        if(j1.compareTo(j2)>0){
        System.out.println(j1.getModel() +" is heavier than j2");
        }else if(j1.compareTo(j2)==0){
            System.out.println(j1.getModel() +" j1 has the same weight with j2");
        }else{
            System.out.println(j1.getModel() +" j1 is lighter than j2");
        }

    }



}