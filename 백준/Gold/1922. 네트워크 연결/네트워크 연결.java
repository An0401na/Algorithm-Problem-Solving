import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int v;
		int w;
		
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}	
	}
	
	
	static int N;
	static int M;
	static int min;
	static boolean[] checked;
	static ArrayList<Edge>[] adj; // 한 정점에서 다른 정점들과 연결된 리스트의 배열
	static PriorityQueue<Edge> pq;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
	
		adj = new ArrayList [N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(e, w));
			adj[e].add(new Edge(s, w));
		}
		checked = new boolean[N+1];
		pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		cnt = 0;
		min = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (checked[e.v]) continue;
			checked[e.v] = true;
			min += e.w;
			if(cnt == N-1) break;
			for (int i = 0; i <adj[e.v].size(); i++) {
				if(checked[adj[e.v].get(i).v]) continue;
				pq.offer(adj[e.v].get(i));
				
			}
		}
		
		
		System.out.println(min);
	}
}