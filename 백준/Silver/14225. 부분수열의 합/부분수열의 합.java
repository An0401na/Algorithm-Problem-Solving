import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int num[];
	static int total;
	static int min;
	static boolean visited[];
	static boolean check[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			total += num[i];
		}
		
		check = new boolean[total+2];
		getAnswer(0, 0);
		for (int i = 1; i < check.length; i++) {
			if(!check[i]) {
				System.out.println(i);
				return;
			}
		}
	
		
	}
	static void getAnswer(int cnt, int start) {
//		System.out.println(cnt);
		if(!check[cnt]) {
			check[cnt] = true;
		}
		
		for (int i = start; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			getAnswer(cnt+num[i], i+1);
			visited[i] = false;
		}
	}

}