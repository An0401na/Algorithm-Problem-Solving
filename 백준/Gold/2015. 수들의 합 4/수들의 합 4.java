import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long K;
    static long A[];
    static long prefixSum[];
    static HashMap<Long, Integer> prefixSumCntMap;
    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        A = new long[N+1];
        prefixSum = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        prefixSumCntMap = new HashMap<>();
        prefixSumCntMap.put(0L,1); // prefixSum[i]와 K가 같은 경우
        for (int i = 1; i <= N; i++) {
            // 누적합 배열
            prefixSum[i] = prefixSum[i-1] + A[i];

            // K를 만드는 수를 key로 가지는 map이 있다면 value를 반환
            // 없다면 0을 반환
            cnt += prefixSumCntMap.getOrDefault(prefixSum[i]-K,0);
            prefixSumCntMap.put(prefixSum[i], prefixSumCntMap.getOrDefault(prefixSum[i],0)+1);
        }


        System.out.println(cnt);


    }
}