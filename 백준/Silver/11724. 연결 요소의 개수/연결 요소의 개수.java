import java.io.*;
import java.util.*;

public class Main {
	static int N; //정점의개수
	static int M; //간선의 개수
	static ArrayList<Integer> [] graph;
	static boolean visited[];
	static int count;	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph =  new ArrayList[N+1];
		visited =  new boolean[N+1];
		

		for (int i = 0; i < N+1; i++) {
			graph[i]= new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		count =0;
		for (int i = 1; i < N+1; i++) {
			if(visited[i]) continue;
			Queue<Integer> q= new LinkedList<>();
			q.add(i);
			visited[i] = true;
			
			while (!q.isEmpty()) {
				int n = q.poll();

				for(int j : graph[n]) {
					if(visited[j]) continue;
					q.add(j);
					visited[j] = true;
				}
			}
			count++;
		}
		System.out.println(count);
		
	}
}