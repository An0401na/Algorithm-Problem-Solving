import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {

            String str[] = br.readLine().split(" ");

            num = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

            int max = 0;
            for (int j = 0; j < num.length-1; j++) {
                for (int k = j+1; k < num.length; k++) {
                    int a = Math.max(num[j], num[k]);
                    int b = Math.min(num[j], num[k]);

                    int gcd = getGCD(a, b);

                    max = max < gcd ? gcd : max;
                }
            }
            System.out.println(max);

        }

    }

    private static int getGCD(int a, int b) {
        if(b == 0) return a;
        return getGCD(b, a%b);
    }
}