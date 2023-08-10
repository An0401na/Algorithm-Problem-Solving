import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class Main {
	static final char OPEN = '(';
	static final char CLOSE = ')';
	static int N;
	static char[] vps;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Loop1:for (int i = 0; i < N; i++) {
			Stack<Character> st = new Stack<>();
			vps = br.readLine().toCharArray();
			
			for (char c : vps) {
				if(c == OPEN) {
					st.push(OPEN);
				}else {
					if(!st.isEmpty()) {
						st.pop();
					}else {
						sb.append("NO\n");
						continue Loop1;
					}
				}
			}
			
			if(!st.isEmpty()) {
				sb.append("NO\n");
			}else {
				sb.append("YES\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}