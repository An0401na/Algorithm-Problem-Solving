import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int board[][];
//	static boolean visited[][];
	static int dir[][] = {{-1,-1},{1,-1},{1,1},{-1,1}};
	static int black_cnt;
	static int white_cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

//		visited = new boolean [N][N];
		black_search(0,0,0);

//		visited = new boolean [N][N];
		white_search(0,1,0);
		System.out.println(black_cnt+white_cnt);
		
	}
	
	private static void black_search(int r, int c, int cnt) {
//		System.out.println("r: c  - "+r+", "+c);

		for(int i = r; i < N; i++) {
			int j = 0;
			if(i%2 != 0) {
				j=1;
			}
			while (j < N) {
//				if(!visited[i][j] && check(i,j) && board[i][j] == 1) {
				if(check(i,j) && board[i][j] == 1) {
//					visited[i][j] = true;
					board[i][j] = 2;
					black_search(i, j, cnt+1);
					board[i][j] = 1;
//					visited[i][j] = false;
				}
				j +=2;
			}
		}

		black_cnt = Math.max(black_cnt, cnt);
//		for (int i = 0; i < board.length; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
		
	}
	
	private static void white_search(int r, int c, int cnt) {
//		System.out.println("r: c  - "+r+", "+c);

		for(int i = r; i < N; i++) {
			int j = 0;
			if(i%2 == 0) {
				j=1;
			}
			while (j < N) {
//				if(!visited[i][j] && check(i,j) && board[i][j] == 1) {
				if(check(i,j) && board[i][j] == 1) {
//					visited[i][j] = true;
					board[i][j] = 2;
					white_search(i, j, cnt+1);
					board[i][j] = 1;
//					visited[i][j] = false;
				}
				j +=2;
			}
		}

		white_cnt = Math.max(white_cnt, cnt);
//		for (int i = 0; i < board.length; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
		
	}

	private static void print() {
		System.out.println("sssssssssssssssss");
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	
	}
	private static boolean check(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];

			while (isInRange(nr, nc)) {

				if(board[nr][nc] == 2) {
					return false;
				}
				
				nr += dir[i][0];
				nc += dir[i][1];
			}
		}
		return true;
	}

	private static boolean isInRange(int r, int c) {
		return r >=0 && r < N && c >= 0 && c < N;
	}
	

}