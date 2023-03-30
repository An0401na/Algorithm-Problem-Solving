import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int Originmap[][];
	static ArrayList<Point> zero;
	static Queue<Point> q;
	static ArrayList<Point> two;
	static int count;
	static int dir [][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Originmap = new int[N][M];
		zero = new ArrayList<>();
		two = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Originmap[i][j] = Integer.parseInt(st.nextToken());
				if(Originmap[i][j] == 0 ) {
					zero.add(new Point(i, j));
				}else if(Originmap[i][j] == 2) {
					two.add(new Point(i, j));
				}
				
			}
		}
		

		int maxZero=0;
		int[][] map =new int[N][M];
		for (int i = 0; i < zero.size()-2; i++) {
			for (int j = i+1; j < zero.size()-1; j++) {
				for (int k = j+1 ; k < zero.size(); k++) {
					
					for (int l = 0 ; l < N; l++) {
						map[l] = Arrays.copyOf(Originmap[l], M);
					}
					map[zero.get(i).r][zero.get(i).c]=1;
					map[zero.get(j).r][zero.get(j).c]=1;
					map[zero.get(k).r][zero.get(k).c]=1;
					q = new LinkedList<>();
					for (int k2 = 0; k2 < two.size(); k2++) {
						q.add(two.get(k2));
					}
					while (!q.isEmpty()) {
						Point p = q.poll();
						for (int n = 0; n < 4; n++) {
							int nr = p.r+ dir[n][0];
							int nc = p.c +dir[n][1];
							if(isInRange(nr, nc) && map[nr][nc] ==0) {
								map[nr][nc] = 3;
								q.add(new Point(nr, nc));
							}
							
						}
					}
					count=0;
					for (int l = 0; l < N; l++) {
						for (int l2 = 0; l2 < M; l2++) {
							if(map[l][l2] == 0) {
								count++;
							}
							
						}
						
					}
					maxZero = Math.max(maxZero, count);

				}
			}
		}
		System.out.println(maxZero);
	}
	static boolean isInRange(int nr, int nc) {
		return nr >= 0 && nc >=0 && nr <N && nc < M;
	}

}