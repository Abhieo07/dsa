package backtreking;

public class validSudoku {
    
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
        System.out.println(sudoku(board));
    }

    private static boolean sudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                char ch = board[i][j];
                board[i][j] = '.';
                if(isValid(board,i,j,ch)==false) return false;
                board[i][j] = ch;
            }
        }
        return true;
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
}
