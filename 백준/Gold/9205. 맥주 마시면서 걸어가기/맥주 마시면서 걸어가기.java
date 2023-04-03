import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int T;
	static int N;
	static ArrayList<Point> points;
	static int D[][];
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
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			points = new ArrayList<>();
			for (int i = 0; i < N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				points.add(new Point(x, y));
			}
			
			D = new int[N+2][N+2];
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					D[i][j] = INF;
				}
			}
			
			
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					int dis_x = Math.abs(points.get(i).x - points.get(j).x);
					int dis_y = Math.abs(points.get(i).y - points.get(j).y);
					if((dis_x + dis_y) > 1000) {
						D[i][j] = INF;
					}else {
						D[i][j] = (dis_x + dis_y);
					}
				}
			}
			
//			for (int i = 0; i < N+2; i++) {
//				for (int j = 0; j < N+2; j++) {
//					if(D[i][j] == INF) {
//						System.out.print("INF ");
//						continue;
//					}
//					System.out.print(D[i][j] +" ");
//				}
//				System.out.println();
//			}
			
			for (int waypoint = 0; waypoint < N+2; waypoint++) {
				for (int start = 0; start < N+2; start++) {
					for (int end = 0; end < N+2; end++) {
						if(D[start][waypoint] == INF || D[waypoint][end] == INF ) continue;
						D[start][end] = Math.min(D[start][end], D[start][waypoint]+D[waypoint][end]);
					}
				}
			}
//			System.out.println("=====================");
//			for (int i = 0; i < N+2; i++) {
//				for (int j = 0; j < N+2; j++) {
//					if(D[i][j] == INF) {
//						System.out.print("INF ");
//						continue;
//					}
//					System.out.print(D[i][j] +" ");
//				}
//				System.out.println();
//			}
		
			
			if(D[0][N+1] == INF) {
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}
		}
	}

}