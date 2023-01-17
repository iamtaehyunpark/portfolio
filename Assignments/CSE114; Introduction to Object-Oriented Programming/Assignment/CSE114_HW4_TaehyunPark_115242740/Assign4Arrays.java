//Taehyun Park taehyun.park.1@stonybrook.edu
public class Assign4Arrays {

    public static void swapColumns(String[][] array, int col1, int col2) {

        if(0 < col1 && 0 < col2 && col1 < array.length && col2 < array.length) {

            String[] temp = new String[array.length];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i][col1];
                array[i][col1] = array[i][col2];
            }
            for (int i = 0; i < array.length; i++) {
                array[i][col2] = temp[i];
            }
        } else return;
    }

    public static void printMatrix(String[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        String[][] a = {{"E", "D", "B", "C", "A"}, {"Q", "Y", "Z", "X", "L"}, {"4", "2", "3", "1", "M"}, {"W", "S","U","R","G"},{"S","F","D","P","A"}};
        printMatrix(a);
        System.out.println();
        
        swapColumns(a, 2, 3);
        printMatrix(a);
        System.out.println();

        swapColumns(a, 1, -3);
        printMatrix(a);
        System.out.println();

        swapColumns(a, 5, 3);
        printMatrix(a);
        System.out.println();

}



}