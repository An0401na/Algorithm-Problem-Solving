import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Meeting[] meetings;
	static int count;
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
		@Override
		public int compareTo(Meeting o) {
			if(this.end - o.end == 0) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start =Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}
			
		count = 1;
		Arrays.sort(meetings);
//		for (int i = 0; i < N; i++) {
//			System.out.println(meetings[i].toString());
//		}
		int start = meetings[0].end;
		int nextMeeting = 0;
		for (int i = 1; i < N; i++) {
			if(start <= meetings[i].start) {
				start = meetings[i].end;
				count++;
			}
		}
		
		System.out.println(count);
	}
}