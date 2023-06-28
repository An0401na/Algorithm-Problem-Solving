import java.awt.Frame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static ArrayList<Integer> graph[];
	static boolean visited[];
	static int indegree[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		indegree = new int[N+1];
		for (int i = 1; i <=M; i++) {
			String temp[] = br.readLine().split(" ");
//			System.out.println(Arrays.toString(temp));
			for (int j = 2; j < temp.length ; j++) {
				int start = Integer.parseInt(temp[j-1]);
				int end = Integer.parseInt(temp[j]);

				graph[start].add(end);
				indegree[end]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		visited=new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.add(i);
				visited[i] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int singer = q.poll();
			
			for (int s : graph[singer]) {
				indegree[s]--;
			}
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && indegree[i] == 0) {
					q.add(i);
					visited[i] = true;
				}
			}
			
			sb.append(singer).append("\n");
		}
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				System.out.println(0);
				return;
			}
			
		}
		System.out.println(sb.toString());
		
	}

}