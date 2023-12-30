import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BigInteger n;
    static BigInteger m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = new BigInteger(st.nextToken());
        m  = new BigInteger(st.nextToken());

        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));


    }
}