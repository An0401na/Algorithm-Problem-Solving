import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] paper;
	static int totalArea;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		paper = new int[101][101];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			coloring(r, c);
		}

		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(paper[i][j] == 1) {
					totalArea++;
				}
			}
		}
		System.out.println(totalArea);
		
	}
	private static void coloring(int r, int c) {
		for (int i = r; i < r+10; i++) {
			for (int j = c; j < c+10; j++) {
				paper[i][j] = 1;
			}
		}
	}

}