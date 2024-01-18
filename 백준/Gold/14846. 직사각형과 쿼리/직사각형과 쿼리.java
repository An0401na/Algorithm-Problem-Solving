import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][][] sum;
    static int Q;
    static int x1;
    static int x2;
    static int y1;
    static int y2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        sum = new int[N+1][N+1][11];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                sum[i][j] = checkUsedNumber(i,j);
                sum[i][j][n] ++;
            }
        }

        Q = Integer.parseInt(br.readLine());
        for (int q= 0; q < Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            sb.append(countNumber(x1,y1,x2,y2)+"\n");
        }
        System.out.println(sb.toString());

    }

    private static int countNumber(int x1, int y1, int x2, int y2) {
        int usedNumber[] = new int[11];
        for (int k = 1; k <= 10; k++) {
            usedNumber[k] = sum[x2][y2][k] - sum[x1-1][y2][k] - sum[x2][y1-1][k] + sum[x1-1][y1-1][k];
        }

        int cnt = 0;
        for (int i = 1; i <= 10 ; i++) {
            if(usedNumber[i] > 0){
                cnt++;
            }
        }

        return cnt;
    }


    private static int[] checkUsedNumber(int i, int j) {
        int usedNumber[] = new int[11];
        for (int k = 1; k <= 10; k++) {
            usedNumber[k] = sum[i-1][j][k] + sum[i][j-1][k] - sum[i-1][j-1][k];
        }
        return usedNumber;
    }
}