import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int nums[];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }


        int result = recur(0, N-1);
        System.out.println(result);
    }

    private static int recur(int left, int right){
        if(left > right){
            return 0;
        }
        if(dp[left][right] != Integer.MAX_VALUE) return dp[left][right];

        int value = Integer.MAX_VALUE;
        if(nums[left] != nums[right]){
            value = Math.min(1+recur(left+1, right),
                    1+recur(left, right-1));
        }else{
            value = recur(left+1, right-1);
        }

        return dp[left][right]=value;
    }


}