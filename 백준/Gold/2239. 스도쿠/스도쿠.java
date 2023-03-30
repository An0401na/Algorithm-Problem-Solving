import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		makeMap(0, 0);
		
		for (int i = 0; i < args.length; i++) {
			
		}

	}

	static void makeMap(int r, int c) {
		if (r == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
//			return;
		}
		if (map[r][c] != 0) {
			c++;
			if (c == 9) {
				r++;
				c = 0;
			}
			makeMap(r, c);
			return;
		}

		// 0인 경우
		for (int n = 1; n <= 9; n++) {
			if (case_row(r, n) && case_col(c, n) && case_box(r / 3 * 3, c / 3 * 3, n)) {
				map[r][c] = n;
				if (c == 8) {
					makeMap(r + 1, 0);
				} else {
					makeMap(r, c + 1);
				}
				map[r][c] = 0;
			}
		}
	}

	static boolean case_row(int r, int n) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == n) {
				return false;
			}
		}
		return true;
	}

	static boolean case_col(int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (map[i][c] == n) {
				return false;
			}
		}
		return true;
	}

	static boolean case_box(int r, int c, int n) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[r + i][c + j] == n) {
					return false;
				}
			}
		}
		return true;
	}

}