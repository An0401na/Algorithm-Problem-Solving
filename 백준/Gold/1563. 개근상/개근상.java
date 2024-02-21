import java.beans.PropertyEditorManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static long dp[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());




        dp = new long[N+1][3][4];
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(recur(0, 0, 0));

//        recur1(0, 0, 0);
//        System.out.println(count);
    }


    //day일까지 학교를 나갔고 앞으로의 개근상을 받을 수 있는 경우의 수를 반환하는 함수
    private static long recur(int day, int late, int absence){
        if(late == 2 || absence == 3){
            return 0;
        }
        if(day == N) {
            return 1;
        }


        if(dp[day][late][absence] == -1) {

            //day에 출석
            long a = recur(day + 1, late, 0);

            //day에 지각
            long b = recur(day + 1, late + 1, 0);

            //day에 결석
            long c = recur(day + 1, late, absence + 1);

            dp[day][late][absence] = (a + b + c) % 1_000_000;
        }


        return dp[day][late][absence];

    }



//    //day일까지 학교를 나갔고 앞으로의 개근상을 받을 수 있는 경우의 수를 반환하는 함수
//    private static long recur(int day, int late, int absence){
//        if(late == 2 || absence == 3){
//            return 0;
//        }
//        if(day == N) {
//            return 1;
//        }
//
//
//
//        //day에 출석
//        long a = recur(day+1, late, 0);
//
//        //day에 지각
//        long b = recur(day+1,  late+1, 0);
//
//        //day에 결석
//        long c = recur(day+1, late, absence+1);
//
//        return (a + b + c) % 1_000_000;
//
//    }

    static int count;
    private static void recur1(int day, int late, int absence){
        if(late == 2 || absence == 3){
            return;
        }
        if(day == N) {
            count ++;
            return;
        }

        //day에 출석
        recur1(day+1, late, 0);

        //day에 지각
        recur1(day+1, late+1, 0);

        //day에 결석
        recur1(day+1, late, absence+1);

    }
}