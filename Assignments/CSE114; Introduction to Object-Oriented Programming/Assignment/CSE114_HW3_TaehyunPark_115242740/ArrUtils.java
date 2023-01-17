//Taehyun Park taehyun.park.1@stonybrook.edu
import java.util.Random;
public class ArrUtils {
    
    public static int[] randomArray (int range, int size) {
        Random randomNumber = new Random();
        int[] array = new int[size];
                for(int i = 0; i < array.length; i++){
                    array[i] = randomNumber.nextInt(range);
                }
                return array;
    }

    public static void printArray (int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int arrSum (int[] array) {
        int sum = 0;
        for (int j = 0; j < array.length; j = j + 1) {
            sum = sum + array[j];
        }
        return sum;
    }

    public static boolean contains (int find, int[] array){
        boolean ifContain = false;
        for(int i = 0; i < array.length; i++){
            ifContain = find == array[i];
            if(ifContain){
                break;
            }
        }
        return ifContain;
    }

    public static int indexof (int search, int[] array){
        boolean searchInArray = false;
        int i;
        for(i = 0; i < array.length; i++){
            searchInArray = search == array[i];
            if(searchInArray){
                break;
            }
        }
        return i;
    }



    public static boolean isMultiplied(int multiplying, int multiplied) {  //auxiliary function to test if a number is a mutiple
         return multiplied % multiplying == 0;
    }
    public static int countMultiplesOf(int multiplying, int[] array){

        int count = 0;
        for(int j = 0; j < array.length; j++){
            if(isMultiplied(multiplying,array[j])){
                count ++;
            }
        }
        return count;
    }



    public static int largestInt(int[] array) {   //auxiliary function to find the largest int in the array
        int largest = array[0];
        for(int i = 0; i < array.length; i++) {
            if (largest < array[i]){
                largest = array[i];
            }
        }
        return largest;
    }
    public static int[] buildHistogram (int[] scores){
        int[] hist = new int[largestInt(scores) + 1];

        for(int j = 0; j <= largestInt(scores); j++) {
            for (int i = 0; i < scores.length; i++) {
                if (j == scores[i]) {
                    hist[j]++;
                }
            }
        }
        return hist;
    }
    public static void printHistogram (int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print("\f" + i + ":" + array[i] + ":");
            for(int j = 0; j < array[i]; j++){
                System.out.print('*');
            }
        }
    }



    public static void main (String[] args){
        int[] array = randomArray(21, 101);

        printArray(array);

        System.out.printf("Your random array's average of the numbers is: %10.2f \f",(float)arrSum(array)/array.length);

        if(contains(14, array)){
            System.out.println("14 is contained to the array");
        } else {
            System.out.println("14 in not containe to the array");
        }

        System.out.println("14 is in the index of : " + indexof(14,array));

        System.out.println("The number of multiples of 7 in your random array is:" + countMultiplesOf(7,array));
        
        int[] histArray = buildHistogram(array);
                printHistogram(histArray);

    }

}