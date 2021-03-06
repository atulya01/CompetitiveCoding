public class FindIn2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 16;

        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix[0].length == 0 || matrix.length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;

        while(i < m && j >= 0){
            int currVal = matrix[i][j];
            if(currVal == target){
                return true;
            }else if(currVal < target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
