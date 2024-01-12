import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static long T;
    static int n;
    static int m;
    static long sumA[]; //배열 A의 누적합
    static long sumB[]; //배열 B의 누적합
    static HashMap<Long, Long> mapA; // 배열 A의 부분합 모음
    static HashMap<Long, Long> mapB; // 배열 B의 부분합 모음
    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Long.parseLong(br.readLine());

        n = Integer.parseInt(br.readLine());

        // 배열 A에서 누적합 구하면서 가능한 부분합의 개수 구하기
        sumA = new long[n+1];
        mapA = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= n; j++) {

            sumA[j] = sumA[j-1]+Long.parseLong(st.nextToken());

            for (int i = 0; i < j ; i++) {
                // 배열 A에서 i~j의 부분합을 키로 가지는 map이 있다면 그값을 반환해서 +1하고
                // 없다면 0(default)를 반환해서 +1 해라.
                mapA.put(sumA[j]-sumA[i], mapA.getOrDefault(sumA[j]-sumA[i], 0L)+1);
            }
        }


        // 배열 A에서 누적합 구하면서 가능한 부분합의 개수 구하기
        m = Integer.parseInt(br.readLine());
        sumB = new long[m+1];
        mapB = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= m; j++) {

            sumB[j] = sumB[j-1]+Long.parseLong(st.nextToken());

            for (int i = 0; i < j; i++) {
                // 배열 B에서 i~j의 부분합을 키로 가지는 map이 있다면 그값을 반환해서 +1하고
                // 없다면 0(default)를 반환해서 +1 해라.
                mapB.put(sumB[j]-sumB[i], mapB.getOrDefault(sumB[j]-sumB[i], 0L)+1);
            }
        }


        // mapA 키 순회

        for (long key : mapA.keySet()) {
            // mapB에 T-(map의 key(부분합))을 key로 가진다면
            if(mapB.containsKey(T-key)){
                cnt += mapA.get(key) * mapB.get(T-key);
            }
        }

        System.out.println(cnt);

    }
}