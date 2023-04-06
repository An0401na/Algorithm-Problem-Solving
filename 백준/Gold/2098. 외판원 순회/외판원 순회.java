import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int dist[][];
	static int dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dist = new int[N][N];
		dp = new int[1<<N][N];
		//dp의 행은 N이 3일때 000,001,010,100,011,101,110,111로 생각하며 visited의 모든 경우로 보면된다. 
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		
		int min = TSP(1, 0); //다시 시작도시로 되돌아올거기 때문에 어디로 시작해도 상관없다.
		System.out.println(min);
		
	}
	
	
	/*vistied는 비트로 생각해야한다.
	 * 001은 0번째 도시를 방문했다는 것이고 011은 1번도시와 0번도시를 방문했다는 의미이다.
	 * 즉 visited는 방문한도시를 체크하는 변수이며
	 * city는 직전에 방문한 도시 즉, 현 단계에서 출발도시이다.
	 * city에서 다른 도시로 이동할 것이다.
	 * 
	 */
	static int TSP(int visited, int city) {
		if(visited == (1<<N)-1) { //visited가 111인 경우 즉 모든 비트가 1이여서 모든 도시에 방문했다는 의미
			if(dist[city][0] ==0) return INF; //마지막 방문한 도시에서 0으로가는 길이 0이라면 다시 시작점으로 돌아올수 없으니까 INF 리턴
			return dist[city][0];
			//마지막 도시까지 방문했다면 시작도시(0)으로 되돌아가야하므로 마지막도시에서 0번째도시로의 비용을 반환.
		}
		
		if(dp[visited][city] != -1) {   
			//이미 dp가 -1이 아니라면 이미 그 값이 나와 있다는 것이니까
			//그 값을 리턴한다.
			return dp[visited][city];
		}
		
		dp[visited][city] = INF;
		for (int i = 0; i < N; i++) {
			if((visited & (1<<i)) != 0) continue;
			//방문한도시 & 방문할도시 결과가 111 혹은 011, 101,110,001,010,100 인경우는
			//방문한 도시를 또 방문할도시로 지정한거니까 그대로 넘어간다.
			
			if(dist[city][i] == 0) continue; 
			//city번 도시에서 i번 도시로 갈건데 그 거리가 0이라면 길 자체가 없다는 말이니까 넘어간다.
			
			if(TSP(visited | (1<<i), i) != INF) {
				int res = TSP(visited | (1<<i), i) + dist[city][i];
				dp[visited][city] = Math.min(res, dp[visited][city]);
			}
		}
		return dp[visited][city];
	}
	

}