import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int time=-1;
	static class Status{
		int cnt;
		int temp;
		@Override
		public String toString() {
			return "Status [cnt=" + cnt + ", temp=" + temp + "]";
		}
		public Status(int cnt, int temp) {
			super();
			this.cnt = cnt;
			this.temp = temp;
		}
		
	}
	static boolean visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		Queue<Status> q = new LinkedList<>();
		
		q.add(new Status(1, 0));
		visited = new boolean[N+1][N+1];
		while (!q.isEmpty()) {
			int size = q.size();
			time ++;
			for (int i = 0; i < size; i++) {
				Status s = q.poll();
				
				if(s.cnt== N) {
					System.out.println(time);
					return;
				}
				if(s.cnt <= N && !visited[s.cnt][s.cnt]) {
					visited[s.cnt][s.cnt] = true;
					q.add(new Status(s.cnt, s.cnt)); // 클립보드에 저장					
				}
				
				if(s.cnt + s.temp <= N && s.temp <=N && s.temp != 0 && !visited[s.cnt + s.temp][s.temp]) {
					visited[s.cnt + s.temp][s.temp] = true;
					q.add(new Status(s.cnt + s.temp, s.temp)); //화면에 붙여넣기
				}
				
				if(s.cnt <= N && s.temp <=N && s.cnt != 0 && !visited[s.cnt-1][s.temp]) {
					visited[s.cnt-1][s.temp] = true;
					q.add(new Status(s.cnt-1, s.temp));
				}
			}
		}
		System.out.println(time);
		
	}

}