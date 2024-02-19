import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int num[];
    static int answer;
    static long memo[][];
    static long newmemo[][];
    static long cnt =0 ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        answer = Integer.parseInt(st.nextToken());
        memo = new long[21][N-1];
        newmemo = new long[21][N-1];
        memo[num[0]][0] = 1;
        for (int i = 1; i < N-1; i++) {
            for (int j = 0; j < 21; j++) {
                if(memo[j][i-1] > 0){
                    if(isInRange(j-num[i])){
                        memo[j-num[i]][i] += memo[j][i-1];
//                        memo[j-num[i]][i] += 1;
                    }
                    if(isInRange(j+num[i])){
                        memo[j+num[i]][i] += memo[j][i-1];
//                        memo[j+num[i]][i] +=1;
                    }
                }
            }
        }

//        System.out.print("-  ");
//        for (int i = 0; i < N-1; i++) {
//            System.out.print(num[i]+"  ");
//        }
//        System.out.println();
//        for (int i = 0; i < 21; i++) {
//            System.out.print(i+"  ");
//            for (int j = 0; j < N-1; j++) {
//                System.out.print(memo[i][j]+ "  ");
//            }
//            System.out.println();
//        }

//        System.out.println(cnt);
//        equation(1, num[0]);
//        System.out.print("-  ");
//        for (int i = 0; i < N-1; i++) {
//            System.out.print(num[i]+"  ");
//        }
//        System.out.println();
//        for (int i = 0; i < 21; i++) {
//            System.out.print(i+"  ");
//            for (int j = 0; j < N-1; j++) {
//                System.out.print(newmemo[i][j]+ "  ");
//            }
//            System.out.println();
//        }


//        System.out.println(cnt);
        System.out.println(memo[answer][N-2]);

    }
    private static boolean isInRange(int n){
        return n >= 0 && n <= 20;
    }
    //
    private static void equation(int index, int result){
        if(result < 0 || result > 20) return;
        if(index <= N-1){
            newmemo[result][index-1] +=1;
        }
        if(index == N-1){
            if(result == answer){
                cnt++;
            }
            return;
        }

        // + 선택
        equation(index+1, result+num[index]);

        // - 선택
        equation(index+1, result-num[index]);
    }
}