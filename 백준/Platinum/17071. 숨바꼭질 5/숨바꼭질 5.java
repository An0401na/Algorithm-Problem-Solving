import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final boolean SUBIN = true;
	static final boolean DONGSAENG = false;
	static int N;
	static int K;
	static int time = 0;
	static int evenVisited[]; // 위치 n을 방문한 시간이 짝수 시간일때 최초 방문 시간
	static int oddVisited[]; //위치 n을 방문한 시간이 홀수 시간일때 최조 방문 시간
	static boolean meet;
	static class Person{
		boolean isSubin;
		int x; // 위치 
		
		
		public Person(boolean isSubin, int x) {
			super();
			this.isSubin = isSubin;
			this.x = x;
		}

		@Override
		public String toString() {
			return "[ "+(isSubin ? "수빈, ": "동생, ")+ x +  " ]";
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K) {
			System.out.println(0);
			return;
		}
		evenVisited = new int [500001];
		Arrays.fill(evenVisited, -1);
		oddVisited = new int [500001];
		Arrays.fill(oddVisited, -1);
		
		Queue<Person> q = new LinkedList<>();
		
		q.add(new Person(DONGSAENG, K));
		q.add(new Person(SUBIN, N));
		
		int dongsaengIdx = K;
		Loop1 : while (!q.isEmpty()) {
			Person p = q.poll();
			if(p.isSubin) {// 수빈이가 다음 이동할 위치를 지정할 차례이면

				// 현재 위치의 -1, +1 *2 이동할 위치를 계산해서
				int nextList[] = {p.x -1, p.x+1, p.x*2};
				
				for (int next : nextList) {
					//다음 위치가 범위밖을 벗어나면 넘김
					if(next < 0 || 500000 < next) continue;
					
					if(time % 2 == 0 ) { //현재 시간이 짝수
						if (evenVisited[next] == -1) {
							evenVisited[next] = time;
							q.add(new Person(SUBIN, next));
						}
					}else { //현재 시간이 홀수
						if (oddVisited[next] == -1) {
							oddVisited[next] = time;
							q.add(new Person(SUBIN, next));
						}
					}
					
					// 그 위치에 동생이 있는지 확인
					// 있다면 탐색 끝
					if(next == dongsaengIdx) {
						meet = true;
						break Loop1;
					}
					
					
				}
				
			}else { // 동생이 다음 이동할 위치를 지정할 차례이면
				
				// 다음 차례의 수빈이가 도달해야할  동생 위치(dongsaengIdx)을 다음 위치로 변경
				dongsaengIdx = p.x + time +1;
				// 동생이 다음 이동할 위치를 큐에 넣음 현재위치 + time +1;
				if(dongsaengIdx > 500000) {
					time =-1; //범위가 넘어가면 동생 못만남
					break;
				}
				time ++; // 탐색 시간을 증가
				if(time % 2 == 0) { 
					//동생으로 dongsaengIdx에 방문한 시간이 짝수이면
					if(evenVisited[dongsaengIdx] != -1) {
						// 수빈이가 그 위치에 짝수시간에 방문한 적이 있는지 확인 있다면
						meet = true;
						break;
					}
				}else {
					//동생으로 dongsaengIdx에 방문한 시간이 홀수이면
					if(oddVisited[dongsaengIdx] != -1) {
						// 수빈이가 그 위치에 홀수시간에 방문한 적이 있는지 확인 있다면
						meet = true;
						break;
					}
				}
			
				
				q.add(new Person(DONGSAENG,dongsaengIdx));
			}
		}
		
		if(meet) {
			System.out.println(time);
		}else {

			System.out.println(-1);
		}
		
		
	}
}