//TahyunPark Taehyun.park.1@stonybrook.edu

import java.util.Scanner;
public class Collatz {
    
    public static boolean isEven(int x) {
	boolean isEven = x % 2 == 0;
		return isEven;
    }
    
    public static int nextCollatz(int x) {
	    if(isEven(x)) {
		return x/2;
		    }
	    else {
		return x*3 + 1;
	    }
	}
		
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter a number: ");
	int number = scan.nextInt();

	int next = nextCollatz(number);
	System.out.println(next);
    }
    }
    
	
	
	 
