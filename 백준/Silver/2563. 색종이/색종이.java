import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
//	static class Paper{
//		int r;
//		int c;
//		
//		public Paper(int r, int c) {
//			this.r = r;
//			this.c = c;
//		}
//		
//		public String toString() {
//			return "r : "+r+" / c : "+c;
//		}
//	}
	static int N;
//	static Paper[] papers;
	static int[][] paper;
	static int totalArea;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		paper = new int[101][101];
//		papers = new Paper[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
//			papers[i] = new Paper(r, c);

			coloring(r, c);
//			totalArea += 100;
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = i+1; j < N; j++) {
//				if(checkOverlap(papers[i], papers[j])) {
//					System.out.println("겹침 ! -> " + papers[i].toString()+" , "+ papers[j].toString());
//					// 겹치는 지 확인
//					totalArea -= getOverlapArea(papers[i], papers[j]);
//				}
//			}
//		}
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(paper[i][j] == 1) {
					totalArea++;
				}
			}
		}
		
//		for (int i = 0; i < 101; i++) {
//			System.out.println(Arrays.toString(paper[i]));
//		}		
		System.out.println(totalArea);
		
	}
	private static void coloring(int r, int c) {
		for (int i = r; i < r+10; i++) {
			for (int j = c; j < c+10; j++) {
				paper[i][j] = 1;
			}
		}
	}
//	private static int getOverlapArea(Paper p1, Paper p2) {
//		int x = 10 - Math.abs(p1.r - p2.r);
//		int y = 10 - Math.abs(p1.c - p2.c);
//		System.out.println(x+" * "+y+" => " +(x*y));
//		return x*y;
//	}
//	private static boolean checkOverlap(Paper p1, Paper p2) {
//		int x = Math.abs(p1.r - p2.r) ;
//		int y = Math.abs(p1.c - p2.c);
//		if(x < 10 && y < 10) return true;
//		return false;
//	}
}