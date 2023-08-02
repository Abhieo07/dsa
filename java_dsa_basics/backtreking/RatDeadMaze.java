package java_dsa_basics.backtreking;

public class RatDeadMaze {
    public static void main(String[] args) {
        int rows = 4, cols = 6;

        int[][] maze = {{1,0,1,1,1,1},
                        {1,1,1,1,0,1},
                        {0,1,1,1,1,1},
                        {0,0,1,0,1,1}};
                        
        boolean[][] isVisited = new boolean[rows][cols];
        // path(0,0,rows-1,cols-1,"",maze);
        pathBacktracing(0,0, rows-1, cols-1, "", maze,isVisited);
    }

    private static void path(int sr, int sc, int er, int ec, String s,int[][] maze) {
        if(sr > er || sc > ec) return;
        if(sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        if(maze[sr][sc] == 0) return;
        // go right
        path(sr, sc+1, er, ec, s+"R", maze);
        // go down
        path(sr+1, sc, er, ec, s+"D", maze);
    }

    private static void pathBacktracing(int sr, int sc, int er, int ec, String s,int[][] maze, boolean[][] isVisited) {
        if(sr > er || sc > ec || sc < 0 || sr < 0) return;
        
        if(sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        if(maze[sr][sc] == 0) return;
        if(isVisited[sr][sc]) return;
        isVisited[sr][sc] = true;
        // go right
        pathBacktracing(sr, sc+1, er, ec, s+"R", maze,isVisited);
        // go down
        pathBacktracing(sr+1, sc, er, ec, s+"D", maze,isVisited);
        // go left
        pathBacktracing(sr, sc-1, er, ec, s+"L", maze,isVisited);
        // go up
        pathBacktracing(sr-1, sc, er, ec, s+"U", maze,isVisited);

        // backtracing
        isVisited[sr][sc] = false;
    }

}
