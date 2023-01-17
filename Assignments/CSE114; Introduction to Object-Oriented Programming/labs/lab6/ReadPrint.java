import java.util.Scanner;
public class ReadPrint {

    public static void generateList(int n) {

        int k = 0;
        while (n > 0) {
            System.out.print(k);
             if (n == k){
                 System.out.print(".");
                 break;
            } else {
                 System.out.print(", ");
                 k = k + 1;
             }
        }
        while (n <= 0) {
            System.out.print(n);
             if (n == k){
                 System.out.print(".");
                 break;
            } else {
                 System.out.print(", ");
                 n = n + 1;
             }
        }
    }
    
    public static void main (String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = scan.nextInt();
        generateList(number);

    }

}
