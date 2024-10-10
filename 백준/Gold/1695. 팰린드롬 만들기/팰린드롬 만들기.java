import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int nums[];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            for(int j=0; j< N; ++j){
                dp[i][j] = -1;
            }
        }


        int result = recur(0, N-1);
        System.out.println(result);
    }

    private static int recur(int left, int right) {
        if(right <= left){
            return 0;
        }

        if(dp[left][right] != -1)   return dp[left][right];

        if(nums[right] == nums[left]){
            return dp[left][right] = recur(left + 1, right - 1);
        }

        return dp[left][right] = Math.min(recur(left + 1, right), recur(left, right - 1)) + 1;
    }

}