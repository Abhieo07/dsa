package java_dsa_basics.backtreking;

public class RatMazeOpt {
    public static void main(String[] args) {
        int rows = 4, cols = 6;

        int[][] maze = {{1,0,1,1,1,1},
                        {1,1,1,1,0,1},
                        {0,1,1,1,1,1},
                        {0,0,1,0,1,1}};

        pathBacktracing(0,0, rows-1, cols-1, "", maze);
    }

    private static void pathBacktracing(int sr, int sc, int er, int ec, String s,int[][] maze) {
        if(sr > er || sc > ec || sc < 0 || sr < 0) return;
        if(maze[sr][sc] == 0 || maze[sr][sc] == -1) return;
        if(sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        
        maze[sr][sc] = -1;
        // go right
        pathBacktracing(sr, sc+1, er, ec, s+"R", maze);
        // go down
        pathBacktracing(sr+1, sc, er, ec, s+"D", maze);
        // go left
        pathBacktracing(sr, sc-1, er, ec, s+"L", maze);
        // go up
        pathBacktracing(sr-1, sc, er, ec, s+"U", maze);

        // backtracing
        maze[sr][sc] = 1;
    }
}
