//TaehyunPark, Taehyun.park.1@stonybrook.edu
import java.util.Scanner;
public class Cylinder {
    
    public static void main (String[] args) {
	Scanner Scan = new Scanner(System.in);
	System.out.print("Enter the radius of a cylinder (in cm): ");
	int radius = Scan.nextInt();

	System.out.print("Enter the height of the Cylinder (in cm): ");
	int height = Scan.nextInt();

	double cylinderSurface = (2*radius*radius*Math.PI) + (2*radius*height*Math.PI);
	System.out.printf("The surface area of a cylinder is: %5.2fsq.cm", cylinderSurface);
	    }
}
