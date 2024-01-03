import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());

        if(N == 0 || N == 1) {
            System.out.println(0);
            return;
        }

        int result = 0;
        int divisor = A;
        while (divisor <= N){
            if(N / divisor >= 1){
                result += N/divisor;
                divisor *= A;
            }else{
                break;
            }
        }

        System.out.println(result);
    }
}