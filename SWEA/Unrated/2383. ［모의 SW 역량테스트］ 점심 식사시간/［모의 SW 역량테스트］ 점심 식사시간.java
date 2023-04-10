import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N;
	static int map[][];
	static boolean choice[];
	static Point stairs[];
	static int minTime;
	static int resultTime;
	static ArrayList<Point> person;
	static int dir[][] = {{1,0}, {-1,0},{0,1},{0,-1}};
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			stairs = new Point[2];
			person = new ArrayList<>();
			int s = 0;
			int k = 1;
			for (int i = 0; i <N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if(map[i][j] > 1) {
						stairs[s++] = new Point(i, j);
						map[i][j] = map[i][j]*-1;
					}
					if(map[i][j] == 1) {
						map[i][j] = k;
						k++;
						person.add(new Point(i,j));
					}
				}
			}
			choice = new boolean[person.size()];
			minTime = Integer.MAX_VALUE;
			subset(0);
			minTime = Math.min(minTime, resultTime);
			
			System.out.printf("#%d %d\n", t, minTime);
		}
		
	}

	static void subset(int cnt) {
		if(cnt == choice.length) {
			//계산하기
			int case0 = getTimeStair(0);
			int case1 = getTimeStair(1);
			resultTime = Math.max(case0, case1);
			minTime = Math.min(minTime, resultTime);
			return;
		}
		
		choice[cnt] = true;
		subset(cnt+1);
		
		choice[cnt] = false;
		subset(cnt+1);
	}

	
	static int getTimeStair(int stair) {
		int time =0;
		int pcount =0;
		boolean isChoice;
		if(stair ==0) {
			isChoice = true;
		}else isChoice=false;
		for (int i = 0; i < choice.length; i++) {
			if(choice[i] == isChoice) {
				pcount++;
			}
		}
		
		
		if(pcount ==0) return 0;
		boolean visited[][] = new boolean[N][N];
		ArrayList<int[]> state = new ArrayList<>();
		Queue<Point> q = new LinkedList<>();
		q.add(stairs[stair]);
		visited[stairs[stair].r][stairs[stair].c] = true;
		
		
		int clearCnt =0;
		while (true) {
			time ++;
			if(clearCnt >= pcount) {
				break;
			}

			//계단에 내려가는 중인 사람들 옮기기
			if(state.size() > 3) { //한 계단에 3명이 이미 내려가고 있는 경우
				for (int i = 0; i < 3; i++) {
					if(i+1 == state.size()) {
						break;
					}
					state.get(i)[1]--;
					if(state.get(i)[1] ==0) {
						clearCnt++;
						state.remove(i);
						
						i--;
					}
				}
			}else { //계단에 3명 미만이 내려가고 있는 경우
				for (int i = 0; i < state.size(); i++) {
					state.get(i)[1]--;
					if(state.get(i)[1] ==0) {
						clearCnt++;
						state.remove(i);
						i--;
					}
				}
			}
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int j = 0; j < 4; j++) {
					int nr = p.r + dir[j][0];
					int nc = p.c + dir[j][1];
					if(isInRange(nr,nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						if(map[nr][nc]>=1 && choice[map[nr][nc]-1] == isChoice ) {
							state.add(new int[] {map[nr][nc]-1, Math.abs(map[stairs[stair].r][stairs[stair].c])});
						}
						q.add(new Point(nr, nc));
					}
				}
			}
		}
		return time;
	}

	private static boolean isInRange(int nr, int nc) {
		return nr >=0 && nc >= 0 && nr < N && nc < N;
	}

}