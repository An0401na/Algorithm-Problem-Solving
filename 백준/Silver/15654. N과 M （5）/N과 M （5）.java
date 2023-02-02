import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int [] num;
	static boolean [] visited;
	static ArrayList result= new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			num[i]= sc.nextInt();
		}
		Arrays.sort(num);
		dfs(0,-1);
	}
	
	static void dfs(int depth, int idx) {
		if(depth==M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result.get(i)+" ");
			}
			System.out.println();

			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				result.add(num[i]);
				dfs(depth+1, i);
				result.remove(result.size()-1);
				visited [i]= false;
			}
		}
	}
}
