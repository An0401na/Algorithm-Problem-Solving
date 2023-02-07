import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int []nums;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[M];
		visited = new boolean[N];
		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt==M){
			for (int i = 0; i < M; i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return;
		}else {
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					continue;
				}
				visited[i]=true;
				nums[cnt]=i+1;
				perm(cnt+1);
				nums[cnt]=0;
				visited[i]=false;
					
				
			}
			
		}
		
	}

}
