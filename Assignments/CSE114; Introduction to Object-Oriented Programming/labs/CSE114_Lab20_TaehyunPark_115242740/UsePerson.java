public class UsePerson {


    public static void main (String[] args) {

        


        Person P1 = new Student("A",010544,"A@naver.com","Freshman","CS");
        Person P2 = new Student("B",010232,"B@naver.com","Sophomore","MEC");
        Person P3 = new Student("C",010634,"C@naver.com","Senior","AMS");
        Person P4 = new Faculty("D",010142,"D@naver.com",1,2000,"Japanese","Language","Assistant");
        Person P5 = new Faculty("E",010523,"E@naver.com",2,3000,"AI","Computer","Associate");
        Person P6 = new Staff("F",010453,"F@naver.com",3, 1000, "Admmission Office");
        Person P7 = new Staff("G",01045,"G@naver.com",4, 1100, "Security");

        System.out.println(P1.toString());
        System.out.println(P2.toString());
        System.out.println(P3.toString());
        System.out.println(P4.toString());
        System.out.println(P5.toString());
        System.out.println(P6.toString());
        System.out.println(P7.toString());
        System.out.println();

        Person[] ary = new Person[7];
        ary[0] = P1;
        ary[1] = P2;
        ary[2] = P3;
        ary[3] = P4;
        ary[4] = P5;
        ary[5] = P6;
        ary[6] = P7;

        ary[5].setName("John");

        System.out.println(P6.toString());
        System.out.println();


        Employee[] ary2 = {(Employee)P4,(Employee)P5,(Employee)P6,(Employee)P7};
        for(Employee i : ary2){
            i.setSalary((int)(i.getSalary()*1.1));
        }
        
        System.out.println(P4.toString());
        System.out.println(P5.toString());
        System.out.println(P6.toString());
        System.out.println(P7.toString());



    }


}