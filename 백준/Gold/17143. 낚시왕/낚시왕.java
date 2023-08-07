import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Shark{
		int r;
		int c;
		int s; //속력
		int d; //이동방향 1은 위, 2는 아래, 3은 오른쪽, 4는 왼쪽
		int z; //크기
		
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static int R; 
	static int C;
	static int M; // 상어 수 
	static List<Shark> sharks;
	static int dir[][] = {{0,0},{-1,0},{ 1,0}, {0,1},{0,-1}};
	static int sharkSum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharks = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			sharks.add( new Shark(r-1, c-1, s, d, z));
		}
		
		
		// 낚시왕 오른쪽으로 1열 이동
		for (int fisher = 0; fisher < C; fisher++) {
			
			// 낚시왕이 있는 열에서 땅이랑 가장 가까운 상어 잡기
			catchShark(fisher);
			
			
			// 상어 이동
			sharkMove();
			
			
			// 겹치는 상어 제거
			duplicateCheck();
		}
		
		System.out.println(sharkSum);
		
	}
	
	
	// 낚시왕이 있는 열에서 땅이랑 가장 가까운 상어 잡기
	static void catchShark(int fisher) {
		
		Shark caughtShark = new Shark(R, 0, 0, 0, 0);
		
		for (Shark s : sharks) { //모든 상어를 탐색하는데 
			if(s.c == fisher) { // 낚시왕과 같은 열에 있다면
				if(s.r < caughtShark.r) { // 땅과 가까운 상어를 찾음
					caughtShark = s;
					if(s.r == 0) break;
				}	
			}
		}
		
		sharkSum+= caughtShark.z;
		sharks.remove(caughtShark); // 잡힌 상어는 리스트에서 지움
		
	}
	
	

	// 상어 이동
	static void sharkMove() {
		for (Shark s : sharks) { 
			
			if(s.s ==0) continue; //속도가 0이면 이동하지 않음
			
			if(s.d == 1 || s.d == 2) { // 상하
				//이동한 r 값 정하기
				int divisorR = R*2 -2;
				int newr = (int)Math.abs(s.r + dir[s.d][0]*s.s) % divisorR;
				int ss = s.s % divisorR;
				
				//방향 정하기
				if(s.d == 1) { //-1 방향
					if(s.r < ss && ss <= s.r + R-1) { // 방향 바꿈
						s.d = 2;
					}
				}
				else { // 1방향
					if(R-1 - s.r < ss && ss <= R-1 - s.r + R-1) { // 방향 바꿈
						s.d = 1;
					}
				}
				s.r = newr;
				if(s.r >= R) s.r = divisorR - s.r;
				
				
			}else { // 좌우
				//이동한 C 값 정하기
				int divisorC = C*2 -2;
				int newc = (int)Math.abs(s.c + dir[s.d][1]*s.s) % divisorC;
				int ss = s.s % divisorC;
				
				//방향 정하기
				if(s.d == 4) { //-1 방향
					if(s.c <= ss && ss < s.c + C-1) { // 방향 바꿈
						s.d = 3;
					}
				}
				else { // 1방향
					if(C-1 - s.c < ss && ss <= C-1 - s.c + C-1) { // 방향 바꿈
						s.d = 4;
					}
				}
				s.c = newc;
				if(s.c >= C) s.c = divisorC - s.c;
				
			}
		}
	}



	
	
	// 겹치는 상어 제거
	static void duplicateCheck() {
		Shark map[][] = new Shark[R][C];
		
		ArrayList<Shark> removeSharks = new ArrayList<>(); //삭제할 상어를 담아두는 리스트
		
		for (Shark s : sharks) { 
			if(map[s.r][s.c] == null) {
				map[s.r][s.c] = s;
			}else { //map 공간이 이미 공간이 차있다. => 중복 
				
				//사이즈가 큰것만 남겨야함.
				if(map[s.r][s.c].z > s.z) { //새로운 상어 삭제
					removeSharks.add(s);
				}else { //기존에 있던 상어를 삭제하고 새로운 상어로 덮어씀
					removeSharks.add(map[s.r][s.c]);
					map[s.r][s.c] = s;
				}
			}
		}
		//삭제리스트에 담겨있던 상어들을 차례대로 삭제
		for (Shark shark : removeSharks) {
			sharks.remove(shark);
		}
	}

}