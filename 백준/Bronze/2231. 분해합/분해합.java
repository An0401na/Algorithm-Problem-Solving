import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static int N;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		for (int i =1; i <= N; i++) {
			int n = i;
			int num = i;
			String st = Integer.toString(num);
			for (int j = 0; j < st.length(); j++) {
				num += st.charAt(j)-'0';
			}
			if (N == num) {
				result = Math.min(result, n);
			}
		}
		if(result == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(result);
		}
		
		
		
	}

}