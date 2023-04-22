import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int num[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[M];
		sb = new StringBuilder();
		perm(0, 1);
		System.out.println(sb.toString());

	}

	private static void perm(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			num[cnt] = i;
			perm(cnt + 1, i);
		}
	}

}