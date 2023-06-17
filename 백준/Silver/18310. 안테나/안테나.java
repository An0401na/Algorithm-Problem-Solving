import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int point[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		point = new int [N];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(point);
		if(N%2==0) {
			System.out.println(point[N/2-1]);
		}else {

			System.out.println(point[N/2]);
		}
		
	}

}