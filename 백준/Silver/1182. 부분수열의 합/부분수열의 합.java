import java.util.Scanner;

public class Main {
	
	static int N;
	static int S;
	static int [] num;
	
	static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i]= sc.nextInt();
		}
		dfs(0,-1,0);
		System.out.println(count);
	}
	
	static void dfs(int depth, int idx, int s) {
		if(s==S && depth!=0) {
			count++;
		}
		if(depth==N) {
			return;
		}
		for (int i = idx+1; i < N; i++) {
			dfs(depth+1, i, s + num[i]);
		}
	}
}
