import java.util.*;

public class NumberOfIsland {
    int directions [][] = new int[][] {{-1,0}, {0,1}, {1,0}, {0,-1}}; 

    private void dfs(int row, int col, char[][] grid) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
            return ;
        }

        grid[row][col] = '2';

        for(int direction[] : directions) {
            int newRow = direction[0] + row;
            int newCol = direction[1] + col;
            dfs(newRow, newCol, grid);
        }

    }
    public int numIslands(char [][] grid) {

        if(grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        

        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count += 1;
                }
            }
        }
        return count;
    }
    public static void main(String args[]) {
        NumberOfIsland solution = new NumberOfIsland();
        char grid[][] = {
            {'1','1','0','0'},
            {'0','1','0','0'},
            {'1','0','0','0'},
            {'0','0','1','1'}
        };

        int result = solution.numIslands(grid);

        System.out.println("Number of islands: " + result);

    }
}