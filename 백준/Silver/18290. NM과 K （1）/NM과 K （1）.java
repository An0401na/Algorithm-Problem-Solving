import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int K;
	static int map[][];
	static boolean visited[][];
	static int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				visited[i][j] = true;
				for (int k = 0; k < 4; k++) {
					int nr = i + dir[k][0];
					int nc = j + dir[k][1];
					if(isInRange(nr, nc))
						visited[nr][nc] = true;			
				}
//				System.out.println();
//				System.out.println();
//				System.out.println(i+", "+j+" => "+map[i][j]);
//				for (int n = 0; n < N; n++) {
//					System.out.println(Arrays.toString(visited[n]));
//				}
				dfs(i,j,1, map[i][j]);
				for (int k = 0; k < 4; k++) {
					int nr = i + dir[k][0];
					int nc = j + dir[k][1];
					if(isInRange(nr, nc))
						visited[nr][nc] = false;			
				}
				visited[i][j] = false;
			}
		}
		
		System.out.println(max);
		
	}
	static void dfs(int r, int c, int cnt, int sum) {
		if(cnt == K) {
			max = Integer.max(max, sum);
			return;
		}
//		System.out.println(r + " /// "+ c);
		
		for (int i = r; i < N; i++) {
			for (int j = 0; j < M; j++) {
//				System.out.println("탐색한 i, j => "+i+", "+j);
				if(visited[i][j]) continue;
				visited[i][j] = true;
				ArrayList<int[]> changeTrue = new ArrayList<>();
				for (int n = 0; n < 4; n++) {
					int nr = i + dir[n][0];
					int nc = j + dir[n][1];
					if(isInRange(nr, nc) && visited[nr][nc] == false) {
						visited[nr][nc] = true;
						changeTrue.add(new int[] {nr,nc});
					}
				}
//				System.out.println("========= cnt : "+ cnt +" / sum : "+sum+"============");
//				System.out.println(i+", "+j+" => "+map[i][j]);
//				for (int n = 0; n < N; n++) {
//					System.out.println(Arrays.toString(visited[n]));
//				}
				
				dfs(i, j, cnt+1, sum + map[i][j]);
				for (int k = 0; k < changeTrue.size(); k++) {
					int n[] = changeTrue.get(k);
					visited[n[0]][n[1]] = false;
				}
				visited[i][j] = false;
			}
			
		}
		
	}

	static boolean isInRange(int nr, int nc) {
		return nr >=0 && nc >=0 && nr < N && nc < M;
	}
}