import sun.nio.cs.ext.MacHebrew;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] houses;
    static int[][][] dp;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        houses = new int[N][3];
        dp = new int[N][3][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
//        for (int i = 0; i < 3; i++) {
//            dfs(1, i, houses[0][i], i);
//        }
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, recur(1, i, i)+houses[0][i]);
        }

        System.out.println(min);

    }
    public static int recur(int cur, int prevColor, int first){
        if(cur >= N)  return 0;

        if(dp[cur][prevColor][first] != Integer.MAX_VALUE) return dp[cur][prevColor][first];

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if(i == prevColor) continue;
            if(cur == N-1 && i == first) continue;
            result = Math.min(result, recur(cur+1, i, first)+houses[cur][i]);
        }

        return dp[cur][prevColor][first] = result;
    }

//    public static void dfs(int cur, int prevColor, int sum, int first){
//        if(cur >= N) {
//            min = Math.min(min, sum);
//            return;
//        }
//
//        for (int i = 0; i < 3; i++) {
//            if(i == prevColor) continue;
//            if(cur == N-1 && i == first) continue;
//            dfs(cur+1, i, sum+houses[cur][i], first);
//        }
//    }
}