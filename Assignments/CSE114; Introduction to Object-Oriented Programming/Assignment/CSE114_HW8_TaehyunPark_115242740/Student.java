//Taehyun Park taehyun.park.1@stonybrook.edu
public class Student {

    private String name;
    private int id;
    private String major;
    private double gpa;
    private int classOf;

    public final static int order_Gpa_Within_Major = 1;
    public final static int order_Gpa_Within_ClassOf = 2;
    public final static int order_Major_Within_ClassOf = 3;

    private int ordering;

    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public int getId () {
        return id;
    }
    public void setId (int id) {
        this.id = id;
    }
    public String getMajor () {
        return major;
    }
    public void setMajor (String major) {
        this.major = major;
    }
    public double getGpa () {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public int getClassOf () {
        return classOf;
    }
    public void setClassOf (int classOf) {
        this.classOf = classOf;
    }


    public void setOrdering (int ordering){
        this.ordering = ordering;
    }
    public String getOrdering(){
        if(this.ordering == order_Gpa_Within_Major) {
            return "Gpa Within Major";
        } else if(this.ordering == order_Gpa_Within_ClassOf) {
            return "Gpa Within ClassOf";
         }else{
            return "Major Within ClassOf";
        }
    }


    public Student (String name, String major, int id, double gpa, int classOf) {
        this.name = name;
        this.major = major;
        this.id = id;
        this.gpa = gpa;
        this.classOf = classOf;
        this.ordering = order_Gpa_Within_Major;
    }

    public int compareTo (Student s2) {

        if (this.ordering == order_Gpa_Within_Major) {
            if (this.major.compareTo(s2.major) == 0) {
                if (this.gpa > s2.gpa) {
                    return -1;
                } else if (this.gpa == s2.gpa) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return this.major.compareTo(s2.major);
            }
        } else if (this.ordering == order_Gpa_Within_ClassOf) {
            if (this.classOf == s2.classOf) {
                if (this.gpa > s2.gpa) {
                    return -1;
                } else if (this.gpa == s2.gpa) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (this.classOf > s2.classOf) {
                    return -1;
                } else {
                    return 1;
                }
            }
        } else {
            if (this.classOf == s2.classOf) {
                return this.major.compareTo(s2.major);
            } else {
                if (this.classOf > s2.classOf) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

    public String toString() {
        return this.major+" : "+this.gpa+" : "+this.classOf+" : "+this.name+"/"+this.id;
    }

}


