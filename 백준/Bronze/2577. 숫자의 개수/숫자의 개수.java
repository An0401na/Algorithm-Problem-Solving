import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long A;
    static long B;
    static long C;
    static int cnt[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Long.parseLong(br.readLine());
        B = Long.parseLong(br.readLine());
        C = Long.parseLong(br.readLine());

        long num = A * B * C;

        cnt = new int[10];
        while(num != 0){
            int mod = (int) (num % 10);

            cnt[mod] ++;

            num = num / 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(cnt[i]);
        }
    }
}