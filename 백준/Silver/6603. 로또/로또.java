import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int S[];
	static int num[];
	static boolean visited[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			S = new int[k];
			num = new int[6];
			visited = new boolean[k];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			combi(0,0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void combi(int cnt, int start) {
		if(cnt == 6) {
			for (int i = 0; i <6; i++) {
				sb.append(num[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < k; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			num[cnt] = S[i];
			combi(cnt+1, i);
			visited[i] =false;
		}
	}

}