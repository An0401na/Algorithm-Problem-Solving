import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if( N == 1) {
			System.out.println(0);
			return;
		}
		
		int[] num = new int[N+1];
		for (int i = 2; i <= Math.sqrt(N); i++) {
			int idx = i+i;
			while (idx <= N) {
				num[idx] = -1;
				idx +=i;
			}
		}
		
		ArrayList<Integer> prime = new ArrayList<>();
		for (int i = 2; i <=N; i++) {
			if(num[i] ==0) {
				prime.add(i);
			}
		}
//		for (int i : prime) {
//			System.out.print(i+" ");
//			
//		}
//		System.out.println();
		
		
		int sum = prime.get(0);
		int start = 0;
		int end = 0;
		while (!(end == prime.size()-1 && sum < N)) {
			if(sum == N) {
				
//				System.out.println("====");
//				System.out.println("sum : "+ sum);
//				for (int i = start; i <= end; i++) {
//					System.out.print(prime.get(i)+" ");
//				}
//				System.out.println();
				
				count++;
			}
			if(sum <= N ) {
				end++;
				if(end == prime.size()) break;
				sum += prime.get(end);
			}else {
				sum -= prime.get(start);
				start++;
			}
		}
		System.out.println(count);
	}

}