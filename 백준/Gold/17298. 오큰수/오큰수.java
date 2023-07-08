import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int num[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		num = new int[N+2];
		StringTokenizer stringtokonizer = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(stringtokonizer.nextToken());
		}
		num[N+1] = Integer.MAX_VALUE;
		
		int idx[] = new int[N+1];
		Stack<Integer> st = new Stack<>();
		st.push(N+1);
		for (int i = N; i >= 1; i--) {
			
			if(num[i] < num[i+1]) {
				st.push(i);
				idx[i] = i+1;
			}else {
				int k = 0;
				while (!st.isEmpty()) {
					int n = st.peek();
					if(num[i] >= num[n]) {
						st.pop();
					}else {
						if(num[i] < num[n]) {
							st.push(i);
						}
						k = n;
						break;
					}
				}
				idx[i] = k;
			}
//			
//			System.out.println(st.toString());
//			System.out.println(Arrays.toString(idx));
//			
		}
		
		num[N+1] = -1;

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N+1; i++) {
			sb.append(num[idx[i]]).append(" ");
		}
		System.out.println(sb.toString());
	}

}