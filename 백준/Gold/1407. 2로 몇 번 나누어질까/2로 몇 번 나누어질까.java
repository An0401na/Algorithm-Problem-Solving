import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A;
    static long B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(twoCount(B) - twoCount(A-1));
    }

    private static long twoCount(long n) {
        long result = 0;
        long divisor = 1;
        while (n > 0){
            long indivisibleNumberCnt = (long) Math.ceil((double) n / 2); // 2, 4, 8, 16 ... 으로 나누어 지지 않는 숫자의 개수
            result += divisor*indivisibleNumberCnt;
            n -= indivisibleNumberCnt; // 나누어떨어지지 않는 숫자들의 가장 큰 거듭제곱 약수를 구했으니 개수만큼 빼준다.
            divisor *= 2;
            /** 2로 나누어지지 않는 숫자들은 가장 큰 2의 거듭제곱  약수가 2^0 = 1 이걸 나눠 지지 않는 숫자들 개수만큼 더함
             *  4로 나누어지지 않는 숫자들은 가장 큰 2의 거듭제곱  약수가 2^1 = 2이걸 나눠 지지 않는 숫자들 개수만큼 더함
             * ...
             */
        }
        return result;
    }
}
/**
 * 2^10 = 1000
 * 2^20 = 100만
 * 2^30 = 10억
 */