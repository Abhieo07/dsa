package backtreking;

public class sudokuSolver2 {
    static int check = 0;
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void solveSudoku(char[][] board) {
        solve(board,0,0);
        check = 0;
        
    }

    private static boolean isValid(char[][] board, int row, int col, char ch) {
        // check row
        for(int j = 0; j < 9; j++){
            if(board[row][j] == ch) return false;
        }
        // check column
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == ch) return false;
        }
        // checking 3X3 grid
        int R = (row / 3) * 3;
        int C = (col / 3) * 3;
        for (int i = R; i < R + 3; i++) {
            for (int j = C; j < C+3; j++) {
                if(board[i][j] == ch) return false;
            }
        }

        return true;
    }

    private static void solve(char[][] board, int row, int col) {
        if(row == 9){
            check = 1;
            return;
        }
        else if(board[row][col] != '.'){ // call
            if(col != 8) solve(board, row, col+1);
            else solve(board, row+1, 0);
        }
        else { //board[row][col] != '.'
            for(char ch = '1'; ch <= '9'; ch++){
                if(isValid(board,row,col,ch)){
                    board[row][col] = ch;
                    if(col != 8) solve(board, row, col+1);
                    else solve(board, row+1, 0);
                    if(check == 1) return;
                    board[row][col] = '.'; //backtracing
                }
            }
        }
    }
}
