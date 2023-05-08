import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.MathContext;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int max;
	static Lecture lectures[];
	static class Lecture implements Comparable<Lecture>{
		int day;
		int pay;
		@Override
		public int compareTo(Lecture o) {
			if(this.pay - o.pay == 0) {
//				return (this.pay-o.pay)*-1;
				return -(this.day-o.day);
			}
			return -(this.pay - o.pay);
		}
		@Override
		public String toString() {
			return "lecture [day=" + day + ", pay=" + pay + "]";
		}
		public Lecture(int day, int pay) {
			super();
			this.day = day;
			this.pay = pay;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N == 0) {
			System.out.println(0);
			System.exit(0);
		}
		lectures = new Lecture[N];
		int spare =0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			spare = Math.max(spare, day);
			lectures[i] = new Lecture(day, pay);
			
		}
		Arrays.sort(lectures);
		int schedule[] = new int[spare+1];
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(lectures[i].toString());
//		}
		
	
		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(schedule));
 			if(schedule[lectures[i].day] != 0) {
 				for (int j = lectures[i].day-1; j >=1; j--) {
 					if(schedule[j] == 0) {
 						schedule[j] = lectures[i].pay;
 		 	 			max += lectures[i].pay;
 						break;
 					}	
				}
 			}else {
 	 			schedule[lectures[i].day] = lectures[i].pay;
 	 			max += lectures[i].pay;
 			}
 			
		}
		
		System.out.println(max);
		
		
	}

}