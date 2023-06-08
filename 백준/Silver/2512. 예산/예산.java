import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int city[];
	static int M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		city = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		
		Arrays.sort(city);
		
		int start = 0;
		int end = city[city.length-1];
		while (start <= end) {
			int sum =0;
			int mid = (start + end) /2;
//			System.out.print(start +" ~ "+mid+" ~ "+ end);
			
			for (int i = 0; i < N; i++) {
				if(city[i] < mid) {
					sum += city[i];
				}else {
					sum += mid;
				}
			}
//			System.out.println(" => "+ sum);
			if(sum > M) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		
		System.out.println(end);
		
		
	}
}