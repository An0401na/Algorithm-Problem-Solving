import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int map[][];
	static int dp[][];	
	static int candy;
	static int dir[][] = {{1,0},{0,1},{1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.fill(dp[i], -1);
		}
		
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		dp[0][0] = map[0][0];
		
		while (!q.isEmpty()) {
			int n[] = q.poll();
			
			for (int i = 0; i < dir.length; i++) {
				int nr = n[0] + dir[i][0];
				int nc = n[1] + dir[i][1];
				
				if(isRange(nr, nc)) {
					if(dp[nr][nc] == -1) {
						q.add(new int[] {nr, nc});
					}
					if(dp[nr][nc] < dp[n[0]][n[1]]+map[nr][nc]) {
						dp[nr][nc] = dp[n[0]][n[1]]+map[nr][nc];
					}
				}	
			}
			
//			System.out.println("====="+n[0]+", "+n[1]+"======");
//
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(dp[i]));
//			}
			
		}
		
		
		System.out.println(dp[N-1][M-1]);
	}
	
	static boolean isRange(int nr, int nc) {
		return nr >=0 && nc >= 0 && nr < N && nc < M;
	}

}