import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N;
	static boolean visited[];
	static Point[] points;
	static Point home;
	static int result;
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			points = new Point[N+1];
			visited = new boolean[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[0] = new Point(x, y);
			

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			home = new Point(x, y);
			
			for (int i = 1; i < N+1; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				points[i] = new Point(x, y);
			}
			
			result = Integer.MAX_VALUE;
			visited[0] =true;
			dfs(0, 0, 0);
			System.out.printf("#%d %d\n", t, result);
			
		}
		
	}
	static void dfs(int cnt, int tot, int pre) {
		if(tot >= result) return;
		if(cnt == N) {
			result = Math.min(result, tot+get(points[pre], home));
			return;
		}
		
		for (int i = 0; i < N+1; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(cnt+1, tot + get(points[pre], points[i]), i);
			visited[i] = false;
		}
		
	}
	static int get(Point s, Point e) {
		return Math.abs(s.x - e.x) + Math.abs(s.y - e.y);
	}

}