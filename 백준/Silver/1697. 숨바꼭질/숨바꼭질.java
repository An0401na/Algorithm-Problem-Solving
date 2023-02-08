
import java.util.*;

public class Main {
	static int N;
	static int K;
	static int result=100001;
	static int[] visited=new int[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N= sc.nextInt();
		K= sc.nextInt();

		
		visited[N]=1;
		search(N);
	}

	static void search(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		
		 while(!q.isEmpty()) {
			 int n = q.poll();
			 
			 if(n == K) {
				 System.out.println(visited[n]-1);
				 return;
			 }
			 //-1일 한 자리가 0보다 크고 방문하지 않았을때 
			 if(n-1 >=0 && visited[n-1]==0) {
				 visited[n-1]= visited[n]+1;
				 q.add(n-1);
			 }
			 if(n+1 <= 100000 && visited[n+1]==0) {
				 visited[n+1]= visited[n]+1;
				 q.add(n+1);
			 }
			 if(n*2 <= 100000 &&visited[n*2]==0) {
				 visited[n*2]= visited[n]+1;
				 q.add(n*2);
			 }
			 
		 }
		 return;
		
	}
}