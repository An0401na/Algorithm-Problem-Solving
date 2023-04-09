import java.io.*;
import java.util.*;

import javax.xml.stream.util.EventReaderDelegate;

public class Main {
	//다익스트라 - 시작점에서 모든 정점까지의 최단거리
	//슈퍼컴퓨터 (1번컴퓨터)부터 모든 정점으로의 최단거리
	static int N;
	static int M;
	static ArrayList<Edge> [] adj;
	static int[] cost;
	static boolean checked[];
	static int[] result;
	static ArrayList<Edge> answer;
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int w;
		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList [N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		checked = new boolean[N+1];
		cost = new int[N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[a].add(new Edge(a, b, w));
			adj[b].add(new Edge(b, a, w));
		}
		
		result = new int[N+1];
		answer = new ArrayList<>();
		
		dijkstra();
//		System.out.println(Arrays.toString(result));
//		System.out.println(N-1);
		
		System.out.println(answer.size()-1);
		for (int i = 1; i < answer.size(); i++) {
			System.out.println(answer.get(i).s +" " + answer.get(i).e);
			
		}
	}
	
	
	static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		cost[1] =0;
//		checked[1] = true\;
		pq.add(new Edge(1, 1, 0));
//		int i =1;
		while (!pq.isEmpty()) {
//			System.out.println("===="+i+"====");
//			i++;
			
			Edge edge = pq.poll();
//			System.out.println(edge.toString());
			if(checked[edge.e]) continue;
			
			checked[edge.e] = true;
			answer.add(edge);

//			System.out.println("큐에 들어가는 것");
			for (Edge next : adj[edge.e]) {
				if(cost[next.e] > cost[edge.e] + next.w) {
					cost[next.e] = cost[edge.e] + next.w;
					Edge newdEdge = new Edge(next.s, next.e, cost[next.s]);
//					System.out.println(newdEdge.toString());
					pq.add(new Edge(next.s, next.e, cost[next.e]));
				}
			}
//			System.out.println();
			
		}

		
	}

}