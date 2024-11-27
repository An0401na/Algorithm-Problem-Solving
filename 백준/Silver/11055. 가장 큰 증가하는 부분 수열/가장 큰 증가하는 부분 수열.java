import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int A;
    static int arr[];
    static int dp[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[A+1];
        for (int i = 1; i < A+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[A+1][A+1];
        for (int i = 0; i < A+1; i++) {
            Arrays.fill(dp[i], -1);
        }




        System.out.println(recur(0, 1));

//        for (int i = 0; i < A+1; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }
    public static int recur(int prev, int cur){
        if(cur > A) return 0;

        if(dp[prev][cur] != -1) return dp[prev][cur];

        int result = 0;
        if(arr[prev] < arr[cur]){
            result = Math.max(recur(prev, cur+1) , recur(cur, cur+1) + arr[cur]);
        }
        else {
            result = recur(prev, cur+1);
        }

        return dp[prev][cur] = result;
    }


//    public static int recur(int prev, int cur){
//        if(cur > A) return 0;
//
//        int result = 0;
//        if(arr[prev] < arr[cur]){
//            result = Math.max(recur(prev, cur+1) , recur(cur, cur+1) + arr[cur]);
//        }
//        else {
//            result = recur(prev, cur+1);
//        }
//
//        return result;
//    }
}
/*
10
2 11 3 14 1 200 100 5 101 13

227
 */