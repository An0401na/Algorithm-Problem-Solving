import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static long k;
    static long cnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Long.parseLong(br.readLine());

        StringBuffer sb = new StringBuffer();

        for (long i = 2; i * i <= k; i++) {
            while (k % i == 0){
                sb.append(i+" ");
                k /= i;
                cnt++;
            }
        }
        if (k != 1){
            sb.append(k);
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

}