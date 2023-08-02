import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int board[][];
	static int input[];
	static int row[] = new int[5];
	static int col[] = new int[5];
	static int diag[] = new int[2];
	static int bingo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[26][2];
		input = new int [26];
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int n = Integer.parseInt(st.nextToken());
				board[n][0] = i;
				board[n][1] = j;
			}
		}
		
		int idx = 1;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				input[idx++] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= 25; i++) {
			int n = input[i];
			int r = board[n][0];
			int c = board[n][1];
			if((++row[r]) == 5) {
				if((++bingo) == 3) {
					System.out.println(i);
					return;
				}
			}
			
			if((++col[c]) == 5) {
				if((++bingo) == 3) {
					System.out.println(i);
					return;
				}
			}
			
			if(r == c) {
				if((++diag[0]) == 5) {
					if((++bingo) == 3) {
						System.out.println(i);
						return;
					}
				}
			}
			
			if(r + c == 4) {
				if((++diag[1]) == 5) {
					if((++bingo) == 3) {
						System.out.println(i);
						return;
					}
				}
			}
			
		}
		
	}
}