import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static StringBuilder sb  = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int q[] = new int[10001];
		int start = 0;
		int end = 0;
		int cnt = 0;
		while(cnt != N) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int n;
			switch (op) {
			case "push": 
				q[end] = Integer.parseInt(st.nextToken());
				end++;
				break;
			case "pop" :
				if(start == end) {
					sb.append("-1\n");
					break;
				}
				n = q[start];
				start++;
				sb.append(n).append("\n");
				break;
			case "size" :
				sb.append(end-start).append("\n");
				break;
			case "empty" :
				if(start == end) {
					sb.append("1\n");
					break;
				}else {
					sb.append("0\n");
				}
				break;
			case "front" :
				if(start == end) {
					sb.append("-1\n");
					break;
				}
				n = q[start];
				sb.append(n).append("\n");
				break;
			case "back" :
				if(start == end) {
					sb.append("-1\n");
					break;
				}
				n = q[end-1];
				sb.append(n).append("\n");
				break;
			}
			cnt++;
	
		}
		
		System.out.println(sb.toString());
		
	}

}