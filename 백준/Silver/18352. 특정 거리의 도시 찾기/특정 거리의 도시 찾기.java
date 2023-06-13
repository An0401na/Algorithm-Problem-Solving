import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int K;
	static int X;
	static ArrayList<City> graph[];
	static int dist[];
	static boolean visited[];
	static class City implements Comparable<City>{
		int cityNum;
		int distance;
		
		public City(int cityNum, int distance) {
			super();
			this.cityNum = cityNum;
			this.distance = distance;
		}

		@Override
		public int compareTo(City o) {
			return this.distance - o.distance;
		}

		@Override
		public String toString() {
			return "City [cityNum=" + cityNum + ", distance=" + distance + "]";
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList [N+1];
		
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			graph[Integer.parseInt(st.nextToken())].add(new City(Integer.parseInt(st.nextToken()), 1));	
		}
		//-------- 입력
		
//		for (int i = 0; i < N+1; i++) {
//			System.out.printf("%d -> ", i);
//			for (int j = 0; j < graph[i].size(); j++) {
//				System.out.print(graph[i].get(j).cityNum);
//			}
//			System.out.println();
//		}
		
		dist = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[X] =0;
		//------ 초기화
		
		dijkstra(X);
		
		
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 1; i < N+1; i++) {
			if(dist[i] == K) {
				result.add(i);
			}
		}
		
		if(result.size() == 0) {
			System.out.println("-1");
		}else {
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
	}
	static void dijkstra(int city) {
		PriorityQueue<City> pq = new PriorityQueue();
		pq.add(new City(city, 0));
		
		while (!pq.isEmpty()) {
			int idx = pq.poll().cityNum;
			
			if(visited[idx]) continue;
			
			visited[idx] = true;
			
			for (City c : graph[idx]) {
				if(!visited[c.cityNum] && dist[c.cityNum]> dist[idx]+c.distance) {
					dist[c.cityNum] = c.distance + dist[idx];
					pq.add(new City(c.cityNum, dist[c.cityNum]));
				}
				
			}
			
		}
		
	}
}