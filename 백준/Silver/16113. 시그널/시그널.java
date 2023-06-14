import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
	static int N;
	static char[][] signal;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		char[] temp = br.readLine().toCharArray();
		signal = new char[5][N / 5];
		int k = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < N / 5; j++) {
				signal[i][j] = temp[k];
				k++;
			}
		}


		if (N == 5 || N == 10) {
			System.out.println(1);
			return;
		}

		search();

		System.out.println(sb.toString());

	}

	static void search() {
		for (int i = 0; i < N / 5; i++) {
			if (signal[0][i] == '#') {
				if (isRange(0, i + 1)) {
					if (signal[0][i + 1] == '.') {
						if (signal[2][i + 1] == '#') {
							sb.append("4");
							i += 2;
						} else {
							sb.append("1");
						}
					}else {
						sb.append(search_left(0, i));
						i += 2;
					}
				}else {
					sb.append("1");
				}
				 
			}
			
		}

	}

	static int search_left(int r, int c) {
		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (signal[i][c] == '.') {
				count++;
			}
		}
		if (count == 0) {
			if (signal[2][c + 1] == '.') {
				return 0;
			} else if (signal[1][c + 2] == '.') {
				return 6;
			} else {
				return 8;
			}
		} else if (count == 1) {
			if (signal[1][c] == '.') {
				return 2;
			} else if (signal[1][c + 2] == '.') {
				return 5;
			} else {
				return 9;
			}
		} else if (count == 2) {
			return 3;
		} else {
			return 7;
		}
	}

	private static boolean isRange(int r, int c) {
		return r >= 0 && r < 5 && c >= 0 && c < N / 5;
	}
}