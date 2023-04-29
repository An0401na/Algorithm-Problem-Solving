import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int input[];
	static boolean visited[];
	static int output[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		combi(0, 0);
		
	}
	static void combi(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < input.length; i++) {
				if(visited[i]) {
					System.out.print(input[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		
		
		for (int i = start; i < input.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			combi(cnt+1, i+1);
			visited[i] = false;
		}
		
	}

}