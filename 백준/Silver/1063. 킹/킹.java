import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Point {
		int row;
		int col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}
		
	}

	static Point king;
	static Point stone;
	static int N;
	static int dir[][] = {{0, 1},{0,-1},{1,0},{-1,0},{-1,1},{-1,-1},{1,1},{1,-1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String kingPoint = st.nextToken();
		String stonePoint = st.nextToken();
		N = Integer.parseInt(st.nextToken());

		int row = 8-((int) kingPoint.charAt(1)-48);
		int col = (int) kingPoint.charAt(0) - 65;
		king = new Point(row, col);

		row = 8-((int) stonePoint.charAt(1)-48);
		col = (int) stonePoint.charAt(0) - 65;
		stone = new Point(row, col);

		for (int i = 0; i < N; i++) {
			String op = br.readLine();
			int d = -1;
			switch (op) {
			case "R": {
				d = 0;
				break;
			}
			case "L": {
				d = 1;
				break;
			}
			case "B": {
				d = 2;
				break;
			}
			case "T": {
				d = 3;
				break;
			}
			case "RT": {
				d = 4;
				break;
			}
			case "LT": {
				d = 5;
				break;
			}
			case "RB": {
				d = 6;
				break;
			}
			case "LB": {
				d = 7;
				break;
			}
			}
			int krow = king.row+dir[d][0];
			int kcol = king.col+dir[d][1];
			if(isRange(krow, kcol)) {
				if(krow == stone.row && kcol == stone.col) {
					int srow = stone.row+dir[d][0];
					int scol = stone.col+dir[d][1];
					if(isRange(srow, scol)) {
//						System.out.println("둘다 바뀜");
						king.row = krow;
						king.col = kcol;
						stone.row = srow;
						stone.col = scol;
					}else {
//						System.out.println("돌이 범위를 넘어서 패스");
					}
				}else {
//					System.out.println("킹만 바뀜");
					king.row = krow;
					king.col = kcol;
				}
			}else {
//				System.out.println("킹이 범위를 넘어서 패스");
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append((char)(king.col+65)).append(8-king.row).append("\n");
		sb.append((char)(stone.col+65)).append(8-stone.row).append("\n");
		System.out.println(sb.toString());
	}

	private static boolean isRange(int r, int c) {
		return r >=0 && r < 8 && c >=0 && c < 8;
	}

}