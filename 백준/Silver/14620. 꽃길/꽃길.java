import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 접근 : 10 min
	// 구현 : 50 min
	static int N;
	static int map[][];
	static int priceMap[][]; // i,j를 중심으로한 5평의 가격
	static int cost = Integer.MAX_VALUE; // 꽃을 심기 위한 최소 비용
	static boolean visited[][];
	static int dir[][] = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static int[][] temp = new int [3][2];
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

		priceMap = new int[N][N];
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				priceMap[i][j] = getPrice(i, j);
			}
		}


		visited = new boolean[N][N];
		
		dfs(0, 0);
		
		System.out.println(cost);

	}

	private static void dfs(int cnt, int sum) {
		if(cost <= sum) return;
		if(cnt == 3) {
			if(cost > sum ) {
				cost = sum;
//				System.out.println("==== "+cost+"====");
//				for (int i = 0; i < temp.length; i++) {
//					System.out.println(Arrays.toString(temp[i])+" => "+ priceMap[temp[i][0]][temp[i][1]]);
//				}
//				System.out.println("visited ---");
//
//				for (int i = 0; i < visited.length; i++) {
//					System.out.println(Arrays.toString(visited[i]));
//				}
			}
			return;
			
		}
		
		for (int i = 1; i < N - 1; i++) {
			Loop1 : for (int j = 1; j < N - 1; j++) {
				if(visited[i][j]) continue;
				for (int d = 0; d < 5; d++) {
					if (visited[i + dir[d][0]][j + dir[d][1]]) {
						continue Loop1;
					}
				}
				for (int d = 0; d < 5; d++) {
					visited[i + dir[d][0]][j + dir[d][1]] = true;
				}
				temp[cnt][0] = i;
				temp[cnt][1] = j;
				dfs(cnt+1, sum+priceMap[i][j]);
				for (int d = 0; d < 5; d++) {
					visited[i + dir[d][0]][j + dir[d][1]] = false;
				}
				
			}
		}
	}

	static int getPrice(int i, int j) {
		int sum = 0;
		for (int d = 0; d < 5; d++) {
			sum += map[i + dir[d][0]][j + dir[d][1]];
		}
		return sum;
	}

}