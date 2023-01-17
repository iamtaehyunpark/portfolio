//Taehyun Park taehyun.park.1@stonybrook.edu
import java.util.Arrays;
public class Recursion {

    public static int minOf(int[] ary) {
        if (ary.length == 1) {
            return ary[0];
        } else if (ary.length == 2) {
            if (ary[0] < ary[1]) {
                return ary[0];
            } else {
                return ary[1];
            }
        } else {
            if (ary[ary.length-1] > ary[ary.length - 2]) {
                return minOf(Arrays.copyOf(ary, ary.length - 1));
            } else {
                int[] tempAry = Arrays.copyOf(ary, ary.length-1);
                tempAry[tempAry.length-1] = ary[ary.length-1];
                return minOf(tempAry);
            }
        }
    }

    public static int f(int n){
        if(n < 3){
            return n;
        } else {
            return f(n-1) + 2*f(n-2) + 3*f(n-3);
        }
    }

    public static void printBackward(String str){
        if(str.length() > 0) {
            System.out.print(str.charAt(str.length() - 1)+" ");
            String strT = str.substring(0, str.length() - 1);
            printBackward(strT);
        }
    }

    public static void printString(String str){
        if(str.length() > 0) {
            System.out.print(str.charAt(0)+" ");
            String strT = str.substring(1);
            printString(strT);
        }
    }

    public static String reverseString(String str) {
        if(str.length() > 0) {
            String strT = str.substring(0, str.length() - 1);
            return str.charAt(str.length()-1) + reverseString(strT);
        } return str;
    }



    public static void main(String[] args){
        int[] intArray = {109,2,-5,1010,44,33,9,-200,101010,4,-4};

        System.out.print("Min of: ");
        printArray(intArray);
        System.out.println(minOf(intArray));

        System.out.println("f(2) = " + f(2));
        System.out.println("f(3) = " + f(3));
        System.out.println("f(10) = " + f(10));

        printBackward("Java Fun!");
        System.out.println();
        printString("Java Fun!");
        System.out.println();
        String reversed = reverseString("Java Fun!");
        System.out.println(reversed);
    }




    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
