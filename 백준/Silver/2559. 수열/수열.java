import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int K;
	static int arr[];
	static int max_sum = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr= new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= N-K; i++) {
			int sum =0;
			for (int j = 0; j < K; j++) {
				sum += arr[i+j];
			}
			if(max_sum < sum) {
				max_sum = sum;
			}
		}
		
		System.out.println(max_sum);
				
		
	}

}