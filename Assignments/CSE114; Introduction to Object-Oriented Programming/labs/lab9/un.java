public class un {

    public static boolean isMagicSquare(int[][] ary) {
        int standard = ary.length*(ary.length*ary.length + 1)/2;
        
        int sumI = 0;
        int sumJ = 0;
        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary[i].length; j++) {
                sumI += ary[i][j];
                sumJ += ary[j][i];
            }
            if (sumI != standard|sumJ != standard) {
                return false;
            } else {
                sumI = 0;
                sumJ = 0;
            }
        }
        for (int i = 0, j = 0; i < ary.length; i++, j++) {
            sumI += ary[i][j];
            sumJ += ary[i][ary.length-(j+1)];
        }
        if (sumJ != standard|sumI != standard) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        int[][] ary = {{16,3,2,13}, {5,10,11,8}, {9,6,7,12}, {4,15,14,1}};
        if (isMagicSquare(ary)) {
            System.out.print("T");
        } else {
            System.out.print("F");
        }
    }
}


