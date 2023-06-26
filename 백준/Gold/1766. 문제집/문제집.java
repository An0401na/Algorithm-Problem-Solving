import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static ArrayList<Integer>[] graph;
	static boolean []visited;
	static int indegree[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for (int i = 0; i <=N ; i++) {
			graph[i] = new ArrayList<>();
		}
		
		indegree = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph[start].add(end);
			indegree[end]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N+1];
		for (int i = 1; i <=N; i++) {
			if(indegree[i] == 0) {
				q.add(i);
				visited[i] = true;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int n = q.poll();
			
			for (int g : graph[n]) {
				indegree[g]--;
			}
			
			for (int i = 1; i <=N; i++) {
				if(indegree[i] == 0 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					break;
				}
			}
			
			sb.append(n).append(" ");
			
		}
		
		System.out.println(sb.toString());
		
	}

}