public class DiagonalsIn2DMatrix {
    /*
    1 2 3 4
    5 6 7 8
    9 10 11 12
    13 14 15 16

    1
    5 2
    9 6 3
    13 10 7 4 (3,0) (2,1) (1,2) (0,3)
    14 11 8 (3,1) (2,2) (1,3)
    15 12 (3,2) (2,3)
    16 (3,3)
     */

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printDiagonals(matrix);
    }

    static void printDiagonals(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int k = 0;
        for (; k < matrix.length; k++) {
            int i = k;
            for (int j = 0; j <= k; j++) {
                System.out.print(matrix[i][j] + " ");
                i--;
            }
            System.out.println();
        }


        int i = matrix.length-1;
        int l = 1;
        for(int z = i; z >0; z--) {
            i = matrix.length-1;
            for (int j = l; j <matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
                i--;
            }
            l++;
            System.out.println();
        }



    }
}



