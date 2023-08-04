package backtreking;

public class K_Knights {
    public static void main(String[] args) {
        int n = 2;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        k_knights(board,0,0);
    }

    private static void k_knights(char[][] board, int row, int col) {
        int n = board.length;
        if(row == n){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        else if(isSafe(board, row, col)){
            board[row][col] = 'K';
            if(col != n-1) k_knights(board, row, col + 1);
            else k_knights(board, row + 1, 0);
            board[row][col] = '.'; //backtracing
        }
        if(col != n - 1) k_knights(board, row, col + 1);
        else k_knights(board, row + 1, 0);

    }

    private static boolean isSafe(char[][] grid, int row, int col) {
        int n = grid.length;
        int i,j;
        // 2 up 1 right
        i = row - 2;
        j = col + 1;
        if(i >= 0 && j < n && grid[i][j] == 'K') return false;
        // 2 up 1 left
        i = row - 2;
        j = col - 1;
        if(i >= 0 && j >= 0 && grid[i][j] == 'K') return false;
       
        // 2 down 1 right
        i = row + 2;
        j = col + 1;
        if(i < n && j < n && grid[i][j] == 'K') return false;
        // 2 down 1 left
        i = row + 2;
        j = col - 1;
        if(i < n && j >= 0 && grid[i][j] == 'K') return false;
        
        // 2 right 1 down
        i = row + 1;
        j = col + 2;
        if(i < n && j < n && grid[i][j] == 'K') return false;
        // 2 right 1 up
        i = row - 1;
        j = col + 2;
        if(i >= 0 && j < n && grid[i][j] == 'K') return false;
       
        // 2 left 1 down
        i = row + 1;
        j = col - 2;
        if(i < n && j >= 0 && grid[i][j] == 'K') return false;
        // 2 left 1 up
        i = row - 1;
        j = col - 2;
        if(i >= 0 && j >= 0 && grid[i][j] == 'K') return false;

        return true;
    }
}
