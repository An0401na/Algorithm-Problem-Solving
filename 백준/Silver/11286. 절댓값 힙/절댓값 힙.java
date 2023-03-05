import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static class MyComp implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			int n1 = Math.abs(o1);
			int n2 = Math.abs(o2);
			if(n1==n2) {
				return o1-o2;
			}else {

				return n1-n2;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new PriorityQueue<>(new MyComp());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x != 0) {
				q.add(x);
			}else {
				if(q.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(q.poll());
				}
			}
	
			
		}
		
	}
}