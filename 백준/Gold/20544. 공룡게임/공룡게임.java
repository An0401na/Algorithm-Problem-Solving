import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int dp[][][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][3][3][2];
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        int result = recur(2, 0, 0, 0);
        System.out.println(result);
    }

    private static int recur(int cur, int preHeight, int cactusCnt, int isTwoCactus) {
        if(cactusCnt >= 3) return 0;
        if(cur == N+1){
            if(isTwoCactus == 1) {
                return 1;
            }
            else return 0;
        }
        if(dp[cur][preHeight][cactusCnt][isTwoCactus] != -1) {
            return dp[cur][preHeight][cactusCnt][isTwoCactus];
        }

        int caseCnt = 0;
        for (int i = 0; i <= 2; i++) {
            int isTwo = isTwoCactus;
            if(isTwoCactus == 0 && i == 2){
                isTwo = 1;
            }
            if(i == 0){
                caseCnt += recur(cur+1, 0, 0, isTwo);
                caseCnt%=1000000007;
            }else{
                if(preHeight == 2 && i == 2) continue;
                caseCnt += recur(cur+1, i, cactusCnt+1, isTwo);
                caseCnt%=1000000007;
            }
        }

        return dp[cur][preHeight][cactusCnt][isTwoCactus] = caseCnt;
    }

}