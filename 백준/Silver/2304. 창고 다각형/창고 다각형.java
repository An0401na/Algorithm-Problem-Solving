import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int columns[];
    static int prefixSum[]; //l 좌표가 i 이하인 위치에서 가장 높은 기둥의 높이
    static int suffixSum[];//l 좌표가 i 이상인 위치에서 가장 높은 기둥의 높이
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        columns = new int[1001];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            columns[l] = h;
        }


        prefixSum = new int[1001];
        prefixSum[0] = columns[0];
        for (int i = 1; i < 1001; i++) {
            prefixSum[i] = Math.max(prefixSum[i-1], columns[i]);
        }

        suffixSum = new int[1001];
        suffixSum[1000] = columns[1000];
        for (int i = 999; i > 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i+1], columns[i]);
        }

        for (int i = 1; i <= 1000; i++) {
            result += Math.min(prefixSum[i], suffixSum[i]);

        }

        System.out.println(result);

    }
}