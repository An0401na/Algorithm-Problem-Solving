import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int [][] map;
	static int [][] sumMap;
	static int sr, sc, er, ec;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		sumMap = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i-1][j-1] = Integer.parseInt(st.nextToken());
				sumMap[i][j] = sumMap[i-1][j] + sumMap[i][j-1]  - sumMap[i-1][j-1] + map[i-1][j-1];
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			int result = sumMap[er][ec] - sumMap[er][sc-1] - sumMap[sr-1][ec] + sumMap[sr-1][sc-1];
//			System.out.println(sumMap[er][ec] +" "+ sumMap[er][sc-1] +" "+ sumMap[sr-1][ec] +" "+ sumMap[sr-1][sc-1]);
			System.out.println(result);
			
		}
	}

}