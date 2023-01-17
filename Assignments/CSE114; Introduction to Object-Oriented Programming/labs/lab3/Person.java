import java.util.Scanner;

public class Person {

    public static void main (String[] args) {

	Scanner scan = new Scanner(System.in);

	System.out.print("What is your name?");
	String name;
	    name = scan.next();
	    System.out.print("How olds are you?");
	    int old;
	    old = scan.nextInt();
	    System.out.println(name + "is" + old + "years old");

	    Scanner scan2 = new Scanner(System.in);
	    System.out.print("What lectures are you in?");
	    String lectures;
	    lectures = scan2.next();

	    System.out.println("He says: I am enrolled in" + lectures);
    }
}
