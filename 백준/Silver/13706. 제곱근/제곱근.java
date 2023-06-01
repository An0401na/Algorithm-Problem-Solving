import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static BigInteger N;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	
		N = new BigInteger(br.readLine());
		
		BigInteger start = new BigInteger("0");
		BigInteger end = N;
		while (start.compareTo(end) != 1) {
			BigInteger mid = start.add(end).divide(new BigInteger("2"));
//			System.out.println(mid +" / "+ end);
			if((mid.multiply(mid)).compareTo(N) == 0) {
				System.out.println(mid);
				return;
			}else if((mid.multiply(mid)).compareTo(N) == 1) {
				end = mid.subtract(new BigInteger("1"));
			}else {
				start = mid.add(new BigInteger("1"));
			}
		}
		
		
	}

}