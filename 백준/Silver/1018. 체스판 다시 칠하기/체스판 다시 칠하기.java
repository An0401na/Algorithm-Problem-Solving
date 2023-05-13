import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final char WHITE = 'W';
	static final char BLACK = 'B';
	static int N;
	static int M;
	static char [][] board;
	static boolean [][] visited;
	static int count;
	static int dir[][]= {{1,0},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		int a= 1;
		count = Integer.MAX_VALUE;
//		board = new char[8][8];
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
//				System.out.println("========"+a+"번째 카피 "+i+", "+j+"=======");
//				a++;
//				for (int j2 = 0; j2 < 8; j2++) {
//					System.out.println(Arrays.toString(board[j2]));
//					
//				}
				count = Math.min(count, count(i, j,BLACK));

//				board = copy(i,j);
//				System.out.println("========"+a+"번째 카피 "+i+", "+j+"=======");
//				a++;
//				for (int j2 = 0; j2 < 8; j2++) {
//					System.out.println(Arrays.toString(board[j2]));
//					
//				}
				count = Math.min(count, count(i, j,WHITE));
			}
		}
		
		
		System.out.println(count);
		
		
	}
	
//	static char[][] copy(int r, int c) {
//		char[][] copyboard = new char [8][8];
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				copyboard[i][j] = map[r+i][c+j];
//			}
//			
//		}
//		return copyboard;
//	}

	static int count(int row , int col, char c) {
		visited = new boolean[8][8];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		visited[0][0] = true;
		int cnt = 0;
//		char c = switchCharacter(board[row][col]);
		while (!q.isEmpty()) {
//			System.out.println("---"+c+"로 변경하기");
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] n = q.poll();
//				System.out.println(Arrays.toString(n));
				if(c != board[row+n[0]][col+n[1]]) {
//					System.out.println(n[0]+" , "+n[1]+" : "+board[n[0]][n[1]]+
//							" => "+ c);
//					
//					board[n[0]][n[1]] =  c;
					
					cnt++;
					if(cnt >= count) {
//						System.out.println("cnt("+cnt+")가 count("+count+")보다 커짐");
						return count;
					}
				}
					
				for (int d = 0; d < 2; d++) {
					int nr = n[0] + dir[d][0];
					int nc = n[1] + dir[d][1];
					if(isInRange(nr, nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new int[] {nr, nc});
					}
				}
			}
			c = switchCharacter(c);
		}
		

//		System.out.println("========= 변경후 : "+ cnt);
//		for (int j2 = 0; j2 < 8; j2++) {
//			System.out.println(Arrays.toString(board[j2]));
//			
//		}

//		System.out.println();
//		System.out.println();
		
		return cnt;
	}
	static boolean isInRange(int nr, int nc) {
		return nr >=0 && nc >=0 && nr < 8 && nc <8;
	}

	static char switchCharacter(char c) {
		if(c == WHITE) {
			return BLACK;
		}
		return WHITE;
	}

}