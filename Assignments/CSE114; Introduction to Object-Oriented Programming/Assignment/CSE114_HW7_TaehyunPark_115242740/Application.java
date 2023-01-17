public class Application {
    private int id;
    private String name;
    private String addr;
    private String city;
    private String state;
    private String zip;
    private String num;
    private String major;
    private String GPA;
    private String scholarship;

    public Application (int initId, String initName, String initAddr, String initCity,
                        String initState, String initZip, String initNum, String initMajor,
                        String initGPA, String initScholarship){

        id = initId;
        name = initName;
        addr = initAddr;
        city = initCity;
        state = initState;
        zip = initZip;
        num = initNum;
        major = initMajor;
        GPA = initGPA;
        scholarship = initScholarship;
    }

    public int getId () {
        return id;
    }
    public void setId (int id) {
        this.id = id;
    }
    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getAddr () {
        return addr;
    }
    public void setAddr (String addr) {
        this.addr = addr;
    }
        public String getCity () {
        return city;
    }
    public void setCity (String city) {
        this.city = city;
    }
        public String getState () {
        return state;
    }
    public void setState (String state) {
        this.state = state;
    }
        public String getZip () {
        return zip;
    }
    public void setZip (String zip) {
        this.zip = zip;
    }
    public String getNum () {
        return num;
    }
    public void setNum (String num) {
        this.num = num;
    }
    public String getMajor () {
        return major;
    }
    public void setMajor (String major) {
        this.major = major;
    }
    public String getGPA () {
        return GPA;
    }
    public void setGPA (String GPA) {
        this.GPA = GPA;
    }
    public String getScholarship () {
        return scholarship;
    }
    public void setScholarship (String scholarship) {
        this.scholarship = scholarship;
    }



}