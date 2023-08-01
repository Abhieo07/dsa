package java_dsa_basics.backtreking;

public class RatMaze {
    public static void main(String[] args) {
        int rows = 3, cols = 3;

        int count = maze(1,1,rows,cols);
        System.out.println(count);
        path(0,0,rows-1,cols-1,"");
    }

    private static void path(int sr, int sc, int er, int ec, String s) {
        if(sr > er || sc > ec) return;
        if(sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        // go right
        path(sr, sc+1, er, ec, s+"R");
        // go down
        path(sr+1, sc, er, ec, s+"D");
    }

    private static int maze(int sr, int sc, int er, int ec) {
        if(sr > er || sc > ec) return 0;
        if(sr == er && sc == ec) return 1;
        int downWays = maze(sr+1, sc, er, ec);
        int rightWays = maze(sr, sc+1, er, ec); 
        int totalWays = downWays + rightWays;
        return totalWays;
    }
}
