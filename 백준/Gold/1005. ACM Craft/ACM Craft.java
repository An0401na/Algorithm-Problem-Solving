import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Guard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N;
	static int K;
	static ArrayList<Integer> graph[];
	static int time[];
	static boolean[] visited;
	static int[] indegree;
	static int goal;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			time = new int[N+1];
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			graph = new ArrayList[N+1];
			for (int i = 0; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			indegree = new int[N+1];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph[start].add(end);
				indegree[end]++;
			}
			
			goal = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new LinkedList<>();
			visited = new boolean[N+1];
			int result = 0;
//			int max = 0;
			int sum[] = new int[N+1];
			for (int i = 1; i <= N; i++) {
				if(indegree[i]==0) {
					if(i == goal) {
						sum[i] = time[i];
						q.clear();
						break;
					}else {
//						max = max < time[i] ? time[i] : max;
						sum[i] = time[i];
						q.add(i);
						visited[i] = true;
					}
				}
			}
			
//			result += max;
			while (!q.isEmpty()) {
				int size = q.size();
//				max = 0;
				Loop1: for (int i = 0; i < size ; i++) {
					int n = q.poll();
					
					for (int buliding : graph[n]) {
						sum[buliding] = sum[buliding] < time[buliding]+sum[n] ? time[buliding]+sum[n] : sum[buliding]; 
						indegree[buliding]--;
					}
					
					for (int j = 1; j <= N; j++) {
						if(indegree[j] ==0 && !visited[j] ) {
							if(j == goal) {
								q.clear();
								break Loop1;
							}else {
								q.add(j);
								visited[j] = true;
							}
						}
					}
				}
			}
			sb.append(sum[goal]).append("\n");
			
		}
		System.out.println(sb.toString());
		
		
	}

}