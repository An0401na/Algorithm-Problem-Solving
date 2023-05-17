import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int A;
	static int B;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		System.out.println(A*(B%100%10));
		System.out.println(A*(B/10%10));
		System.out.println(A*(B/100));
		System.out.println(A*B);
	
	}

}