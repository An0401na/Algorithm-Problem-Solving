import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int S;
	static int [] num;
	static int minLen = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		int sum []= new int[N];
		int s = 0;
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			s += num[i];
			sum[i] = s;
		}
		
		if(s < S) {
			System.out.println(0);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			s = 0;
			int idx = i;
			
			while (s < S && idx < N) {
				s+=num[idx++];
			}
			
			if(s >= S) {
				minLen = Math.min(minLen, idx-i);
			}
			
			if(sum[N-1]-sum[i] < S) break;
		}
		System.out.println(minLen);
		
		
	}

}