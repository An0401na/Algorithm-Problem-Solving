import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int M;
	static int D[][];
	static int result[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		D = new int[N + 1][N + 1];
		result = new int[N + 1][N + 1];

		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < N + 1; j++) {
				if (i != j)
					D[i][j] = INF;
			}
		}

		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < N + 1; j++) {
				if (i == j)
					result[i][j] = -1;
				else {
					result[i][j] = j;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			D[n1][n2] = Math.min(time, D[n1][n2]);
			D[n2][n1] = Math.min(time, D[n2][n1]);
		}
		
		for (int waypoint = 1; waypoint < N + 1; waypoint++) {
			for (int start = 1; start < N + 1; start++) {
				for (int end = 1; end < N + 1; end++) {
					if (D[start][waypoint] == INF || D[waypoint][end] == INF)
						continue;
					if (D[start][end] > D[start][waypoint] + D[waypoint][end]) {
						D[start][end] = D[start][waypoint] + D[waypoint][end];
						result[start][end] = result[start][waypoint]; //result 는 start에서 end로 갈때 가장 첫번째로 들려야하는 노드
						//start -> end 보다 start -> waypoint ->end 가 더 작다면 
						//start에서end로 가는 길이 무조건 start =>waypoint =>end 여야 하므로 
						// start->end로 갈때 들려야하는 가장 첫번째 노드를 start -> waypoint로 가는 첫번째 노드로 정해야한다.
					}
				}

			}

		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i == j)
					System.out.print("- ");
				else {
					System.out.print(result[i][j] + " ");
				}

			}
			System.out.println();
		}
		

	}

}