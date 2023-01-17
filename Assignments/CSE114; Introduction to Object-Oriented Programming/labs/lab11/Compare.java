//Taehyun Park taehyun.park.1@stonybrook.edu
//Normally, Insertion Sort is the best idea to sort the array since it operates when the conditions in the 'while' are valid.
//And it is slightly better to use the Selection Sort than the Bubble Sort with the lower numbers of camparison.
import java.util.Arrays;
public class Compare {


    private static void swap(int x[], int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }





    public static int sellectionSort(int[] aryS){
        int count = 0;
        for (int i = 0; i < aryS.length; i++){
            for (int j = i+1; j < aryS.length; j++){
                count++;

                if(aryS[j] > aryS[i]) {
                    swap(aryS, i, j);
                }
            }
        } return count;
    }
    public static int insertionSort (int[] aryI) {
        int count = 0;
        for (int i = 1; i < aryI.length; i++) {
            int key = aryI[i];
            int p = i;

            while ((p > 0) && (key < aryI[p - 1])) {
                count++;
                aryI[p] = aryI[p - 1];
                p--;
            }
            count++;
            aryI[p] = key;
        }
        return count;
    }
    public static int bubbleSort(int[] aryB){
        int count = 0;
        for (int i = 0; i < aryB.length; i++){
            for (int j = 1; j < aryB.length; j++){
                count++;
                if(aryB[j] < aryB[j-1]) {
                    swap(aryB, j, j-1);
                }
            }
        } return count;
    }






//Making Array Tools
    public static int[] randomArray (int size, int range){
        int[] ary = new int[size];
        java.util.Random random = new java.util.Random();
        for (int i =0; i < ary.length; i++){
            ary[i] = random.nextInt(range);
        }
        return ary;
    }

    public static int[] ascendingArray (int size){
        int[] ary = new int[size];
        for (int i = 0; i < ary.length; i++){
            ary[i] = i + 1;
        }
        return ary;
    }
    public static int[] descendingArray (int size){
        int[] ary = new int[size];
        for (int i = 0; i < ary.length; i++){
            ary[i] = size - i;
        }
        return ary;
    }
    public static int[] sameArray (int size){
        int[] ary = new int[size];
        for (int i = 0; i < ary.length; i++){
            ary[i] = 17;
        }
        return ary;
    }




    public static void main (String[] args) {

        int[] intsR = randomArray(100, 100);
        int[] intsR1 = Arrays.copyOf(intsR, 100);
        int[] intsR2 = Arrays.copyOf(intsR, 100);
        int[] intsA = ascendingArray(100);
        int[] intsA1 = ascendingArray(100);
        int[] intsA2 = ascendingArray(100);
        int[] intsD = descendingArray(100);
        int[] intsD1 = descendingArray(100);
        int[] intsD2 = descendingArray(100);
        int[] intsS = sameArray(100);
        int[] intsS1 = sameArray(100);
        int[] intsS2 = sameArray(100);

        System.out.printf("The number of the comparisons(Random): Sellection:%d, Insertion:%d, Bubble:%d", sellectionSort(intsR), insertionSort(intsR1), bubbleSort(intsR2));
        System.out.printf("\nThe number of the comparisons(Ascending): Sellection:%d, Insertion:%d, Bubble:%d", sellectionSort(intsA), insertionSort(intsA1), bubbleSort(intsA2));
        System.out.printf("\nThe number of the comparisons(Desecnding): Sellection:%d, Insertion:%d, Bubble:%d", sellectionSort(intsD), insertionSort(intsD1), bubbleSort(intsD2));
        System.out.printf("\nThe number of the comparisons(Same): Sellection:%d, Insertion:%d, Bubble:%d", sellectionSort(intsS), insertionSort(intsS1), bubbleSort(intsS2));



    }

}
