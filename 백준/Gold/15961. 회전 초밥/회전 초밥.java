import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; //접시의 수
	static int d; //초밥의 가짓수
	static int k; //연속해서 먹는 접시의 수
	static int c; //쿠폰번호
	
	static int[] sushi; //초밥 순서 리스트
	static int max; //최대 초밥 가짓수
	static int count; //현재 단계의 초밥 가짓수
	static int[] visited; //먹은 초밥의 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[N];
		visited = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		visited[c]++;
		count++;
		
		for (int i = 0; i < k; i++) {
			if(visited[sushi[i]]==0) {
				count++;
			}
			visited[sushi[i]]++;
		}
		
		max = count;
		
		for (int i = k; i < N +k-1; i++) {
			visited[sushi[(i-k)%N]]--;
			if(visited[sushi[(i-k)%N]] == 0) {
				count--;
			}
			if(visited[sushi[i%N]] == 0) {
				count++;
			}
			visited[sushi[i%N]]++;

			max = Math.max(max, count);
			if(max == k+1) {
				System.out.println(max);
				return;
			}
			
		}
		System.out.println(max);
		
	}

}