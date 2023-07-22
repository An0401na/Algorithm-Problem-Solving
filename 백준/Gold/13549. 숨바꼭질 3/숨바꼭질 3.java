import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int current;
		int time; 
		
		public Point(int current, int t) {
			this. current = current;
			this.time = t;
		}
	}
	static int N;
	static int K;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		
		visited[N] = true;
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(N, 0));
		
		while (!q.isEmpty()) {
			int size = q.size();
			for(int i =0; i < size; i++) {
				Point p  = q.poll();
				
				if(p.current == K) {
					System.out.println(p.time);
					return;
				}
				
				int n = p.current;
				if(isInRange(2*n) && !visited[2*n]) {
					q.add(new Point(2*n, p.time));
					visited[2*n] = true;
					
				}
				if(isInRange(n-1) && !visited[n-1]) {
					q.add(new Point(n-1, p.time+1));
					visited[n-1] = true;			
				}
				
				if(isInRange(n+1) && !visited[n+1]) {
					q.add(new Point(n+1, p.time+1));
					visited[n+1] = true;					
				}
				
				
				
			}
		}
		
 		
	}
	private static boolean isInRange(int x) {
		return x >=0 && x <=100000;
	}
	

}