import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<int[]> cases;
	static boolean visited[];
	static int[] search;
	static int[] answer;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cases = new ArrayList<>();
		
		visited = new boolean[N+1];
		search = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			search[i] = Integer.parseInt(st.nextToken());
		}

		answer = new int[N];
		perm(0);
		System.out.println(-1);
		
	}
	private static void perm(int cnt) {
		if(cnt == N) {
//			System.out.println("dddd"+Arrays.toString(answer));
			if(flag) {
				for (int i = 0; i < N; i++) {
					System.out.print(answer[i]+" ");
				}
				
				System.exit(0);
			}
			flag = true;
			for (int i = 0; i < N; i++) {
//				System.out.println(search[i]+" , "+answer[i]);
				if(search[i] != answer[i]) {
					flag = false;
				}
			}
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(!flag && search[cnt] != i) continue;
			if(visited[i]) continue;
			visited[i] = true;
			answer[cnt] = i;
			perm(cnt+1);
			visited[i]=false;
		}
	}

}