public class maze {
    public static void printMaze(char[][] maze){
        System.out.println("_________________Rate Maze___________");
        for(int i=0; i<maze.length; i++){
            for(int j = 0; j<maze[0].length; j++){
                System.out.print(maze[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] maze = {
            {'I','.','.','.','X','X','X','X'},
            {'.','.','.','.','.','X','X','X'},
            {'X','X','.','X','X','.','.','.'},
            {'X','X','X','.','.','.','.','G'}
        };
        printMaze(maze);
        Function fn = new Function();
        int row=fn.getRow(),col=fn.getCol();
        System.out.println("("+row+","+ col+")");
        while(row<maze.length && col<maze[0].length){
            double Fn = fn.function(maze,row,col);
            row = fn.getRow();
            col = fn.getCol();
            if (maze[row][col] == 'G') {
                maze[row][col] = 'g';
                printMaze(maze);
                System.out.println("("+row+","+ col+")"+","+Fn);
                System.out.println("Goal reached!");
                break;
            }
            maze[row][col] = 'S';
            printMaze(maze);
            System.out.println("("+row+","+ col+")"+","+Fn);
        }
    }
}

class Function {
    private int Row=0;
    private int Col=0;

    public int getRow() {return Row;}
    public void setRow(int Row){this.Row = Row;}
    public int getCol() {return Col;}
    public void setCol(int Col){this.Col = Col;}

    public boolean isGoal(char[][] maze, int row,int col){
        boolean range = row>=0 && row<maze.length && col>=0 && col<maze[0].length;
        if(range && maze[row][col]=='G'){
            setCol(col);
            setRow(row);
            return true;
        }
        return false;
    }

    public double function(char[][] maze, int row, int col){
        double Fn = Double.MAX_VALUE;
        int heuristic = 0; // manhattan distance
        double euclidean = 0.0;
        int goalX = maze.length;
        int goalY = maze[0].length;

        // east col+1,row
        if(isGoal(maze, row, col+1)) return Fn;
        if(col+1<goalY && maze[row][col+1]=='.'){
            int newCol = col+1;
            heuristic = Math.abs(row-0)+Math.abs(newCol-0);
            euclidean = Math.sqrt((Math.pow(row-goalX,2))+(Math.pow(newCol-goalY,2)));
            double F = Fn;
            Fn = Math.min(Fn, heuristic+euclidean);
            if(F!=Fn){
                setCol(newCol);
                setRow(row);
            }
        }
        // west col -1, row
        if(isGoal(maze, row, col-1)) return Fn;
        if(col-1>=0 && maze[row][col-1]=='.'){
            int newCol = col-1;
            heuristic = Math.abs(row-0)+Math.abs(newCol-0);
            euclidean = Math.sqrt((Math.pow(row-goalX,2))+(Math.pow(newCol-goalY,2)));
            double F = Fn;
            Fn = Math.min(Fn, heuristic+euclidean);
            if(F!=Fn){
                setCol(newCol);
                setRow(row);
            }
        }
        // north row-1,col
        if(isGoal(maze, row-1, col)) return Fn;
        if(row-1>=0 && maze[row-1][col]=='.'){
            int newRow = row-1;
            heuristic = Math.abs(row-0)+Math.abs(newRow-0);
            euclidean = Math.sqrt((Math.pow(newRow-goalX,2))+(Math.pow(col-goalY,2)));
            double F = Fn;
            Fn = Math.min(Fn, heuristic+euclidean);
            if(F!=Fn){
                setRow(newRow);
                setCol(col);
            }
        }
        // south row+1,col
        if(isGoal(maze, row+1, col)) return Fn;
        if(row+1<goalX && maze[row+1][col]=='.'){
            int newRow = row+1;
            heuristic = Math.abs(row-0)+Math.abs(newRow-0);
            euclidean = Math.sqrt((Math.pow(newRow-goalX,2))+(Math.pow(col-goalY,2)));
            double F = Fn;
            Fn = Math.min(Fn, heuristic+euclidean);
            if(F!=Fn){
                setRow(newRow);
                setCol(col);
            }
        }
        // north-east row-1,col+1
        if(isGoal(maze, row-1, col+1)) return Fn;
        if(col+1<goalY && row-1>=0 && maze[row-1][col+1]=='.'){
            int newRow = row-1;
            int newCol = col+1;
            heuristic = Math.abs(newCol-0)+Math.abs(newRow-0);
            euclidean = Math.sqrt((Math.pow(newRow-goalX,2))+(Math.pow(newCol-goalY,2)));
            double F = Fn;
            Fn = Math.min(Fn, heuristic+euclidean);
            if(F!=Fn){
                setCol(newCol);
                setRow(newRow);
            }
        }
        // north-west row-1, col-1
        if(isGoal(maze, row-1, col-1)) return Fn;
        if(col-1>=0 && row-1>=0 && maze[row-1][col-1]=='.'){
            int newRow = row-1;
            int newCol = col-1;
            heuristic = Math.abs(newCol-0)+Math.abs(newRow-0);
            euclidean = Math.sqrt((Math.pow(newRow-goalX,2))+(Math.pow(newCol-goalY,2)));
            double F = Fn;
            Fn = Math.min(Fn, heuristic+euclidean);
            if(F!=Fn){
                setCol(newCol);
                setRow(newRow);
            }
        }
        // south-east row+1, col+1
        if(isGoal(maze, row+1, col+1)) return Fn;
        if(col+1<goalY && row+1<goalX && maze[row+1][col+1]=='.'){
            int newRow = row+1;
            int newCol = col+1;
            heuristic = Math.abs(newCol-0)+Math.abs(newRow-0);
            euclidean = Math.sqrt((Math.pow(newRow-goalX,2))+(Math.pow(newCol-goalY,2)));
            double F = Fn;
            Fn = Math.min(Fn, heuristic+euclidean);
            if(F!=Fn){
                setCol(newCol);
                setRow(newRow);
            }
        }
        // south-west row+1, col-1
        if(isGoal(maze, row+1, col-1)) return Fn;
        if(col-1>=0 && row+1<goalX && maze[row+1][col-1]=='.'){
            int newRow = row+1;
            int newCol = col-1;
            heuristic = Math.abs(newCol-0)+Math.abs(newRow-0);
            euclidean = Math.sqrt((Math.pow(newRow-goalX,2))+(Math.pow(newCol-goalY,2)));
            double F = Fn;
            Fn = Math.min(Fn, heuristic+euclidean);
            if(F!=Fn){
                setCol(newCol);
                setRow(newRow);
            }
        }

        return Fn;

    }
    
}