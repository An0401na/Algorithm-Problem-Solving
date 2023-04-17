import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int E;
	static int S;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int earth = 1;
		int sun = 1;
		int moon =1;
		int year = 1;
		while (!(earth == E && sun == S && moon ==M)) {
			if(earth == 15) earth =0;
			if(sun == 28) sun =0;
			if(moon == 19) moon=0;
			
			earth++;
			sun++;
			moon++;
			year++;
		}
		System.out.println(year);
	}

}