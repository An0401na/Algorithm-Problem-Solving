import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int R; 
	static int C;
	static int min;
	static int [][] map;
	static int [][] cost;
	static boolean [][] visited;
	static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
	static class Edge implements Comparable<Edge>{
		int r;
		int c;
		int w;
		public Edge(int r, int c, int w)  {
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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken()); 
		map = new int[R][C];
		cost = new int[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i <R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j)-'0';
			}	
		}
		
		initCost();
		cost[0][0] = 0;
		
		dijkstra();
		
		System.out.println(cost[R-1][C-1]);
		
	}

	static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0, 0));
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			visited[now.r][now.c] = true;
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dir[d][0];
				int nc = now.c + dir[d][1];
				if(isRange(nr,nc) && cost[nr][nc] > cost[now.r][now.c]+map[nr][nc]) {
					cost[nr][nc] = cost[now.r][now.c]+map[nr][nc];
					pq.add(new Edge(nr, nc, cost[nr][nc]));
				}
				
			}
			
		}
		
	}

	static boolean isRange(int nr, int nc) {
		return nr>= 0 && nc>=0 && nr <R && nc <C;
	}

	static void initCost() {
		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost[i].length; j++) {
				cost[i][j]= INF;
			}
			
		}
		
	}

}