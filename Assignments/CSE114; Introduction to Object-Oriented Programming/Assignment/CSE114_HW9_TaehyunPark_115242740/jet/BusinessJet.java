public class BusinessJet extends Jet{
    private int numPassengers;
    private boolean transOceanCertified;
    private boolean theJetRocks;

    public BusinessJet (String manufacturer, String Model, int year, String owner, int grossWeightEmpty,
                         int lastOverhaul, int numOverhauls, int maxRecommendedFlightHours, int numPassengers,
                         boolean transOceanCertified) {
        super(manufacturer, Model, year, owner, grossWeightEmpty, lastOverhaul, numOverhauls, maxRecommendedFlightHours);
        this.numPassengers = numPassengers;
        this.transOceanCertified = transOceanCertified;
        if(numPassengers >= 12 && transOceanCertified) {
            this.theJetRocks = true;
        }else{
            this.theJetRocks = false;
        }
    }

    public int compareTo(Object o2) {
        if (this.numPassengers < ((BusinessJet)o2).numPassengers) {
            return -1;
        } else if (this.numPassengers == ((BusinessJet)o2).numPassengers) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main (String[] args){
        Jet.main(args);

        Jet j1 = new BusinessJet("Boeing","747",2019,"Asiana",280000,3700,3,3800,300,true);
        Jet j2 = new BusinessJet("Lockheed","Dc-10",2004,"US Air Force",7000,0,26,1000,2,false);
        if(j1.compareTo(j2) < 0) {
            System.out.println("j1 allows more passengers to ride");
        } else if(j1.compareTo(j2) == 0) {
            System.out.println("j1 allows the same amount of passengers to ride");
        } else {
            System.out.println("j1 allows less passengers to ride");
        }

    }
}