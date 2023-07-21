import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		
		Arrays.fill(visited, -1);
		visited[N] = -2;
		Queue<Integer> q = new LinkedList<>();
		
		q.add(N);
		int time = 0;
		Loop1 : while (!q.isEmpty()) {
			int size = q.size();
			for(int i =0; i < size; i++) {
				int n  = q.poll();
				
				if(n == K) {
					System.out.println(time);
					break Loop1;
				}
				if(isInRange(n-1) && visited[n-1] == -1) {
					q.add(n-1); 
					visited[n-1] = n;			
				}
				
				if(isInRange(n+1) && visited[n+1] == -1) {
					q.add(n+1);
					visited[n+1] = n;					
				}
				
				
				if(isInRange(2*n) && visited[2*n] == -1) {
					q.add(2*n);
					visited[2*n] = n;
					
				}
			}
			time ++;
		}
		
		StringBuilder sb = new StringBuilder();
		int idx = K;
		sb.append(K);
 		while (visited[idx] != -2) {
			sb.insert(0, visited[idx]+" ");
			idx = visited[idx];
		}
			
		System.out.println(sb.toString());
		
 		
	}
	private static boolean isInRange(int x) {
		return x >=0 && x <=100000;
	}
	

}