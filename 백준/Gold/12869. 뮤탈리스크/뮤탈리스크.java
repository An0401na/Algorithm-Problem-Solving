import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int dp[][][] = new int[61][61][61];
	static int attack[][] = {
			{9, 3, 1},
			{3, 9, 1},
			{1, 3, 9},
			{9, 1, 3},
			{3, 1, 9},
			{1, 3, 9},
			{1, 9, 3}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int scv[] = new int[3];
		for (int i = 0; i < N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 61; i++) {
			for (int j = 0; j < 61; j++) {
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
			}
		}
		
		
		dfs(0, scv);
		
		System.out.println(dp[scv[0]][scv[1]][scv[2]]);
	}
	
	
	private static int dfs(int cnt, int[] scv) {
		if(dp[scv[0]][scv[1]][scv[2]] <= cnt && dp[scv[0]][scv[1]][scv[2]]!= 0) return dp[scv[0]][scv[1]][scv[2]]; //방문했는데 공격회수가 더 큰 경우
//		System.out.println("cnt: " + cnt +" scv : "+Arrays.toString(scv));
		if(scv[0] == 0 && scv[1] == 0 &&scv[2] == 0) {
//			System.out.println("끝");
//			dp[scv[0]][scv[1]][scv[2]] = Math.min(dp[scv[0]][scv[1]][scv[2]], cnt);
			return 0;
		}
		
		for (int i = 0; i < attack.length; i++) {
			int next [] = new int[3];
			for (int j = 0; j < 3; j++) {
				int value = scv[j] - attack[i][j];
				if(value <= 0) {
					next [j] = 0;
				}else {
					next[j] = value;
				}
			}
			
			dp[scv[0]][scv[1]][scv[2]] = Math.min(dp[scv[0]][scv[1]][scv[2]], dfs(cnt+1, next)+1);
			
		
		}
		return dp[scv[0]][scv[1]][scv[2]];
	}
	


}