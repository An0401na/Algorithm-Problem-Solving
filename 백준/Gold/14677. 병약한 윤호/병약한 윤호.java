import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] drug;
    static int dp[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        drug = new int[N*3];

        String str = br.readLine();
        for (int i = 0; i < N*3; i++) {
            if(str.charAt(i) == 'L'){
                drug[i] = 1;
            } else if (str.charAt(i) == 'D') {
                drug[i] = 2;
            }
        }
        dp = new int[N*3][N*3][3];
        for (int i = 0; i < N*3; i++) {
            for (int j = 0; j < N*3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
//        System.out.println(Arrays.toString(drug));

        eatDrug(0, 0, 3*N -1);

        System.out.println(dp[0][3*N-1][0]);


    }

    // 남아 있는 약이 start ~ end 이고 먹기 시작해야하는 약이 bld 일때 최대로 먹을 수 있는 약의 개수를 반환
    private static int eatDrug(int bld, int start, int end) {
        if (start > end) {
            return 0;
        }
        int nextBld;
        if (bld == 2) {
            nextBld = 0;
        } else {
            nextBld = bld + 1;
        }

        int frontEat = 0;
        int backEat = 0;
        if (dp[start][end][bld] == -1) {
            if (drug[start] == bld) {
                frontEat = eatDrug(nextBld, start + 1, end) + 1;
            }
            if (drug[end] == bld) {
                backEat = eatDrug(nextBld, start, end - 1) + 1;
            }
            dp[start][end][bld] = Math.max(frontEat, backEat);
        }

        return dp[start][end][bld];
    }




//    static int max = 0;
//    private static void eatDrug(int cnt, int bld, int start, int end) {
//        if(start > end) {
//            return;
//        }
//        max = Math.max(max, cnt);
//        int nextBld;
//        if(bld == 2){
//            nextBld = 0;
//        }else{
//            nextBld = bld+1;
//        }
//
//        if(drug[start] == bld){
////            System.out.println("==================");
////            System.out.println("앞에 약 먹음");
////            System.out.println("먹은 약 수 : " + (cnt+1));
////            System.out.println("먹을 약 번호 : " + nextBld);
////            System.out.println("범위 : " + (start+1) +" ~ "+ end);
//            eatDrug(cnt+1, nextBld, start+1, end);
//        }
//
//        if (drug[end] == bld){
//
////            System.out.println("==================");
////            System.out.println("뒤에 약 먹음");
////            System.out.println("먹은 약 수 : " +(cnt+1));
////            System.out.println("먹을 약 번호 : " + nextBld);
////            System.out.println("범위 : " + start +" ~ "+ (end-1));
//            eatDrug(cnt+1, nextBld, start, end-1);
//        }
//    }
}