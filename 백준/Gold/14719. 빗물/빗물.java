import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H;
    static int W;
    static int blocks[];
    static int prefixSum[]; //l 좌표가 i 이하인 위치에서 가장 높은 기둥의 높이
    static int suffixSum[];//l 좌표가 i 이상인 위치에서 가장 높은 기둥의 높이
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        blocks = new int[W+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }


        prefixSum = new int[W+1];
        for (int i = 1; i <= W; i++) {
            prefixSum[i] = Math.max(prefixSum[i-1], blocks[i]);
        }

        suffixSum = new int[W+1];
        suffixSum[W] = blocks[W];
        for (int i = W-1; i > 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i+1], blocks[i]);
        }

        for (int i = 1; i <= W; i++) {
            result += Math.min(prefixSum[i], suffixSum[i]) - blocks[i];

        }

        System.out.println(result);

    }
}