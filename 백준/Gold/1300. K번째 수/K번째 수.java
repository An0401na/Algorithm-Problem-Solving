import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long start = 1;
        long end = (long) Math.pow(N, 2);
        long answer = -1;
        while (start <= end){

            long mid = (start + end)/2;

            long cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, mid/i);
            }

            if(cnt < K){
                start = mid +1;
            }else{
                end = mid -1;
                answer = mid;
            }

        }

        System.out.println(answer);
    }
}