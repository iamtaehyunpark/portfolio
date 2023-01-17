public class Student {

 private String name;
 private String major;
 private int id;
 private static double gpa;

 public Student() {
     name = "";
     major = "";
     id = 0;
     gpa = 0.00;
 }
 public Student(String iniName, String iniMajor, int iniId, double iniGpa){
     name = iniName;
     major = iniMajor;
     id = iniId;
     gpa = iniGpa;
 }

 public void setName(String newName){
     name = newName;
 }
  public void setMajor(String newMajor){
     major = newMajor;
 }
  public void setGpa(double newGpa){
     gpa = newGpa;
 }



 public String getName() {
  return name;
 }
 public String getMajor(){
     return major;
 }
 public Double getGpa(){
     return gpa;
 }


 public static Boolean goodStudent() {
     boolean isGood = gpa > 3.0;
     return isGood;
    }
}