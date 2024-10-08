import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int w;
    static int h;
    static int dir[][] = {{0,1}, {1,0}};
    static int dp[][][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        dp = new int[h+1][w+1][2][102];

        for (int i = 0; i < h+1; i++) {
            for (int j = 0; j < w+1; j++) {
                for (int k = 0; k < 2; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        int result = recur(1, 1, 0, 2, true);
        System.out.println(result);
    }

    private static int recur(int r, int c, int d, int dis, boolean isFirst ) {
        if(r == h && c == w ) return 1;
        if(dp[r][c][d][dis] != -1) {
            return dp[r][c][d][dis];
        }

        int caseCnt = 0;
        for (int i = 0; i < 2; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if(dis < 2 && d != i) continue;

            if(isInRange(nr, nc)){
                caseCnt += recur(nr, nc, i, d == i || isFirst == true? dis+1 : 1, false);
                caseCnt %= 100000;
            }
        }


        dp[r][c][d][dis] = caseCnt;
        return dp[r][c][d][dis];
    }

    private static boolean isInRange(int r, int c) {
        return 1 <= r && r <= h && 1 <=c && c <= w;
    }
}