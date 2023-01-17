//TaehuynPark,Taehyun.park.1@stonybrook.edu
import java.util.Scanner;
public class ForeignMoney {
    
    public static void main (String[] args) {
	Scanner shoosScan = new Scanner(System.in);
	System.out.print("Enter number of shoos: ");
	int shoos = shoosScan.nextInt();
	Scanner haltersScan = new Scanner(System.in);
	System.out.print("Enter number of Halters: ");
	int halters = haltersScan.nextInt();

	int totalHalters = shoos*100 + halters;

	Scanner noteScan = new Scanner(System.in);
	System.out.print("Enter bill used to pay (1, 2, 5, 10, or 20): ");
	int note = noteScan.nextInt()*100;

	int change;
        change = note - totalHalters;

	System.out.println("Change:\n 10 Shoo bills: " + change / 1000);
	change = change % 1000;
	System.out.println(" 5 Shoo bills: " + change / 500);
	change = change % 500;
	System.out.println(" 2 shoo bills: " + change / 200);
	change = change % 200;
	System.out.println(" 1 Shoo bills: " + change / 100);
	change = change % 100;
	System.out.println(" 50 Halter coins: " + change / 50);
	change = change % 50;
	System.out.println(" 10 Halter coins: " + change / 10);
	change = change % 10;
	System.out.println(" 5 Halter coins: " + change / 5);
	change = change % 5;
	System.out.println(" 1 Halter coins: " + change / 1);
	
     }
}
