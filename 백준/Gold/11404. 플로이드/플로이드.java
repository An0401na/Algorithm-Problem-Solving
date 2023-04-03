import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	//플로이드 워샬 -> 경유지를 고정한채로 모든 경로를 다 본다.
	/* for 경유지
	 * for 출발지
	 * for 도착지
	 * 
	 * 시간복잡도는 N^3  => N이 500까지는 비벼볼만 하다.
	 * 밀집 그래프일때는 플로이드 워셜, 희소 그래프일때는 다익스트라 N번..?
	 * 
	*/
	//1 5 2 3
	// 2를 거치는 1 2 3
	// 			5 2 3이  갱신된다.
	// 
	static final int INF = Integer.MAX_VALUE; //inf + inf 인 경우 오버플로우를 방지하기 위해서 Integer.MAX_Value를 사용하지 않는다.
	static int N; //도시개수
	static int M; //버스의 개수
	static int D[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
//		int INF = M *100000+100;
		//초기화
		D = new int[N+1][N+1];
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < N+1; j++) {
				if(i != j){
					D[i][j] = INF;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken());
			int cost =  Integer.parseInt(st.nextToken());

			D[start][end] = Math.min(cost,D[start][end]);
		}
		
		
		
		for (int waypoint = 1; waypoint < N+1; waypoint++) {
			for (int start = 1; start < N+1; start++) {
				for (int end = 1; end < N+1; end++) {
					if(D[start][waypoint] == INF || D[waypoint][end] == INF) {
						continue;
					}
					D[start][end] = Math.min(D[start][end], D[start][waypoint] + D[waypoint][end]);
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(D[i][j] == INF) {
					System.out.print(0+" ");
					continue;
				}
				System.out.print(D[i][j] +" ");
			}
			System.out.println();
		}
	}
	

}