import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	// nCm = n! / m!(n-m)!
	static int n;
	static int m;
	static BigInteger memo[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

//		if(m < n/2) {
//			m = n-m;
//		}

		memo = new BigInteger[n + 1];

		memo[0] = new BigInteger("1");
		memo[1] = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			String str = Integer.toString(i);
			BigInteger n = new BigInteger(str);
			memo[i] = memo[i - 1].multiply(n);
		}
		BigInteger result = memo[m].multiply(memo[n-m]);
		result = memo[n].divide(result);
		System.out.println(result);
	}
}