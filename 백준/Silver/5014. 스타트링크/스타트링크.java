import java.awt.TexturePaint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F;
	static int S;
	static int G;
	static int U;
	static int D;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited= new boolean[F+1];
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(S);
		int cnt = 0;
		while (!q.isEmpty()) {
		
			int size = q.size();
			for(int s =0; s < size; s++) {
				int stair = q.poll();
				
				if(stair == G) {
					System.out.println(cnt);
					return;
				}
				int ns = stair + U;
				if(isInRange(ns) && !visited[ns]) {
					visited[ns] = true;
					q.add(ns);
				}
				

				ns = stair - D;
				if(isInRange(ns) && !visited[ns]) {
					visited[ns] = true;
					q.add(ns);
				}
			}
			
			cnt ++;
			
		}
		
		System.out.println("use the stairs");
		
	}
	static boolean isInRange(int ns) {
		return ns >=1 && ns <= F;
	}
}