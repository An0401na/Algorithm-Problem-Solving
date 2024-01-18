import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int matrix[][];
    static int matrixSum[][];
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        matrixSum = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                matrixSum[i][j] = matrixSum[i][j-1]+matrixSum[i-1][j]+matrix[i][j]-matrixSum[i-1][j-1];
            }
        }




        for (int startR = 1; startR <= N ; startR++) {
            for (int startC = 1; startC <= M ; startC++) {
                for (int endR = startR; endR <= N; endR++) {
                    for (int endC = startC; endC <= M ; endC++) {
                        max = Math.max(max, matrixSum[endR][endC]-matrixSum[startR-1][endC]-matrixSum[endR][startC-1]+matrixSum[startR-1][startC-1]);
                    }
                }
            }
        }
        System.out.println(max);

    }
}