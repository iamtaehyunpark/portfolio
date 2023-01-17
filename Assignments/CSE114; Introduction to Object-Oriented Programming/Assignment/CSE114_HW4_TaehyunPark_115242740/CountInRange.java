//Taehyun Park taehyun.park.1@stonybrook.edu
import java.util.Scanner;
public class CountInRange {

    public static int countInRange (int[] ary, int a, int b){
        int upper, lower;
        if(a >= b){
            upper = a;
            lower = b;
        } else {
            upper = b;
            lower = a;
        }

        int count = 0;

        for (int i : ary){
            if(i <= upper && i >= lower){
                count++;
            }
        }
        return count;
    }

    public static void main (String[] args) {
        int[] a1 = {14, 1, 22, 17, 36, 7, -43, 5};
        System.out.println(countInRange(a1, 17, 4));
        System.out.println(countInRange(a1, 4, 17));

        int[][] arr = {{5, 6, 12}, {4, 8, 19}};

        int value = 0;


        for (int row = 1; row < arr.length; row++) {

            for (int col = 1; col < arr[0].length; col++) {

                if (arr[row][col] % 2 == 1) {

                    arr[row][col] = arr[row][col] + 1;

                }

                if (arr[row][col] % 2 == 0) {

                    arr[row][col] = arr[row][col] * 2;

                }

            }
        }

        for (int row = 0; row < arr.length; row++) {

            for (int col = 0; col < arr[0].length; col++) {
                System.out.print(arr[row][col]);
            }


        }
    }


        

}