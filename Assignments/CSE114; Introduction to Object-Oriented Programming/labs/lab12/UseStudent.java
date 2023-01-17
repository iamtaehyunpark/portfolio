public class UseStudent {

    public static void main(String[] args) {

        Student jen = new Student("Jen", "Cs", 132132, 3.8);

        System.out.println(jen.getName());
        System.out.println(jen.getMajor());

        jen.setName("jen");
        jen.setGpa(4.1);
        jen.setMajor("CS");

        System.out.printf("Your name:%s Your major:%s Your gpa: %d", jen.getName(), jen.getMajor(), jen.getGpa());

        if (jen.goodStudent()) {
            System.out.println("good");
        } else {
            System.out.println("not good");
        }

        Student yong = new Student("yong", "MEC", 1123432, 4.0);
        Student k = new Student("k", "MEC", 11432, 2.2);
        Student l = new Student("l", "MEC", 123432, 3.8);

        Student[] students = {jen, yong, k, l};

        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (students[i].goodStudent()) {
                count++;
            }
            System.out.print(students[i].getName());
        }
        System.out.println(count);
    }
    
}
