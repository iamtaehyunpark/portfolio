public class SkipPrint {

    public static void skipPrint(int n) {

        int k = 0;
        System.out.print(k + ", ");
                k = k + 1;
                    while (k <= n){
                        if ((k % 5) == 0) {
                            System.out.print(", ");
                            k = k + 1;
                        } else if ((k % 3) == 0){
                            System.out.print(", ");
                            k = k + 1;
                        } else{
                            System.out.print(k + ", ");
                            k = k + 1;
                        }
                    }
    }

    public static void main (String args[]) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scan.nextInt();

        if(number > 0) {
            skipPrint(number);
        } else {
        }

    }
}