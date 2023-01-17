//Taehyun Park taehyun.park.1@stonybrook.edu
public class Bubble {

    private static void swap(int x[], int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    public static int[] bubbleSort(int[] ary){
        for (int i = 0; i < ary.length; i++){
            for (int j = 1; j < ary.length; j++){
                if(ary[j] < ary[j-1]) {
                    swap(ary, j, j-1);
                }
            }
        } return ary;
    }

    public static void main (String[] args){

        int limit = Integer.parseInt(args[0]);
        int[] ints = ArrayTools.randomArray(limit, 100);

        ArrayTools.printArray(ints, "\nBefore sorted:");

        bubbleSort(ints);
        ArrayTools.printArray(ints, "\nAfter sorted:");
    }



}





class ArrayTools {
    public static int[] randomArray (int size, int range){
        int[] ary = new int[size];
        java.util.Random random = new java.util.Random();
        for (int i =0; i < ary.length; i++){
            ary[i] = random.nextInt(range);
        }
        return ary;
    }

    public static void printArray(int[] ary, String out) {
        System.out.println(out);
        for (int i =0; i < ary.length; i++) {
            System.out.print(ary[i] + " ");
        }
        System.out.println();
    }

}