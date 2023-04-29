import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int input[];
	static int output[];
	static StringBuffer sb ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		output = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		sb = new StringBuffer();
		combi(0, 0);
		System.out.println(sb.toString());

	}

	static void combi(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < output.length; i++) {
				sb.append(output[i]).append(" ");
		
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < input.length; i++) {
			output[cnt] = input[i];
			combi(cnt + 1, i );
		}

	}

}