import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char sign[];
	static boolean visited[];
	static long min;
	static String minString;
	static long max;
	static String maxString;
	static StringBuilder sb; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		sign = new char[N];
		visited = new boolean[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		
		max = 0;
		min = Long.MAX_VALUE;
		
		sb = new StringBuilder();
		
		for (int i = 0; i < 10; i++) {
			visited[i] = true;
			sb.append(i);
//			System.out.println("첫번째 :" +sb.toString());
			dfs(1);
			visited[i] = false;
			sb.deleteCharAt(sb.length()-1);
		}
		
		System.out.println(maxString);
		System.out.println(minString);
		
	}
	static void dfs(int cnt) {
		if(cnt == N+1 ) {
			long temp = Long.parseLong(sb.toString());
			
			if(max < temp) {
				max = temp;
				maxString = sb.toString();
			}
			
			if(min > temp) {
				min = temp;
				minString = sb.toString();
			}
			return;
		}
		
		
		for (int i = 0; i < 10; i++) {
			if(visited[i]) continue;
			
			if(sign[cnt-1]=='<') {
				long num = sb.charAt(cnt-1)-'0';
//				System.out.println(num);
				if(num < i) {
					visited[i] = true;
					sb.append(i);
//					System.out.println(cnt+"번째 :"+ sb.toString());
					dfs(cnt+1);
					sb.deleteCharAt(sb.length()-1);
					visited[i] = false;
				}
			}else {
				long num = sb.charAt(cnt-1)-'0';
				if(num > i) {
					visited[i] = true;
					sb.append(i);
//					System.out.println(cnt+"번째 :"+ sb.toString());
					dfs(cnt+1);
					sb.deleteCharAt(sb.length()-1);
					visited[i] = false;
				}
			}
			
			
			
		}
	}

}