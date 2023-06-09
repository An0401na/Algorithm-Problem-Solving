import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;

public class Main {
	static int N;
	static int[] dp;
	static int num; // 몇 제곱까지 사용할수 있는지 저장하는 변수 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		dp[1] = 1;
		if(N ==1) {
			System.out.println(1);
			return;
		}
		
		num = 1;
		
		
		
		for (int i = 2; i <= N; i++) {
//			System.out.println("===== 숫자 : "+ i +" =====");
			if((int)Math.sqrt(i) * (int)Math.sqrt(i) == i ) {
				
				num = (int) Math.sqrt(i);
				dp[i] = 1;
//				System.out.println("dp["+i+"] = "+dp[i]);
//				System.out.println("num : "+num);
			}else {
				int min = Integer.MAX_VALUE;
				for (int j = num; j >= 1; j--) {
					
					if(min > dp[i-j*j]+1) {
						min = dp[i-j*j]+1;
					}
//					System.out.println("j : "+ j+", min : "+min);
				}
				dp[i] = min;
//				System.out.println("dp["+i+"] = "+dp[i]);
//				System.out.println("num : "+num);
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
		
	}

}