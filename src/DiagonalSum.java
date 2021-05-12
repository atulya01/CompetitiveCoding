public class DiagonalSum {

    public static void main(String[] args) {
        int[][] matrix = {{0,1}};

        /*
        1   2     3     4
        -1  0    -2     -9
        5   6     0     -6
        -1   2     3     -4

        00  01  02
        10  11  12
        20  21  22

        00 01 02 03
        10 11 12 13
        20 21 22 23
        30 31 32 33

        i 0
        j 2
         */

        int resultSum = getDiagonalSum(matrix);
        System.out.print(resultSum);
    }

    static int getDiagonalSum(int[][] matrix){
        int sum = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = rows - 1;

        if(rows == 0 || cols ==0 || (cols != rows)){
            return Integer.MIN_VALUE;
        }

        for(int i=0, j=n; i <=n && j>=0; i++,j--){
            sum = sum + (matrix[i][i] + matrix[i][j]);
        }

        return sum;
    }
}
