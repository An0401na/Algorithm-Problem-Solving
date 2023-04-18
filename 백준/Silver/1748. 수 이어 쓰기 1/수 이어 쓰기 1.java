import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int digit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int len = str.length();
		N = Integer.parseInt(str);
	
		if(len==1) {
			System.out.println(N);
			return;
		}
		
//		digit=9;
//		int temp=0;
		for (int i = 1; i < len; i++) {
			digit+= (int) (9 * Math.pow(10, i - 1)) * i;
		}
//		digit+=temp;

//		System.out.println(digit);
		int result = (len * (int)(N - Math.pow(10, len -1) + 1));
//		System.out.println(Math.pow(10, len - 1) + 1);
//		System.out.println((N%Math.pow(10, len - 1) + 1));
//		System.out.println(result);
		System.out.println(digit+result);
	}

}