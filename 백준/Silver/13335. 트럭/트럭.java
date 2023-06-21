import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
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
		
		bridge = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			bridge.add(-1);
		}
		
		int time = 0;
		int sum = 0;
		int nextIdx = 0;
		while (nextIdx != truck.length) {
			
			//Out
			int outIdx = bridge.removeFirst();
			if(outIdx != -1) {
				sum -= truck[outIdx];
			}
			
			//In
			if (sum + truck[nextIdx] <= L) {
				sum += truck[nextIdx];
				bridge.addLast(nextIdx);
				nextIdx++;
			}else {
				bridge.addLast(-1);
			}
			
			time++;
			
//			System.out.println("==== [Time] :" + time +"====");
//			System.out.println("sum : "+ sum);
//			for (Iterator<Integer> it = bridge.iterator(); it.hasNext();) {
//				System.out.print(it.next()+ " ");
//			}
//			System.out.println("\n");
		}
		
		System.out.println(time);
		
	}

}