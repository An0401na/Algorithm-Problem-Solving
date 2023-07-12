import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int num[];
	static int result[];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		result = new int[2];
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
//		System.out.println(Arrays.toString(num));
		int left = 0;
		int right = N-1;
		while (left < right) {
			
//			System.out.println(min);
			int n =num[left] + num[right];
//			System.out.println("n : "+n);
			
//			System.out.println(num[left]);
//			System.out.println(num[right]);
			if(Math.abs(n) < min) {
				min = Math.abs(n) ;
				result[0] = num[left];
				result[1] = num[right];
				if(n == 0) break;
//				System.out.println("바뀐 min : "+min);
			}
			
			if(n < 0) {
//				System.out.println("left++");
				left++;
			}else {
//				System.out.println("right -- ");
				right--;
			}
//			System.out.println();
			
			
		}
		
		
		System.out.println(result[0]+" "+result[1]);
		
		
	}

}