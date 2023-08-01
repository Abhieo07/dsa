package java_dsa_basics.backtreking;

public class RatMaze4dir {
    public static void main(String[] args) {
        int rows = 3, cols = 3;

        boolean[][] isVisited = new boolean[rows][cols];
        path(0,0,rows-1,cols-1,"",isVisited);
    }

    private static void path(int sr, int sc, int er, int ec, String s,boolean[][] isVisited) {
        if(sr > er || sc > ec || sc < 0 || sr < 0) return;
        if(isVisited[sr][sc]) return;//v imp if the node is already visited
        if(sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        isVisited[sr][sc] = true;
        // go right
        path(sr, sc+1, er, ec, s+"R",isVisited);
        // go left
        path(sr, sc-1, er, ec, s+"L",isVisited);
        // go down
        path(sr+1, sc, er, ec, s+"D",isVisited);
        // go up
        path(sr-1, sc, er, ec, s+"U",isVisited);
        isVisited[sr][sc] = false; //backtracing
    }
}
