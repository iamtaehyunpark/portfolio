//Taehyun Park taehyun.park.1@stonybrook.edu
public class MagicSquare {

    public static Boolean isMagicSquare(int[][] magic) {
        // Check range and unique

        for (int i = 0; i < magic.length; i++) {
            for (int j = 0; j < magic[i].length; j++) {
                // Check cell range
                if (magic[i][j] > (int) Math.pow(magic.length, 2)) {
                    return false;
                }

                // Check unique
                for (int row = 0; row < magic.length; row++) {
                    for (int column = 0; column < magic[row].length; column++) {
                        if (row == i && column == j) {
                        } else if (magic[row][column] == magic[i][j]) {
                            return false;
                        }
                    }
                }

            }
        }



        int checkValue = 0;
        for (int j = 0; j < magic.length; j++) {

        checkValue += magic[0][j];
        }
        // Check columns
        int testValue = 0;
        // Check rows
        for (int i = 0; i < magic.length; i++) {
        for (int j = 0; j < magic[i].length; j++) {
        testValue += magic[i][j];
        }
        if (testValue != checkValue) {
        return false;
        }
        testValue = 0;
        }
        // Check columns
        for (int j = 0; j < magic[0].length; j++) {
        for (int i = 0; i < magic.length; i++) {
        testValue += magic[i][j];
        }
        if (testValue != checkValue) {
        return false;
        }
        testValue = 0;
        }
        // check main diagonal (upper left to lower right)
        testValue = 0;
        for (int i = 0; i < magic.length; i++) {
        testValue += magic[i][i];
        }
        if (checkValue != testValue) {
        return false;
        }
        // check reverse diagonal
        testValue = 0;
        int size = magic.length;
        for (int i = 0; i < magic.length; i++) {
        testValue += magic[size - 1 - i][i];
        }
        if (checkValue != testValue) {
        return false;
        }


        return true;
    }




    public static int[][] buildMatrix(String[] values) {


        int length = (int) Math.sqrt(values.length);
        int[][] builtMatrix = new int[length][length];
        int stringOrder = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                builtMatrix[i][j] = Integer.parseInt(values[stringOrder]);
                stringOrder++;
            }
        } return builtMatrix;
    }

    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    public static void main (String[] values) {
    int[][] squareMatrix = buildMatrix(values);
    printMatrix(squareMatrix);

    if(isMagicSquare(squareMatrix)){
        System.out.print("yes");
    } else {
        System.out.print("no");
    }
    }

}




