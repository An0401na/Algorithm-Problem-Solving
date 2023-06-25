import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.TextUI;

public class Main {
	static int N;
	static int M;
	static ArrayList<Integer> [] student; 
	static int[] degree;
	static boolean[] visited;
	//정렬 문제이고 요소와 요소 사이의 순서가 정해져 있으며
	//답 중 아무거나 출력해야 하는 경우에는 위상정렬을 의심해보자.
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		student = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			student[i] = new ArrayList<>();
		}
		

		degree = new int [N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start =Integer.parseInt(st.nextToken());
			int end =Integer.parseInt(st.nextToken());
			student[start].add(end);
			degree[end]++;
		}
		

		
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N+1];
		for (int i = 1; i < degree.length; i++) {
			if(degree[i] == 0) {
				q.add(i);
				visited[i] = true;
			}
		}
		
		
		while (!q.isEmpty()) {
			int n = q.poll();
			
			for (int s : student[n]) {
				degree[s]--;
			}
			
			for (int i = 1; i < degree.length; i++) {
				if(!visited[i] && degree[i] == 0) {
					q.add(i);
					visited[i] = true;
				}
			}
			
			sb.append(n).append(" ");
		}
		
		System.out.println(sb.toString());
		
		
		
	}
}