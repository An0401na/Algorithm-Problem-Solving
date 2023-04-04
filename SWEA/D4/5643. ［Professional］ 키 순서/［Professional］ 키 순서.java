

import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N;
	static int M;
	static ArrayList<Integer> [] adj; //키의 관계
	static boolean visited[][];
	static boolean student[]; //몇번째인지 알고 있는 학생
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			adj = new ArrayList [N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				adj[a].add(b);
			}
			for (int i = 0; i < N; i++) {
				bfs(i);
			}
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
			student = new boolean[N];
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				for (int j = 0; j < N; j++) {
					if(visited[i][j]) continue;
					if(!visited[j][i]){
						flag = false;
						break;
					}
				}
				student[i] = flag;
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				if(student[i]) {
					count++;
				}
			}
			System.out.printf("#%d %d\n", t, count);
			
		}
		
		
	}
	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		visited[num][num] =true;
		
		while (!q.isEmpty()) {
			int n = q.poll();
			for (int i = 0; i < adj[n].size(); i++) {
				int nn = adj[n].get(i);
				if(visited[num][nn]) continue;
				visited[num][nn] = true;
				q.add(nn);
			}
		}
	}
}
