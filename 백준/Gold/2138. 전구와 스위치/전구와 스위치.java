import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
	static final char ON = '0';
	static final char OFF = '1';
	static int N;
	static char [] nowBulbs;
	static char [] goalBulbs;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nowBulbs = br.readLine().toCharArray();
		goalBulbs = br.readLine().toCharArray();
		
		char [] nowBulbs_copy = Arrays.copyOf(nowBulbs, N);

//		System.out.println("아직 : " +  Arrays.toString(nowBulbs));
		int answer_1 = count();
//		System.out.println("후 : " +  Arrays.toString(nowBulbs));

		nowBulbs = nowBulbs_copy;
		switchOnOff(0, true);
		
//		System.out.println();
//		System.out.println("두번째  : " +  Arrays.toString(nowBulbs));
		int answer_2 = count()+1;
		int answer = Math.min(answer_1, answer_2);
//		System.out.println("후 : " +  Arrays.toString(nowBulbs));

		if (answer >= Integer.MAX_VALUE-1) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);

	}

	static int count() {
		int cnt = 0;
		for (int i = 0; i < N - 1; i++) {
			boolean side = i == N - 2 ? true : false;
			if (nowBulbs[i] != goalBulbs[i]) {
				switchOnOff(i, side);
				cnt++;
//				System.out.println(i + "번째 확인(" + (i + 1) + "번째 스위치 누름) : " + Arrays.toString(nowBulbs));
//				System.out.println("cnt : " + cnt);
			}
		}
		if (nowBulbs[N-1] == goalBulbs[N-1]) {
			return cnt;
		}
		return Integer.MAX_VALUE-1;
	}

	static void switchOnOff(int idx, boolean isSide) {
		int range = 3;
		if (isSide) {
			range = 2;
		}
		for (int i = idx; i < idx + range; i++) {
			if (nowBulbs[i] == ON) {
				nowBulbs[i]= OFF;
			} else {
				nowBulbs[i]= ON;
			}
		}
	}
}