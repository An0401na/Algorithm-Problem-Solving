import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int period[];
	static int profit[];
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		period = new int[N+1];
		profit = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			period[i] = Integer.parseInt(st.nextToken());
			profit[i] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		dfs(1,0,1);
		System.out.println(max);
	}
	static void dfs(int start, int totProfit, int lastDay) {
		if(start > N) {
			if(start - lastDay > N-lastDay+1) {
				totProfit-=profit[lastDay];
			}
			max = Math.max(max, totProfit);
			return;
		}
		for (int i = start; i <=N; i++) {
			dfs(i+period[i], totProfit + profit[i],i);
		}
	}
}