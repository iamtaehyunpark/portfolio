//Taehyun Park taehyun.park.1@stonybrook.edu
import java.util.Scanner;
public class Volumes {

    public static void main (String args[]) {

        Scanner scanVolume1 = new Scanner(System.in);
        System.out.println("Volume 1:");
        System.out.print("Enter gallons (int): ");
                int gallons1 = scanVolume1.nextInt();
        System.out.print("Enter quarts (int): ");
                int quarts1 = scanVolume1.nextInt();
        System.out.print("Enter cups (int): ");
                int cups1 = scanVolume1.nextInt();

        Scanner scanVolume2 = new Scanner(System.in);
        System.out.println("Volume 2:");
        System.out.print("Enter gallons (int): ");
                int gallons2 = scanVolume1.nextInt();
        System.out.print("Enter quarts (int): ");
                int quarts2 = scanVolume1.nextInt();
        System.out.print("Enter cups (int): ");
                int cups2 = scanVolume1.nextInt();

        int gallons = gallons1 + gallons2;
        int quarts = quarts1 + quarts2;
        int cups = cups1 + cups2;

        if(cups >= 4) {
            quarts += (cups / 4);
                    cups = (cups % 4);
        } else {

        }

        if(quarts >= 4) {
            gallons += (quarts / 4);
            quarts = (quarts % 4);
        } else {
            
        }

        System.out.printf("Totals: Gallons: %d Quarts: %d Cups: %d", gallons, quarts, cups);


    }

}