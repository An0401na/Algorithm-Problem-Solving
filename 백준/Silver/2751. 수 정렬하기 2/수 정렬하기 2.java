import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int num[];
	static int count[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		num = new int[N];

		count = new int[2000001];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine())+1000000;
			count[num[i]]++;
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count.length; i++) {
			if(count[i]==1) {
				sb.append(i-1000000).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}