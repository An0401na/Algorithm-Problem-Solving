import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int K;
    static int[] sum;
    static Map<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

            // 1. 누적합 중에서 K되면 answer에 더해준다.
            if (sum[i] == K) answer++;
        }

        for (int i = 1; i <= N; i++) {
            // 3. 누적된 값이 A이고 A-K가 B라고 하자.
            //    B에 해당하는 경우가 있는 경우(즉, map에 value가 있는 경우)만큼 곧, K가 될 수 있음을 의미한다.
            //    왜냐하면, 지금 i까지 더한 누적합에서 B가 되는 index가 j라고 하면 sum[i] - sum[j] = K가 되기 때문이다.
            //    즉, 갯수를 구하려면 map의 value만큼이다.
            if(map.containsKey(sum[i] - K)) {
                answer += map.get(sum[i] - K);
            }

            // 2. 누적합을 map에 추가해준다.
            if (map.containsKey(sum[i])) {
                map.put(sum[i], map.get(sum[i]) + 1);
            } else {
                map.put(sum[i], 1L);
            }
        }

        System.out.println(answer);
    }
}