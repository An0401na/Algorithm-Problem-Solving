import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int num[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		num = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N-1;
		
		int sum = num[0] + num[N-1];
		
		int answer[] = new int[2];
	
		answer[0] = num[left];
		answer[1] = num[N-1];
		
		while (left < right) {
			if(Math.abs(sum) >Math.abs(num[left]+num[right])) {
				answer[0] = num[left];
				answer[1] = num[right];
 				sum = answer[0] + answer[1];
			}
			if(sum ==0) {
				break;
			}
			
			if(num[left]+num[right] < 0 ) {
//				System.out.println(sum +" 0보다 작음");
				left++;
			}else {
//				System.out.println(sum+ "0보다 크다 ");
				right--;
			}
		}
		

		System.out.println(answer[0]+" "+answer[1]);
		
		
	}

}