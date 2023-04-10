import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visited;
	static int numbering[][];
	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
//		visited = new boolean[N][M];
		numbering = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M - 1; j++) {
				if (map[i][j] == map[i][j + 1]) {
					visited = new boolean[N][M];
					numbering = new int[N][M];
//					visited[i][j] = true;
					numbering[i][j] = 1;
					checkDfs(i, j, map[i][j]);
//					visited[i][j] = false;
					numbering[i][j] = 0;
				}
			}
		}
		System.out.println("No");
	}

	static void checkDfs(int r, int c, char charater) {
		
		for (int i = 0; i <4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(isInRange(nr, nc) && numbering[r][c]!=2 && numbering[nr][nc] == 1) {
				System.out.println("Yes");
				System.exit(0);
			}
			if (isInRange(nr, nc)&& numbering[nr][nc]==0 && map[nr][nc] == charater) {						
//				visited[nr][nc] = true;
				numbering[nr][nc]= numbering[r][c]+1;
				checkDfs(nr, nc, charater);
				numbering[nr][nc]= 0;
//				visited[nr][nc] = false;
			}
		}
	}
	
	static boolean isInRange(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}

}