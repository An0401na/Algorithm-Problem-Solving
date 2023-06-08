import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
	//이분탐색 upper bound
	//지금까지 진행한 게임횟수만큼  더 해서 전부 이기면 확률이 50%는 넘지 않을까?
	static int X;
	static int Y;
	static int Z;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		double tmp =((double)Y/X);
		BigDecimal big= new BigDecimal(String.valueOf(tmp));
		big = big.multiply(new BigDecimal("100"));
		Z = big.intValue();
		
//		System.out.println("Z : "+ Z+"%");
//		System.out.println();
		if(Z == 100 || Z == 99) {
			System.out.println("-1");
			return;
		}
		
		long start = X;
		long  end = X+X;
		int diff = X-Y;
		while (start<end) {
			long mid = (start+end)/2;
			tmp =((double)(mid-diff)/mid);
			big= new BigDecimal(String.valueOf(tmp));
			big = big.multiply(new BigDecimal("100"));
			int percent = big.intValue();
//			System.out.println(start +" ~ "+ mid +" ~ " + end + " => "+ percent+"%");

			if(percent > Z) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		System.out.println(end - X);
		
	}
}