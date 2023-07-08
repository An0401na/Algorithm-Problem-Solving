import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	static int N;
	static int building[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		building = new int[N+2];
		for (int i = 1; i <= N; i++) {
			building[i] = Integer.parseInt(br.readLine());
		}
		building[N+1] = Integer.MAX_VALUE;
		
		int idx[] = new int[N+1];
		Stack<Integer> st = new Stack<>();
		st.push(N+1);
		for (int i = N; i >= 1; i--) {
			
			if(building[i] < building[i+1]) {
				st.push(i);
				idx[i] = i+1;
			}else {
				int k = 0;
				while (!st.isEmpty()) {
					int n = st.peek();
					if(building[i] > building[n]) {
						st.pop();
					}else {
						k = n;
						break;
					}
				}
				st.push(i);
				idx[i] = k;
				
			}
			
//			System.out.println(st.toString());
//			System.out.println(Arrays.toString(idx));
			
		}

		
		long sum = 0;
		for (int i = 1; i < N+1; i++) {
			sum += idx[i]-i-1;
		}
		System.out.println(sum);
	}

}