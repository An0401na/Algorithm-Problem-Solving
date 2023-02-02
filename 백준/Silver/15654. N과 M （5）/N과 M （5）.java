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
			// 이전에 뽑지 않았던 수라면 
			if(!visited[i]) {
				//뽑았다고 표시
				visited[i]=true;
				//뽑은 수 추가
				result.add(num[i]);
				dfs(depth+1, i);
				// ex ) 현시점 result 1 2 3 4 - - 
				result.remove(result.size()-1);
				// ex ) 현시점 result 1 2 3 - - -
				// 1 2 3 4 일때 나머지 두자릴 다 탐색하고 네번째 자리를 4 다음큰 숫자로 변경하기위해서
				//result에 가장 마지막에 들어있는 수를 제거한고
				
				//네번째 자리가 4 다음 큰수가 들어왔을때 탐색했던 숫자들은 방문하지 않아야 하므로 다시 false로 변경
				visited [i]= false;
			}
		}
	}
}
