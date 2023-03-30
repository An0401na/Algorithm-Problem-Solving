import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	//파이프 옮기기
	static int N;
	static int map[][];
	static int memo[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		memo = new int[N][N];
		
		dfs(0, 0 , 1, 0 );
		
//		for (int i = 0; i < memo.length; i++) {
//			System.out.println(Arrays.toString(memo[i]));
//		}
		System.out.println(memo[N-1][N-1]);
		
	}
	static void dfs(int cnt, int r, int c, int d) {
		//r, c는 파이프의 끝 인덱스, dir 파이프의 방향
		// d 이 0이면 가로, 1이면 세로, 2이면 대각선
		if(map[r][c] == 1) return;
		memo[r][c] ++;
//		if(r ==N-1 && c== N-1 ) {
//			memo[r][c] ++;
//		}
		if(d == 0) {
			if(isInRange(r, c+1)) {
				dfs(cnt+1, r, c+1, 0);
			}
			if(isInRange(r+1, c+1)) {
				if(map[r+1][c] ==1 ||map[r][c+1] ==1 )
					return;
				dfs(cnt+1, r+1, c+1, 2);
			}
		}else if(d == 1) {
			if(isInRange(r+1, c)) {
				dfs(cnt+1, r+1, c, 1);
			}
			if(isInRange(r+1, c+1)) {
				if(map[r+1][c] ==1 ||map[r][c+1] ==1 )
					return;
				dfs(cnt+1, r+1, c+1, 2);
			}
		}else if(d == 2) {
			if(isInRange(r, c+1)) {
				dfs(cnt+1, r, c+1, 0);
			}
			if(isInRange(r+1, c)) {
				dfs(cnt+1, r+1, c, 1);
			}
			if(isInRange(r+1, c+1)) {
				if(map[r+1][c] ==1 ||map[r][c+1] ==1 )
					return;
				dfs(cnt+1, r+1, c+1, 2);
			}
		}
	}
	
	static boolean isInRange(int r, int c) {
		return r >= 0 && c >=0 && r < N && c < N;
	}
}