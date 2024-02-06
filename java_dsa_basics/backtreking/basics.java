public class Main
{
    public static void changeArr(int[] arr, int idx){
        if(idx == arr.length){
            printArr(arr);
            return;
        }
        arr[idx] = 1+idx;
        changeArr(arr,idx+1);
        arr[idx] = arr[idx] - 2;
    }
    
    public static void printArr(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        } 
        System.out.println();
    }
    
    public static void findSubset(String str, String ans, int idx){
        if(idx == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }
            System.out.println(ans);
            return;
        }
        findSubset(str, ans+str.charAt(idx),idx+1);
        findSubset(str, ans,idx+1);
        
    }
    
    public static void findPermutation(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        for (int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            // abcde => ab + de to remove c
            String newStr = str.substring(0,i) + str.substring(i+1);
            findPermutation(newStr, ans+curr);
        } 
        
        
    }
    
    public static void printBoard(char board[][]){
        int n = board.length;
        System.out.println("_________chess board_________");
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(board[i][j]+" ");
            } 
            System.out.println();
        }
    }
    
    public static boolean isSafe(char board[][], int row, int col){
        // vertically up
        for (int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q') return false;
        }
        
        // diagonally left up
        for (int i=row-1,j=col-1; i>=0&&j>=0; i--,j--){
            if(board[i][j] == 'Q') return false;
        }
        
        // diagonally right up
        for (int i=row-1,j=col+1; i>=0&&j<board.length; i--,j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    
    public static void nQinNRows(char board[][], int row){
        // base 
        if(row==board.length){
            printBoard(board);
            return;
        }
        // column loop
        for (int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQinNRows(board, row+1); // function call
                board[row][j] = 'X'; // backtracking step 
            }
        } 
    }
    
	public static void main(String[] args) {
// 		int arr[] = new int[5];
// 		changeArr(arr,0);
// 		printArr(arr);
		
// 		String str = "abc";
// 		findSubset(str,"", 0);
// 		findPermutation(str, "");
        int n = 4;
        char board[][] = new char[n][n];
        // initialise
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j] = 'X';
            } 
        }
        nQinNRows(board, 0);
	}
}
