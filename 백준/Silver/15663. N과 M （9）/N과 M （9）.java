import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int num[];
	static boolean visited[];
	static int answer[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		answer = new int[M];

		perm(0);

		System.out.println(sb.toString());
	}

	private static void perm(int cnt) {
		if (cnt == M) {
//			System.out.println(Arrays.toString(answer));
			for (int i = 0; i < answer.length; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int before = -1;
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			if (before != num[i]) {
				before = num[i];
				visited[i] = true;
				answer[cnt] = num[i];
				perm(cnt + 1);
				visited[i] = false;
			}
		}

	}

}