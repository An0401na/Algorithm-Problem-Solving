import java.io.*;
import java.util.*;

public class Main {
	static int R;
	static int C;
	static int[][] map;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우
	static int[][] copy;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		copy = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt=-1;
		while(true) {
			cnt++;
			for (int i = 0; i < R; i++) {
				System.arraycopy(map[i], 0, copy[i], 0, C);
			}
			bfs();
//			System.out.println("======map");
//			print();
//			System.out.println("======copy");
//			print_copy();
			int count =0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					count=0;
					if(copy[i][j] ==1) {
						for (int j2 = 0; j2 <4; j2++) {
							int nr = i+dir[j2][0];
							int nc = j+dir[j2][1];
							if(copy[nr][nc]==2) {
								count++;
//								copy[i][j]=3;
								if(count>=2) {
									map[i][j]=0;
									break;
								}
							}
						}
						
					}
				}	
			}
			
			boolean flag=false;
			Loop1 : for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(copy[i][j]==1) {
						flag=true;
						break Loop1;
					}
				}	
			}
			
			if(!flag) {
				break;
			}
		}
		
		System.out.println(cnt);
		
		
	}

	static void bfs() {
		Queue<int []> q = new LinkedList<>();
		int[]n = {0,0};
		q.add(n);
		
		while (!q.isEmpty()) {
			n = q.poll();
			for (int i = 0; i < dir.length; i++) {
				int nr = n[0] + dir[i][0];
				int nc = n[1] + dir[i][1];
				
				boolean isRange = nr >=0 && nc>=00 && nr < R && nc < C;
				
				if(isRange)
					if( copy[nr][nc] == 0) {
						copy[nr][nc] = 2;
						int [] new_n = {nr, nc};
						q.add(new_n);
					}
				}
			
		}
	}
	private static void print_copy() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(copy[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}