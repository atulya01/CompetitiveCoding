import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesProblem {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }


    private static class Index{
        int i;
        int j;

        Index(int i, int j){
            this.i = i;
            this.j =j;
        }
    }


    public static int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        int timeLapsed = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Index> queue = new LinkedList();

        //iterate and find rotten and freah oranges
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    //add to queue
                    queue.add(new Index(i,j));

                }
                if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        //Poll oranges from queue and rot adjacent oranges
        while(!queue.isEmpty() && freshOranges > 0){
            timeLapsed++;
            int size = queue.size();

            while(size > 0){
                size--;
                Index rottenOrangeIdx = queue.poll();

                int i = rottenOrangeIdx.i;
                int j = rottenOrangeIdx.j;

                if((i+1 < m) && grid[i+1][j] == 1){
                    queue.add(new Index(i+1,j));
                    grid[i+1][j] = 2;
                    freshOranges--;
                }
                if((i-1 >= 0) && grid[i-1][j] == 1){
                    queue.add(new Index(i-1,j));
                    grid[i-1][j] = 2;
                    freshOranges--;
                }
                if((j+1 < n) && grid[i][j+1] == 1){
                    queue.add(new Index(i,j+1));
                    grid[i][j+1] = 2;
                    freshOranges--;
                }
                if((j-1 >=0 ) && grid[i][j-1] == 1){
                    queue.add(new Index(i,j-1));
                    grid[i][j-1] = 2;
                    freshOranges--;
                }
            }
        }

        return freshOranges == 0 ? timeLapsed : -1;
    }
}
