import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N;
    static int M;
    static int[] smallStone;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        smallStone = new int[M];

//        br.readLine();
//        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
//            smallStone[i]= Integer.parseInt(st.nextToken());
            smallStone[i]= Integer.parseInt(br.readLine());
        }

        dp = new int[10001][250];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        Arrays.sort(smallStone);

        int result = recur(1, 0);
        System.out.println(result >= 10_001? -1 : result);
    }

    // 앞으로 최선의 선택을 할때 얻을 수 있는 최소 점프 회수를 리턴
    private static int recur(int cur, int x){
        if(cur > N){
            return 10_010;
        }

        for (int j = 0; j < M; j++) {
            if(smallStone[j] == cur){
                return 10_010;
            }
        }

        if(cur == N){
            return 0;
        }

        if(dp[cur][x] != -1) return dp[cur][x];

        int min = Integer.MAX_VALUE;
        for (int i = -1; i <= 1 ; i++) {
            int next = cur + x+i;
            if(next <= cur) continue;
            min = Math.min(min, recur(next, x+i)+1);
        }

        return dp[cur][x] = min;
    }
}
