
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
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
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
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			choice = new boolean[person.size()];
			minTime = Integer.MAX_VALUE;
			subset(0);
//			int num[]= {0,1,2,3};
//			for (int i = 0; i < num.length; i++) {
//				choice[num[i]] = true;
//			}
//			
//			
//			System.out.println("time : " +getTimeStair(0));
//			
//			System.out.println("time : " +getTimeStair(1));
			minTime = Math.min(minTime, resultTime);
			
			System.out.printf("#%d %d\n", t, minTime);
		}
		
	}

	static void subset(int cnt) {
		if(cnt == choice.length) {
			//계산하기
//			System.out.println(Arrays.toString(choice));
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
		
//		System.out.println("choice : "+Arrays.toString(choice)+" "+pcount);
		
		if(pcount ==0) return 0;
		boolean visited[][] = new boolean[N][N];
		ArrayList<int[]> state = new ArrayList<>();
		Queue<Point> q = new LinkedList<>();
		q.add(stairs[stair]);
		visited[stairs[stair].r][stairs[stair].c] = true;
		
//		System.out.println("계단 : " +stairs[stair].r+", "+stairs[stair].c);
		
		int clearCnt =0;
		while (true) {
			time ++;
//			System.out.println("========= time : "+time+" 분후 ==========");
//			System.out.println("완료된 사람 수 : "+ clearCnt );
			if(clearCnt >= pcount) {
				break;
			}

//			System.out.println("state >> ");
//			for (int i = 0; i < state.size(); i++) {
//				System.out.println(Arrays.toString(state.get(i)));
//			}
//			System.out.println("<<");
			
			//계단에 내려가는 중인 사람들 옮기기
			if(state.size() > 3) { //한 계단에 3명이 이미 내려가고 있는 경우
				for (int i = 0; i < 3; i++) {
//					System.out.println("i는 "+ i);
					if(i+1 == state.size()) {
						break;
					}
					state.get(i)[1]--;
//					System.out.println((state.get(i)[0]+1)+"번 사람이 "+state.get(i)[1]+"칸으로 내려가기 ");
					if(state.get(i)[1] ==0) {
						clearCnt++;
//						System.out.println((state.get(i)[0]+1)+"번 사람이 이동완료");
						state.remove(i);
						
//						System.out.println("제거후");
//						for (int j = 0; j < state.size(); j++) {
//							System.out.print(state.get(i).toString()+" ");
//						}
//						System.out.println();
						i--;
					}
				}
			}else { //계단에 3명 미만이 내려가고 있는 경우
				for (int i = 0; i < state.size(); i++) {
					state.get(i)[1]--;
//					System.out.println((state.get(i)[0]+1)+"번 사람이 "+state.get(i)[1]+"칸으로 내려가기 ");
					if(state.get(i)[1] ==0) {
						clearCnt++;
//						System.out.println((state.get(i)[0]+1)+"번 사람이 이동완료");
						state.remove(i);
						i--;
					}
				}
			}
			
			int size = q.size();
//			System.out.println("size : "+size);
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int j = 0; j < 4; j++) {
					int nr = p.r + dir[j][0];
					int nc = p.c + dir[j][1];
					if(isInRange(nr,nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						if(map[nr][nc]>=1 && choice[map[nr][nc]-1] == isChoice ) {
//							System.out.println("도달 : "+ nr+" "+nc+" "+Math.abs(map[stairs[stair].r][stairs[stair].c]));
//							System.out.println(map[nr][nc]+"번 사람이 "+(stair+1)+"번 계단 입구 도착");
							state.add(new int[] {map[nr][nc]-1, Math.abs(map[stairs[stair].r][stairs[stair].c])});
						}
						q.add(new Point(nr, nc));
					}
				}
			}
//			time ++;
		}
		return time;
	}

	private static boolean isInRange(int nr, int nc) {
		return nr >=0 && nc >= 0 && nr < N && nc < N;
	}

}
