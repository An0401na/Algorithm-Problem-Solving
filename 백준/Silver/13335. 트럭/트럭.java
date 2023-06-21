import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int w;
	static int L;
	static int truck[];
	static Deque<Integer> bridge;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		truck = new int[n+w];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}
		//--------입력
		
		bridge = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			bridge.add(-1);
		}
		
		int time = 0;
		int sum = 0; //현재 다리 위에 있는 트럭의 무게 합
		int nextIdx = 0; //다음순서에 다리로 출발하려는 트럭의 인덱스 번호
		
		/*
		 * 다음에 다리를 건너기를 출발하려는 트럭의 인덱스를 큐에 넣는다
		 * 트럭과 트럭사이는 -1로 표기한다.
		 * 
		 */
		while (nextIdx != truck.length) {
			
			//Out
			//다리를 건너 도착하는 트럭이 있다면 다리에서 out
			int outIdx = bridge.removeFirst();
			if(outIdx != -1) {
				sum -= truck[outIdx];
			}
			
			//In
			//다음 대기하는 트럭이 다리위에 건너도 하중보다 작은지 확인 후 다리 in
			//하중보다 크다면 -1을 다리로 보냄
			if (sum + truck[nextIdx] <= L) {
				sum += truck[nextIdx];
				bridge.addLast(nextIdx);
				nextIdx++;
			}else {
				bridge.addLast(-1);
			}
			
			time++;
		}
		
		System.out.println(time);
		
	}

}