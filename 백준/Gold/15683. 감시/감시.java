import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

	static class Camera{
		int r;
		int c;
		int type;
		public Camera(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;  //1 2 3 4 5 //2일때는 0~1, 5일때는 1개
		}
		
	}
	static int N;
	static int M;
	static int[][] map;
	static int[][] copy;
	static int blind; //사각지대의 수
	static int[][] dir = {{0,-1},{-1,0},{0,1},{1,0},{0,-1},{-1,0}}; //좌측부터 시계방향
	static ArrayList<Camera> cameras = new ArrayList<>(); //각 카메라의 정보를 담는 리스틑
	static int[] cameraDir; //각 카메라의 방향을 저장하는 배열 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		copy  = new int [N][M];
		blind  = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >0 && map[i][j]<6) {
					cameras.add(new Camera(i,j,map[i][j]));
				}
			}
		}
		cameraDir = new int[cameras.size()];  //초기 방향은 0 0 0 .... 으로 세팅
		
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copy[i], 0, M);
		}
		oversight(0);
		System.out.println(blind);
		
	}
	static void oversight(int cnt) {
		if(cnt == cameras.size()) {
			int[][] temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(copy[i], 0, temp[i], 0, M);
			};
			makeMap();
			blind = Math.min(blind, countBlind());
			for (int i = 0; i < N; i++) {
				System.arraycopy(temp[i], 0, copy[i], 0, M);
			};
			return;
		}
		switch (cameras.get(cnt).type) {
		case 1 :
		case 3 :
		case 4 :
			for (int dir = 0; dir <4; dir++) {
				cameraDir[cnt] = dir;
				oversight(cnt+1);
			}
			break;
		case 2:
			for (int dir = 0; dir <2; dir++) {
				cameraDir[cnt] = dir;
				oversight(cnt+1);
			}
			break;
		case 5:
			oversight(cnt+1);
			break;
		}
	}
	static int countBlind() {
		int c =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j]==0) {
					c++;
				}
			}
		}
//		System.out.println("======"+c+"======");
//		print_copy(copy);
		return c;
		
	}
	static void makeMap() {
		for (int c = 0; c < cameras.size(); c++) { //카메라를 받아옴
			switch (cameras.get(c).type) {
			case 1 :
				look(cameras.get(c).r, cameras.get(c).c, cameraDir[c]);
				break;
			case 2 :
				look(cameras.get(c).r, cameras.get(c).c, cameraDir[c]);
				look(cameras.get(c).r, cameras.get(c).c, cameraDir[c]+2);
				break;
			case 3 :
				look(cameras.get(c).r, cameras.get(c).c, cameraDir[c]);
				look(cameras.get(c).r, cameras.get(c).c, cameraDir[c]+1);
				break;
			case 4:
				for (int i = 0; i < 3; i++) {
					look(cameras.get(c).r, cameras.get(c).c, cameraDir[c]+i);
				}
				break;
			case 5:
				for (int i = 0; i < 4; i++) {
					look(cameras.get(c).r, cameras.get(c).c,i);
				}
				break;
			}
		}
		
	}
	static void look(int r, int c, int d) {
		int nr = r + dir[d][0];
		int nc = c + dir[d][1];
		while(true) {
			if(isRange(nr, nc) && copy[nr][nc] !=6) {
				copy[nr][nc] = 8;
				nr = nr + dir[d][0];
				nc = nc + dir[d][1];
			}else {
				break;
			}
		}
	}
	static boolean isRange(int nr, int nc) {
		return nr>=0 && nc >= 0 && nr < N && nc < M;
		
	}
	static void print_copy(int [][] copy) {
		System.out.println("======================");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(copy[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("======================");
		
	}

}