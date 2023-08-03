package backtreking;

public class KnightTour {
    public static void main(String[] args) {
        int[][] grid = {{0,11,16,5,20},
                        {17,4,19,10,15},
                        {12,1,8,21,6},
                        {3,18,23,14,9},
                        {24,13,2,7,22}
                    };
        System.out.println(helper(grid, 0,0,0));
    }

    private static boolean helper(int[][] grid, int row, int col, int num) {
        int n = grid.length;
        // base case
        if(grid[row][col] == n*n - 1) return true;
        int i,j;
        // 2 up 1 right
        i = row - 2;
        j = col + 1;
        if(i >= 0 && j < n && grid[i][j] == num+1) return helper(grid, i, j, num+1);
        // 2 up 1 left
        i = row - 2;
        j = col - 1;
        if(i >= 0 && j >= 0 && grid[i][j] == num+1) return helper(grid, i, j, num+1);
       
        // 2 down 1 right
        i = row + 2;
        j = col + 1;
        if(i < n && j < n && grid[i][j] == num+1) return helper(grid, i, j, num+1);
        // 2 down 1 left
        i = row + 2;
        j = col - 1;
        if(i < n && j >= 0 && grid[i][j] == num+1) return helper(grid, i, j, num+1);
        
        // 2 right 1 down
        i = row + 1;
        j = col + 2;
        if(i < n && j < n && grid[i][j] == num+1) return helper(grid, i, j, num+1);
        // 2 right 1 up
        i = row - 1;
        j = col + 2;
        if(i >= 0 && j < n && grid[i][j] == num+1) return helper(grid, i, j, num+1);
       
        // 2 left 1 down
        i = row + 1;
        j = col - 2;
        if(i < n && j >= 0 && grid[i][j] == num+1) return helper(grid, i, j, num+1);
        // 2 left 1 up
        i = row - 1;
        j = col - 2;
        if(i >= 0 && j >= 0 && grid[i][j] == num+1) return helper(grid, i, j, num+1);

        return false;
    }
}
