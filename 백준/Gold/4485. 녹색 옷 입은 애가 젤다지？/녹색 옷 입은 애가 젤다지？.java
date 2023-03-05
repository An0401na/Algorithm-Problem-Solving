import java.io.*;
import java.util.*;


public class Main {
	static class Edge implements Comparable<Edge>{
		int r;
		int c;
		int w;
		public Edge(int r,int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] map;
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	static int[][] cost;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t =1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) {
				break;
			}
			map = new int[N][N];
			cost = new int [N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cost[i][j] = INF;
				}
			}
	
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cost[0][0] = map[0][0];

			
			// =============입력
			
			dijkstra();
			System.out.println("Problem "+(t++)+": "+cost[N-1][N-1]);
			
			
			
			
		}
	}
	static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0,0,map[0][0]));
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dir[d][0];
				int nc = now.c + dir[d][1];
				if(isRange(nr, nc) && cost[nr][nc] > cost[now.r][now.c] + map[nr][nc]) {
					cost[nr][nc] = cost[now.r][now.c] + map[nr][nc];
					pq.add(new Edge(nr, nc, cost[nr][nc]));
				}
			}
		}
		
	}
	
	static boolean isRange(int nr, int nc) {
		return nr >=0 && nc >=0 && nr < N && nc < N;
	}
	
	
}