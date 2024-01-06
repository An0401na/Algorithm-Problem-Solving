import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int A;
    static int B;
    static int D;

    static boolean isPrime[];
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        isPrime = new boolean[4000001];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

//        for (int i = 2; i <= B; i++) {
//            if(!isPrime[i]) continue;
//            if(A <= i && hasD(i)) {
//                System.out.println("소수 : "+i);
//                cnt++;
//            }
//            int idx = i*i;
//            while (0 < idx && idx  <= B){
//                isPrime[idx] = false;
//                idx += i;
//            }
//        }

        for (int i = 2; i * i<= 4000000; i++) {
            if(!isPrime[i]) continue;
            for (int j = i*i; j <= 4000000 ; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = A; i <=B ; i++) {
            if(isPrime[i] && hasD(i)){
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    private static boolean hasD(int i) {
        while (i > 0){
            int n = i % 10;
            if(n == D){
                return true;
            }
            i /= 10;
        }
        return false;
    }
}