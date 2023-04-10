import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visited;
	static int temp[][];
	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		boolean result = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M - 1; j++) {
				if (map[i][j] == map[i][j + 1]) {
					visited = new boolean[N][M];
					temp = new int[N][M];
					visited[i][j] = true;
					temp[i][j] = 1;
//					if (check(i, j, map[i][j])) {
//						System.out.println("Yes");
//						return;
//					}
					visited[i][j]=true;
					temp[i][j] = 1;
					checkDfs(i, j, map[i][j]);

				}
			}
		}
		System.out.println("No");
	}

	static void checkDfs(int r, int c, char charater) {
		
		for (int i = 0; i <4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(isInRange(nr, nc) && temp[r][c]!=2 && temp[nr][nc] == 1) {
				System.out.println("Yes");
				System.exit(0);
			}
			if (isInRange(nr, nc)&& !visited[nr][nc] && map[nr][nc] == charater) {						
				visited[nr][nc] = true;
				temp[nr][nc]= temp[r][c]+1;
				checkDfs(nr, nc, charater);
				temp[nr][nc]= 0;
				visited[nr][nc] = false;
			}
		}
	}

	static boolean check(int r, int c, char charater) {
//		System.out.println(r+" "+c);
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
//		q.add(new int[] { r, c+1 });
		int cnt =2;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int[] n = q.poll();
				System.out.println("n => "+n[0]+" "+n[1]);
				for (int i = 0; i < 4; i++) {
					int nr = n[0] + dir[i][0];
					int nc = n[1] + dir[i][1];
//					if(isInRange(nr, nc) && temp[nr][nc] !=0 &&temp[nr][nc]==temp[n[0]][n[1]]) {
//						System.out.println(temp[nr][nc]);
//						System.out.println(temp[n[0]][n[1]]);
//						return true;
//					}
					if (isInRange(nr, nc)&& !visited[nr][nc] && map[nr][nc] == charater) {						
						visited[nr][nc] = true;
						temp[nr][nc]= cnt;
						q.add(new int[] {nr,nc});
					}
				}
			}
			cnt++;
		}
		return false;
	}

	static boolean isInRange(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < M;
	}

}