import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int R;
	static int Q;
	static ArrayList<Integer> []tree; //간선의 개수가 N-1개 이므로 사이클이 없고 문제 풀이를 위해  서브트리의 정점의 개수를 필요로함
	static int dp[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1];
		visited = new boolean [N+1];
		
		tree = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			tree[i]= new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			tree[u].add(v);
			tree[v].add(u);
		}
//		for (int i = 0; i < tree.length; i++) {
//			System.out.println(i);
//			
//		}
		
		dfs(R, -1);
		StringBuilder sb = new StringBuilder();
		for (int q = 0; q < Q; q++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int root, int parent) {
		visited[root] = true;
		dp[root] =1;
		
		//파라미터 root를 서브트리의 root로 하는 정점으 개수를 구하는 재귀
		for (int node : tree[root]) {
			//양방향 그래프이기 때문에 방문한 노드는 다시 재방문하지 않도록 visited 처리
//			if(visited[node]) continue;
			if(node == parent) continue;
			
			dfs(node, root); 
			dp[root]+=dp[node];
		}
	}

}