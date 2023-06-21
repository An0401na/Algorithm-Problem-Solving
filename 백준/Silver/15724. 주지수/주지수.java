import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	//합을 구하는 문제이고 배열의 시작이 1로 시작한다면 누적합을 의심해보자
	static int N;
	static int M;
	static int peopleDP[][];
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		peopleDP = new int [N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				int value = Integer.parseInt(st.nextToken());
				peopleDP[i][j]= value + peopleDP[i-1][j]+peopleDP[i][j-1] - peopleDP[i-1][j-1];
			}
		}

		K = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
	
			sb.append(peopleDP[x2][y2] - peopleDP[x1-1][y2] - peopleDP[x2][y1-1]+peopleDP[x1-1][y1-1]).append("\n");
		}
		System.out.println(sb.toString());
	}

}