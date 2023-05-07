import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.MathContext;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int num[];
	static boolean visited[];
	static int answer[];
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		visited = new boolean[N];
		answer = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		perm(0);
		
		System.out.println(max);
		
	}
	static void perm(int cnt) {
		if(cnt == N) {
			max= Math.max(max, cal());
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			answer[cnt] = num[i];
			perm(cnt+1);
			visited[i] = false;
			
		}
	}
	private static int cal() {
		int sum = 0;
		for (int i = 1; i < N; i++) {
			sum+= Math.abs(answer[i-1]-answer[i]);
		}
		return sum;
	}

}