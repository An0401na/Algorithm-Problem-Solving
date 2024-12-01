import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N = 19;
    static int board[][];
    static boolean visited[][][];
    static int[][] dir = {{0, 1},{1,1},{1,0},{1,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 0) continue;
                for (int d = 0; d < 4; d++) {
                    if(visited[i][j][d] == true) continue;
                    if(win(i, j, d, board[i][j])){
                        System.out.println(board[i][j]);
                        if(d == 3){
                            System.out.println((i+1+4) +" "+(j+1-4));
                        }else{
                            System.out.println((i+1) +" "+(j+1));
                        }

                        System.exit(0);
                    }

                }
            }
        }

        System.out.println(0);
    }

    public static boolean win(int r, int c, int d, int color){
//        System.out.println("r : " + r +", c : " + c + ", d : " + d +", color : " + color);

        int cnt = 1;
        while (true){
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(!isInRange(nr, nc) || board[nr][nc] != color) break;
            visited[nr][nc][d] = true;
            cnt++;
//            System.out.println("  nr : " + nr +", nc : " + nc + ", color : " + board[nr][nc] + ", cnt : " + cnt);
            r = nr;
            c = nc;
        }
//        System.out.println("  # cnt : " + cnt);

        if(cnt == 5) return true;
        return false;
    }
    public static boolean isInRange(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N ;
    }
}