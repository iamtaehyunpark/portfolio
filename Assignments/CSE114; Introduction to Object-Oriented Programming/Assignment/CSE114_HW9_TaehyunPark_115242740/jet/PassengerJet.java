public class PassengerJet extends Jet{
    private int numPassengers;
    private int numEngines;
    private boolean hasAutopilot;

    public PassengerJet (String manufacturer, String Model, int year, String owner, int grossWeightEmpty,
                int lastOverhaul, int numOverhauls, int maxRecommendedFlightHours, int numPassengers,
                         int numEngines, boolean hasAutopilot) {
        super(manufacturer,Model,year,owner,grossWeightEmpty,lastOverhaul,numOverhauls,maxRecommendedFlightHours);
        this.numPassengers = numPassengers;
        this.numEngines = numEngines;
        this.hasAutopilot = hasAutopilot;
    }
    
    public boolean isDifficultToFly(){
        return hasAutopilot;
    }
    public boolean needsLongRunway() {
        return grossWeightEmpty > 300000;
    }
    public int compareTo(Object o2) {
        if (this.numEngines < ((PassengerJet)o2).numEngines) {
            return -1;
        } else if (this.numPassengers == ((PassengerJet)o2).numEngines) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String args[]){
        Jet.main(args);
        Jet j1 = new PassengerJet("Boeing","747",2019,"Asiana",380000,3700,3,3800,300,2,true);
        Jet j2 = new PassengerJet("Lockheed","Dc-10",2004,"US Air Force",7000,0,26,1000,2,2,false);

        System.out.println("Is j1 difficult to fly? : "+ ((PassengerJet)j1).isDifficultToFly());
        System.out.println("Does j2 need long runway to fly? : "+((PassengerJet)j2).needsLongRunway());

        if(j1.compareTo(j2) < 0) {
            System.out.println("j1 has more engines.");
        } else if(j1.compareTo(j2) == 0) {
            System.out.println("j1 has the same amount of engines.");
        } else {
            System.out.println("j1 has less amount of engines.");
        }


    }
}