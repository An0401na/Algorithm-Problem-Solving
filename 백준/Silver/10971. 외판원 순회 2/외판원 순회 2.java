import java.io.*;
import java.util.*;;

public class Main {
	static int N;
	static int[][] matrix;
	static int cost;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cost = Integer.MAX_VALUE;
		visited = new boolean[N];
		visited[0]=true;
		dfs(0,0,0);
		System.out.println(cost);
		
	}
	static void dfs(int cnt, int now, int tot) {
		if(tot >= cost) {
			return;
		}
		if(cnt == N-1) {
			if(matrix[now][0]!=0) {
				tot += matrix[now][0];
				cost = Math.min(cost, tot);
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			if(matrix[now][i]!=0) {
				visited[i] = true;
				dfs(cnt+1, i, tot+matrix[now][i]);
				visited[i] = false;
			}
		}
	}

}