import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int w;
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
		}
		
		
	}

	static int N; //지도의 세로
	static int M; //지도의 가로
	static int[][] map;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static int[] p;
	static int[] r;
	static int min;
 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) {
					bfs(i,j,count);
					count++;
				}
			}
		}
		p = new int[count+1];
		r = new int[count+1];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] !=0 ) {
					// 오른쪽으로 탐색
					int r =i;
					int c =j+1;
					int cnt =0;
					while (isRange(r,c) && map[r][c] ==0) {
						cnt++;
						c++;
					}
					if(!isRange(r,c)) {
						cnt =0;
					}
					if(cnt > 1) {
						pq.offer(new Edge(map[i][j], map[r][c], cnt));
					}
					// 아래쪽으로 탐색
					 r =i+1;
					 c =j;
					 cnt =0;
					while (isRange(r,c) && map[r][c] ==0) {
						cnt++;
						r++;
					}
					if(!isRange(r,c)) {
						cnt =0;
					}
					if(cnt > 1) {
						pq.offer(new Edge(map[i][j], map[r][c], cnt));
					}
				}
			}
		}
	
		
		makeSet(count+1);
		int cnt =0;
		min =0;
		
		while(cnt != count-3) {
			if(pq.isEmpty()) {
				min = -1;
				break;
			}
			Edge e = pq.poll();
			if(union(e.s, e.e)) {
				cnt++;
				min+=e.w;
			}
			
		}
		System.out.println(min);
		
	}
	 static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		
		if(r[x] < r[y]) {
			r[y] += r[x];
			p[x] = y;
		}else {
			r[x] += r[y];
			p[y] = x;
		}
		return true;
	}
	 
	static int find(int x) {
		if(x == p[x]) return x;
		else return p[x] = find(p[x]);
	}
	
	static void makeSet(int c) {
		 for (int i = 2; i <c ; i++) {
			p[i] = i;
			r[i] = 1;
		}
		
	}
	static void printmap() {
		System.out.println("==============");
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("==============");
		
	}
	static void bfs(int r, int c,int count) {
		map[r][c] = count;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		while (!q.isEmpty()) {
			int n[] = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr= n[0] + dir[d][0];
				int nc= n[1] + dir[d][1];
				
				if(isRange(nr, nc) && map[nr][nc] == 1) {
					map[nr][nc] = count;
					q.add(new int[] {nr,nc});
				}
			}
		}
		
		
		
	}
	static boolean isRange(int nr, int nc) {
		return nr >=0 && nc >= 0 && nr < N && nc < M;
	}

}