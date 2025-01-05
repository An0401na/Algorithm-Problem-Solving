import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static int N;
    static char[][] board;
    static int dir[][] = {{1,0}, {0,1}};
    static char mola[] = {'M', 'O', 'L', 'A'};
    static int dp[][][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        dp = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(recur(0, 0, 0));

    }
    public static int recur(int r, int c, int idx){
        if(board[r][c] == 'M') idx = 1;

        if(dp[r][c][idx] != -1)return dp[r][c][idx];

        int value = 0;
        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(!isInRange(nr, nc)) continue;
            if(board[nr][nc] == mola[idx]){
                if(idx == 3){
                    value = Math.max(value, recur(nr, nc, 0)+1);
                }else{
                    value = Math.max(value, recur(nr, nc, idx+1));
                }
                continue;
            }
            value = Math.max(value, recur(nr, nc, 0));
        }

        return dp[r][c][idx] = value;

    }

    public static boolean isInRange(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
