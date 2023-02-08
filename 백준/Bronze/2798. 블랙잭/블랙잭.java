import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int M;
	static int [] p;
	static boolean visited[];
	static int result=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M =  Integer.parseInt(st.nextToken());
		p = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i]= Integer.parseInt(st.nextToken());
		}
		
		combi(0,0);
		System.out.println(result);
		
	}
	
	
	
	 static void combi(int cnt, int total) {
		 if(cnt==3) {
			 if(result<total && total<=M) {
					 result=total;
				 }
			 return;
		 }
		 for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			combi(cnt+1,total+p[i]);
			visited[i]=false;
		}
		 
	}

}
