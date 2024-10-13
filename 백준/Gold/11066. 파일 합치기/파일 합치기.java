import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int K;
    static int files[];
    static int[][] dp;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            K = Integer.parseInt(br.readLine());

            files = new int[K+1];
            sum = new int[K+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= K; k++) {
                files[k] = Integer.parseInt(st.nextToken());
                sum[k] = sum[k-1] + files[k];
            }



            dp = new int[K+1][K+1];
            for (int i = 0; i <= K; i++) {
                Arrays.fill(dp[i] , Integer.MAX_VALUE);
            }


            int result = recur(1,K);
            System.out.println(result);

        }
    }

    // left 에서 right 까지 합칠때 얻을 수 있는 최소비용을 반환
    private static int recur(int left, int right){
        if(left == right) return 0;

        if(dp[left][right] != Integer.MAX_VALUE) return dp[left][right];

        int sumCost = Integer.MAX_VALUE;
        int leftCost, rightCost;
        for (int i = left+1; i <= right; i++) {
            leftCost = recur(left, i-1);
            rightCost = recur(i, right);
            sumCost = Math.min(sumCost, leftCost + rightCost + sum[right] - sum[left-1]);
        }
        return dp[left][right]=sumCost;
    }


}