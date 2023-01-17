//Taehyun Park taehyun.park.1@stonybrook.edu
public class InterleaveArrays {

    public static int[] interleaveArrays (int[] array1, int[] array2){
    int[] interArray = new int[array1.length + array2.length];
    for(int i = 0; i < array1.length; i++){
        interArray[2*i] = array1[i];
    }
    for(int i = 1; i < array2.length+1; i++){
        interArray[2*i-1] = array2[i-1];
    }
    return interArray;

    }


    public static int[] mergeArrays (int[] array1, int[] array2){
        int[] mergeArray = new int[array1.length + array2.length];
        for(int i = 0; i < array1.length; i++){
            mergeArray[i] = array1[i];
        }
        for(int i = 0; i < array2.length; i++){
            mergeArray[array1.length+i] = array2[i];
        }
        
        for(int i = 0; i < mergeArray.length; i++){
            for(int j = i + 1; j < mergeArray.length; j++) {
                if (mergeArray[i] >= mergeArray[j]) {
                    int temp = mergeArray[i];
                            mergeArray[i] = mergeArray[j];
                            mergeArray[j] = temp;
                }
            }
        }

        return mergeArray;
    }


    public static void main (String[] args) {

        int[] interArrEx1 = interleaveArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        int[] interArrEx2 = interleaveArrays(new int[]{10, 20, 30, 40}, new int[]{2, 4, 6, 8});
        int[] interArrEx3 = interleaveArrays(new int[]{1,5,6,7,8,9}, new int[]{20,50,60,70,90});
        int[] interArrEx4 = interleaveArrays(new int[]{100, 200, 300, 400}, new int[]{31, 45, 86, 98});

        for (int i = 0; i < interArrEx1.length; i++) {
            System.out.print(interArrEx1[i] + ",");
        }
        System.out.println();
        for (int i = 0; i < interArrEx2.length; i++) {
            System.out.print(interArrEx2[i] + ",");
        }
        System.out.println();
        for (int i = 0; i < interArrEx3.length; i++) {
            System.out.print(interArrEx3[i] + ",");
        }
        System.out.println();
        for (int i = 0; i < interArrEx4.length; i++) {
            System.out.print(interArrEx4[i] + ",");
        }
        System.out.println();







        int[] mergeArrEx1 = mergeArrays(new int[]{2, 5, 15, 20, 25, 40}, new int[]{10, 20, 30, 40});
        int[] mergeArrEx2 = mergeArrays(new int[]{1, 11, 31, 45, 77, 78, 79, 101}, new int[]{2, 5, 11, 12, 31, 45, 77, 78, 79, 80, 101, 103, 120});
        int[] mergeArrEx3 = mergeArrays(new int[]{8, 9, 4, 55, 16, 878}, new int[]{24, 55, 67, 98, 64});
        int[] mergeArrEx4 = mergeArrays(new int[]{1, 79, 9878, 5542, 454}, new int[]{5, 64, 8794, 552231, 554, 77, 78, 988, 875});

        for (int i = 0; i < mergeArrEx1.length; i++) {
            System.out.print(mergeArrEx1[i] + ",");
        }
        System.out.println();
        for (int i = 0; i < mergeArrEx2.length; i++) {
            System.out.print(mergeArrEx2[i] + ",");
        }
        System.out.println();
        for (int i = 0; i < mergeArrEx3.length; i++) {
            System.out.print(mergeArrEx3[i] + ",");
        }
        System.out.println();
        for (int i = 0; i < mergeArrEx4.length; i++) {
            System.out.print(mergeArrEx4[i] + ",");
        }
    }

}