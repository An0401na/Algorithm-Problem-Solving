import java.util.*;
import java.io.*;

public class Main {
	static int M;
	static int N;
	static int[][] box;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우
	static int count=0;
	static int[] n;
	static Queue<int[]> q= new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for (int i = 0; i <N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j]=Integer.parseInt(st.nextToken());
				if(box[i][j]==1) {
					int[] one = {i,j};
					q.add(one);
				}
			}
		}
		
		
			bfs();
	}
	static void bfs() {
		if(q.isEmpty()) {
			System.out.println("-1");
			return;
		}
		while (!q.isEmpty()) {
			n = q.poll();
			
			if(box[n[0]][n[1]]==-1) {
				System.out.println("-1 만남!");
				return;
			}
			
			for (int i = 0; i < dir.length; i++) {
				int nr = n[0]+dir[i][0];
				int nc = n[1]+dir[i][1];

				boolean isRange = nr>=0 && nc>=0 && nr<N && nc<M;
				if(isRange && box[nr][nc]==0) {
					box[nr][nc] = box[n[0]][n[1]]+1;
					int[] new_n = {nr,nc};
					q.add(new_n);
				}
			}
			
		}

		if(box[n[0]][n[1]]==0) {
			System.out.println("0");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j]==0) {
					System.out.println("-1");
					return;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j]==0) {
					System.out.println("-1");
					return;
				}
			}
		}
		
		System.out.println(box[n[0]][n[1]]-1);
		return;
		
		
	}

}