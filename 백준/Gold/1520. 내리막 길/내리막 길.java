import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int map[][];
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }
        int result = recur(0, 0);
        System.out.println(result);
    }

    private static int recur(int r, int c){
        if(r == M-1 && c == N-1){
            return 1;
        }

        if(dp[r][c] != -1) return dp[r][c];

        int caseCnt = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(isInRange(nr, nc) && map[nr][nc] < map[r][c]){
                caseCnt += recur(nr, nc);
            }
        }

        return dp[r][c]=caseCnt;

    }

    private static boolean isInRange(int r, int c) {
        return r >=0 && r < M && c >= 0 && c < N;
    }



}