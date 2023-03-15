import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
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
//		System.out.println("쿠폰번호 "+ c+"번 무조건 먹었다고 처리");
//		System.out.println(Arrays.toString(visited));
		count++;
		
		for (int i = 0; i < k; i++) {
			if(visited[sushi[i]]==0) {
				count++;
			}
			visited[sushi[i]]++;
//
//			System.out.print("인덱 : [");
//			for (int j = 0; j <9; j++) {
//				System.out.print(j+", ");
//			}
//			for (int j = 9; j <visited.length; j++) {
//				System.out.print(j+",");
//			}
//			System.out.println("\n방문 : "+Arrays.toString(visited));
//			System.out.println("카운트 : " + count);
		}
		
		max = count;
//		System.out.println("맥스 : "+ max);
		
//		System.out.println();
//		System.out.println();
		
		
		for (int i = k; i < N +k-1; i++) {
//			System.out.println("=============");
			visited[sushi[(i-k)%N]]--;
//			System.out.println("i : "+ i);
//			System.out.printf("방문[스시[(%d-%d)%%%d]]\n", i, k, N);
//			System.out.printf("방문[스시[%d]]\n", (i-k)%N);
//			System.out.printf("방문[%d] => %d \n", sushi[(i-k)%N],visited[sushi[(i-k)%N]]);
//			
			if(visited[sushi[(i-k)%N]] == 0) {
				count--;
			}
//			System.out.println("이전 초밥 처리 후 카운트 : "+ count);
			if(visited[sushi[i%N]] == 0) {
				count++;
			}
//			System.out.println("먹은 초밥 처리 후 카운트 : "+ count);
			visited[sushi[i%N]]++;

//			System.out.print("인덱 : [");
//			for (int j = 0; j <9; j++) {
//				System.out.print(j+", ");
//			}
//			for (int j = 9; j <visited.length; j++) {
//				System.out.print(j+",");
//			}
			
//			System.out.println("\n방문 : "+Arrays.toString(visited));
			
			max = Math.max(max, count);
//			System.out.println("맥스 : " +max);
			if(max == k+1) {
				System.out.println(max);
				return;
			}
			
		}
		System.out.println(max);
		
	}

}