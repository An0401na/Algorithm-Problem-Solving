import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static int N;
	static int num[];
	static int dp[][];
	// dfs로 풀게 되면 2^300 시간복잡도를 가지게 되어 터진다.
	// 한번 dfs를 호출 할 때 마다 2번 호출 하므로 O(2^N) 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		num = new int[N+1];
		dp = new int[2][N+1];
		//i,j일때 i ==0 이면 앞으로 한칸 이동 가능, i ==1 이면 무조건 두칸만 이동
		
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0][N] = num[N];
		
		for (int i = N; i >=2; i--) {
			//dp[i][j]==0인 곳은 도달하지 못하는 지점
			if(dp[0][i] > 0) { //i == 0 이면 한칸, 두칸 전진 가능
				dp[0][i-2] = Math.max(dp[0][i-2], num[i-2]+dp[0][i]);
				dp[1][i-1] = Math.max(dp[1][i-1] , num[i-1]+dp[0][i]);
			}
			if(dp[1][i]>0) { //i==1이면 두칸 전진만 가능
				dp[0][i-2] = Math.max(dp[0][i-2], num[i-2]+dp[1][i]);

			}
		}
		
		int max = 0;
		for (int i = 0; i <=1; i++) {
			for (int j = 0; j <=1; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}
		
		System.out.println(max);
		
	}

}