public class Search2DMatrixII {

    //https://leetcode.com/problems/search-a-2d-matrix-ii
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 16;

        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n -1;
        while(i < m && j >=0){
            int currVal = matrix[i][j];
            if(target == currVal){
                return true;
            }else if(target > currVal){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
