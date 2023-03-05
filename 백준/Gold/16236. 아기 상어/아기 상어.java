import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static Fish babyShark; // r, c, size 상어의 기본 크기는 2
	static int time;
	static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
	static int fishcnt;
	static ArrayList<Fish> fishes;
	static int cnt;
	static int t;
	static class Fish{
		int r;
		int c;
		int size;
		
		public Fish(int r, int c, int size) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", size=" + size + "]";
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		fishcnt = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					if(map[i][j] ==9) {
						babyShark = new Fish(i, j, 2);
					}else {
						fishcnt++;
					}
				}
			}
		}
		
		// =========================입력
		
		time = 0;
		while (fishcnt != 0) {
			int r = babyShark.r;
			int c = babyShark.c;
			search();
//			printmap();
			if(r == babyShark.r && c == babyShark.c) {
				break;
			}
			time += t;
//			System.out.println("time : "+ time);
		}

		System.out.println(time);
		
		

	}
	
	static void printmap() {
		System.out.println("============================");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	//저장된 물고기들 중 상어보다 사이즈가 작고 거리가 가장 가까운 물고기를 찾음
	static void search() {
		t = 0;
		fishes = new ArrayList<>(); //같은 거리에 있는 물고기들의 모음
		Queue<int[]> q = new LinkedList<>(); //상어가 움직일 수 있는 좌표들을 넣음
		boolean visited[][] = new boolean[N][N];
		q.add(new int [] {babyShark.r, babyShark.c});
		visited[babyShark.r][babyShark.c] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			t++; //하나의 물고기를 찾고 먹는데 걸리는 시간
			for (int s = 0; s <size; s++) {
				int n [] = q.poll();
//				visited[n[0]][n[1]]= true;
				for (int d = 0; d < 4; d++) {
					int nr = n[0] + dir[d][0];
					int nc = n[1] + dir[d][1];
					if(isRange(nr, nc) && !visited[nr][nc]) {
						if(map[nr][nc] <= babyShark.size) {
							visited[nr][nc]= true;
							q.add(new int[] {nr, nc});
							if(map[nr][nc] != 0 && map[nr][nc] < babyShark.size) { //먹을 수 있는 물고기면
								fishes.add(new Fish(nr, nc, map[nr][nc]));
							}
						}
					}
				}
			}
			if(fishes.size() > 0) {
				for (int i = 0; i < fishes.size(); i++) {
//					System.out.println(fishes.get(i).toString());
				}
				Fish f = fishes.get(0);
				for (int i = 1; i < fishes.size(); i++) {
					if(f.r > fishes.get(i).r) {
						f = fishes.get(i);
					}else if (f.r == fishes.get(i).r) {
						if(f.c > fishes.get(i).c) {
							f = fishes.get(i);
						}
					}
				}
				map[f.r][f.c] = 0; //물고기 먹힘
				map[babyShark.r][babyShark.c] = 0; //전에 있던 상어 자리
				//상어의 위치를 물고기 먹은 위치로 이동
				babyShark.r = f.r;
				babyShark.c = f.c;
				//현재 상어자리에 상어 표시
				map[f.r][f.c] = 9;
				
				fishcnt--;
				cnt++;
				if (cnt == babyShark.size) { //물고기를 먹은 개수가 상어의 크기와 같아변
					babyShark.size++; //크기 증가
					cnt= 0;
				}
				return;
			}
		}
	}
	
	

	static boolean isRange(int nr, int nc) {
		return nr>=0 && nc >= 0 && nr < N && nc < N;
	}
}
/*
 * 상어보다 큰 물고기는 지나갈 수 없고
 * 같으면 지나갈 순 있고
 * 작으면 먹을 수 잇다.
 *  
 *  가장 가까운 물고기를 먹기
 *  칸의 최소값으으로 판별
 *  거리가 가까운 물고기 -> 가장 위에 있는 물고기 -> 가장 왼쪽에 있는 물고기
 *  자신의 크기와 같은 수의 물고기를 먹을때마다 크기가 1증가
 *  
 *  //아기상어가 공간에 있는 물고기를 다 먹는데 걸리는 시간
 */