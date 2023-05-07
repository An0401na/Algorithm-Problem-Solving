import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int M;
	static int N;
	static int x;
	static int y;

	/*
	 * 문제풀이 아이디어 : x를 먼저 맞추고 y를 따라가게 하는거
	 * x를 먼저 맞춰두면 y만 신경 쓰면 된다. 그렇게 하기 위해선 1씩 증가시켜 연도를 알아낼 변수, count와 
	 * 1씩 증가시키며 y와 같은지 비교할 변수, y_num 의 초기값을 x로 두고 시작한다.
	 * 증가하는 단위는 x의 limit인 M으로 두면 y_num는 매번 M만큼 증가하고 N으로 나머지 연산을 한다.
	 * 이때 y_num가 y와 같아질 때의 count가 정답이 된다.
	 * 
	 * 좀더 쉽게 생각해보자면 count 는 두 x, y의 최소 공배수까지 +1씩 증가하는데 그 이전에 x_num이 x와 같아지는 순간은
	 * count가 1부터 M 사이, M+1 ~ 2M 사이 , 2M+1 ~ 3..이다. 즉 x_num이 1~M까지 한 턴을 돌때 x_num이
	 * 나오는 횟수는 단 한번이므로 그때 y_num도 y와 같은지 확인하는 것이다.
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			int max = M;
			int min = N;
			if (M < N) {
				max = N;
				min = M;
			}

			int LCM = (M * N) / GCD(max, min); // 최소공배수 찾기
			// x를 맞추고 시작한다고 생각하고 초기값을 x로 시작

			int x_num = x;
			int y_num = x;
			int count = x;

			if (x > y) {
				x_num = y;
				y_num = y;
				count = y;
			}
//			System.out.println("lcm(count의 맥스) :" + LCM);
			
			while (count <= LCM) {
//				System.out.println("count : " + count + " // x_num : " + x_num+" // ynum : " + y_num);
				if (x != x_num ) {
//					System.out.println("x != x_num => " + x + " != " + x_num);
					count += N; // 다음턴의 y_num==y일때 count
					x_num = (x_num + N);
					if(x_num == x)break;
					x_num%= M; // 다음 턴의 y_num == y일때 x_num의 수
					if(x == M && x_num ==0) break;
				} else if (y != y_num) {
//					System.out.println("y != y_num => " + y + " != " + y_num);
					count += M; // 다음턴의 x_num==x일때 count
					y_num = (y_num + M);
					if(y_num == y) break;
					y_num%= N; // 다음 턴의 x_num == x일때 y_num의 수
					if(y == N && y_num == 0) break;

				} else {
//					System.out.println("탈출");
					break;
				}
//				System.out.println();
			}
			
//			System.out.println("count : " + count + " // x_num : " + x_num+" // ynum : " + y_num);
			if (count > LCM) {
//				System.out.println("count > lcm => " + count + " > " + LCM);
				count = -1;
			}
			sb.append(count).append("\n");
		}

		System.out.println(sb.toString());

	}

	static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

}