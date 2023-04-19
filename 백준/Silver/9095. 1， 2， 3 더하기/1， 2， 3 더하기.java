import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int T;
	static int N;
	static int dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		dp = new int[11];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i < 11; i++) {
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		StringBuilder sb =new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb.toString());

	}

}