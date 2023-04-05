
import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N;
	static double E;
	static int[] points_X;
	static int[] points_Y;
	static boolean check[];
	static double min;
	static int p[];
	static int r[] ;
	static PriorityQueue<Edge> edges;
	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		double w;
		public Edge(int v1, int v2) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			getW();
		}
		private void getW() {
			this.w = E*(Math.pow((points_X[v1] - points_X[v2]),2)+Math.pow(points_Y[v1] - points_Y[v2],2));
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			points_X = new int[N];
			points_Y = new int[N];
			check = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				points_X[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				points_Y[i] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
		
			edges = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					edges.offer(new Edge(i, j));
				}
			}
			
			p = new int[N];
			r = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
				r[i] = 1;
			}
			
			int cnt =0;
			min = 0;
			while (cnt != N-1) {
				Edge e = edges.poll();
				if(union(e.v1, e.v2)) {
					cnt++;
					min += e.w;
				}
			}
			
			
			System.out.printf("#%d %d\n", t,Math.round(min));
		}
		
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		
		if(r[x] > r[y]) {
			r[x] += r[y];
			p[y] = x;
		}else {
			r[y] += r[x];
			p[x] = y;
		}
		return true;
	}

	static int find(int x) {
		if(x == p[x]) return x;
		return p[x] = find(p[x]);
	}


}
