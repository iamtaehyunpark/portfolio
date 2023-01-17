//TaehyunPark taehyun.park.1@stonybrook.edu
public class Rotate {
    public static void rotate(int[][] matrix, int numColumns, char direction) {
        if (numColumns <= 0) {
            return;
        }

        if (direction == 'l') {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < numColumns; j++) {
                    int temp = matrix[i][0];
                    for (int k = 0; k < matrix[i].length-1; k++) {
                        matrix[i][k] = matrix[i][k + 1];
                    }
                    matrix[i][matrix[i].length - 1] = temp;
                }
            }
        } else if (direction == 'r') {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < numColumns; j++) {
                    int temp = matrix[i][matrix[i].length-1];
                    for (int k = matrix[i].length-1; k > 0; k--) {
                        matrix[i][k] = matrix[i][k-1];
                    }
                    matrix[i][0] = temp;
                }
            }
        }

    }




    public static void main(String[] args) {
        int[][] a = {{1, 3, 5, 7, 9}, {1, 2, 3}, {10, 20, 30, 40, 50, 60}, {7, 1}, {2, 4, 6, 8}};
        rotate(a, 2, 'r');
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
