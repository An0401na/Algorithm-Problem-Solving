import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int cost[];
    static int days[];
    static int dp[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cost = new int[N+1];
        days = new int[N+1];


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }


        dp = new int[N+100];
        Arrays.fill(dp , Integer.MIN_VALUE);
//        System.out.println(recur(1));
        bottomUp();
        System.out.println(dp[1]);
    }

    // 현제 day일이고, 앞으로 최선을 다해서 선택할 경우 최대 벌 수 있는 cost 를 반환하는 함수
    private static int recur(int day) {

        if(day == N+1){
            return 0;
        }

        if(day > N+1){
            return Integer.MIN_VALUE;
        }

        if(dp[day] == -1){
            dp[day] = Math.max(recur(day + days[day])+cost[day], recur(day+1));
        }
        return  dp[day];
    }

    private static void bottomUp(){
        dp[N+1] = 0;
        for (int i = N; i > 0; i--) {
            dp[i] = Math.max(dp[i + days[i] ] + cost[i], dp[i + 1]);
        }
    }
}