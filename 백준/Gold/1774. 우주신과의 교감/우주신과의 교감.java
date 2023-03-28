import java.io.*;
import java.util.*;

public class Main {
	static int N; //정점의 개수
	static int M; //간선의 개수
	static Point points[];
	static PriorityQueue<Edge> edges;
	static int p[];
	static int r[];
	static double length;
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}	
	}

	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		double w;
		
		public Edge(int v1, int v2, double w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;

		}

		@Override
		public String toString() {
			return "Edge [v1=" + v1 + ", v2=" + v2 + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		r = new int[N+1];
		makeSet();
		
		points = new Point[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			points[i] = new Point(x, y);
		}
		
		edges = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			double w = Math.sqrt(Math.pow((points[v1].x-points[v2].x), 2) + Math.pow((points[v1].y-points[v2].y), 2));

			edges.offer(new Edge(v1, v2, w));
		}
		
		//connected를 통해서 이미 존재하는 통로들 중 최단거리고 연결할 수 있는거 다 연결
		while (!edges.isEmpty()) {
			Edge edge = edges.poll();
			boolean temp = union(edge.v1, edge.v2);
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = i+1; j < N+1; j++) {
				double w = Math.sqrt(Math.pow((points[i].x-points[j].x), 2) + Math.pow((points[i].y-points[j].y), 2));;

				edges.offer(new Edge(i, j, w));
			}
		}
		while (true) {
			if(isAllConnected())break;
			Edge edge = edges.poll();
			if(union(edge.v1, edge.v2)) {
				length += edge.w;
			}
		}
		System.out.printf("%.2f",length);
//		System.out.printf("%.2f",Math.round(length*100)/100.0);
		
		
		
		
		
	}
	//모든 도시가 다 연결 됐는지 확인하는 함수
	static boolean isAllConnected() {
		int n = p[1];
		for (int i = 2; i < p.length; i++) {
			if(p[1]!=p[i]) {
				return false;
			}
		}
		return true;
	}
	static boolean union(int v1, int v2) {
		 v1 = findParent(v1);
		 v2 = findParent(v2);
		 if(v1 == v2 ) return false;
		 
		 if(r[v1] < r[v2]) {
			 r[v2] += r[v1];
			 p[v1] = v2;
		 }else {
			 r[v1] += r[v2];
			 p[v2] = v1;
		 }
		return true;
	}
	static int findParent(int v) {
		if(v == p[v]) return v;
		else return p[v] = findParent(p[v]);
	}
	static void makeSet() {
		 for (int i = 0; i < N+1; i++) {
			p[i] = i;
			r[i] = 1;
		}
		
	}
	
	
	

}