import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int TC;
	static int N;
	static long price[];
	static boolean isused[];
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC ; tc++) {
			sb.append("#"+tc+" ");

			N = Integer.parseInt(br.readLine());
			price = new long[N*2];
			isused = new boolean[N*2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N*2; i++) {
				price[i] = Long.parseLong(st.nextToken());
			}

			for (int i = 0; i < N*2 ; i++) {
				if(isused[i]) continue;
				long originPrice = (price[i]/3L)*4L;
//				System.out.println("price: "+price[i]+" origin : " + originPrice);
				for (int j = i+1; j < N*2 ; j++) {
					if(!isused[j] && price[j] == originPrice){
						isused[i] = true;
						isused[j] = true;
						sb.append(price[i]+" ");
						break;
					}
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

}