import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N; 
	static int S;
	static int num[];
	static int count;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N];
//		for (int i = 0; i < N; i++) {
//			if(num[i] == S) count++;
//		}
		subset(0, 0, false);
		System.out.println(count);
	}
	static void subset(int cnt, int tot, boolean flag) {
		if(cnt >= N) {
//			System.out.println(Arrays.toString(visited));
			if(flag &&tot == S ) {
//				System.out.println("ddd");
				count++;
			}
			return;
		}
		visited[cnt] = false;
		subset(cnt+1, tot, flag);
		visited[cnt] = true;
		subset(cnt+1, tot+num[cnt], true);
		
		
	}

}