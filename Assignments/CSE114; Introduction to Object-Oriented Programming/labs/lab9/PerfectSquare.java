public class PerfectSquare {

    public static boolean isMagicSquare(int[][] ary) {
        int standard = ary.length*(ary.length*ary.length + 1)/2;
        //Standard sum of ary

        int sum = 0;
        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary[i].length; j++) {
                sum += ary[i][j];
            }
            if (sum != standard) {
                return false;
            } else {
                sum = 0;
            }
        }

        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary[i].length; j++) {
                sum += ary[j][i];
            }
            if (sum != standard) {
                return false;
            } else {
                sum = 0;
            }
        }

        for (int i = 0, j = 0; i < ary.length; i++, j++) {
            sum += ary[i][j];
        }

        if (sum != standard) {
            return false;
        } else {
            sum = 0;
        }
        for (int i = ary.length-1, j = 0; j < ary.length; i--, j++) {
            sum += ary[i][j];
        }

        if (sum != standard) {
            return false;
        } else {
            sum = 0;
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


