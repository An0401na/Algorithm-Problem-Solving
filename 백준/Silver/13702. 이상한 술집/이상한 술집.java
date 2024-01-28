import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 주문한 막걸리 개수
    static int K; // 사람수
    static int mack[]; // 막걸리 용량
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        mack = new int[N];

        for (int i = 0; i < N; i++) {
            mack[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, mack[i]);
        }

        long start = 0;
        long end = max;
        long ans = max;

        while(start <= end){
            long mid = (start + end) / 2;
            if( mid !=0 && ok(mid)){
                start = mid +1;
                ans = mid;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(ans);

    }

    private static boolean ok(long x) { // 용량 x 로 막걸리를 나눴을 때 K명에게 나눌 수 있는지 확인
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += mack[i]/x;
        }
        if(total >= K) return true;
        return false;
    }
}