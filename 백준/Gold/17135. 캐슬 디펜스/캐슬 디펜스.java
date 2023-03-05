import java.io.*;
import java.util.*;

public class Main {
	static int N; // 격자판 행
	static int M; // 격자판 열
	static int D; // 공격제한 거리
	static int[][] map;
	static ArrayList<int[]> archers; // 궁수의 열
	static int[] arc;
	static int max;
	static int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static class e{
		int r;
		int c;
		

		public e(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}


		@Override
		public int hashCode() {
			return Objects.hash(c, r);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			e other = (e) obj;
			return c == other.c && r == other.r;
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		
		map = new int[N + 1][M];
		for (int i = N; i >= 1; i--) {
			// 성이 위로가고 적의 방향이 위로가도록 설정(적의 이동이 편하기 위해서)
			// 0번째 행에는 궁수가 위치
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//	printmap(map);

		/*
		 * 궁수를 놓을 수 있는 모든 경우를 다 찾음
		 * 
		 */

		archers = new ArrayList<>();
		arc = new int[3];
		combi(0, 0);

		/*
		 * 제거 대상 우선순위 1. 공격 제한 거리 안의 가장 가까운 적 2. 여럿이면 가장 왼쪽의 적 3. 궁수 A와 궁수 B의 가장 가까운 적이
		 * a로 같다면 둘다 a로 공격
		 */

		/*
		 * 궁수들을 배치할 케이스 마다 각 궁수들이 한턴에 제거할 적을 찾고 removeE에 담은 후 동시에 제거해서 케이스 별로 죽일 수 있는 적의
		 * 수를 센다음 가장 큰 값을 찾는다.
		 */
		max = 0;
		
		HashSet<e> removeE = new HashSet<>();
		for (int i = 0; i < archers.size(); i++) {
//			System.out.println( "=========="+Arrays.toString(archers.get(i))+"==========");
			int[][] copymap = new int[N+1][M];
			for (int j = 0; j < N+1; j++) {
				copymap[j] = Arrays.copyOf(map[j], map[j].length);
			}
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 3; k++) {
					int e[] = remove(copymap,j, archers.get(i)[k]);
//					System.out.println(e[0]+ " "+ e[1] +" " + j +" "+archers.get(i)[k]);
					if(!(e[0]==j && e[1]==archers.get(i)[k])) {
						removeE.add(new e(e[0], e[1]));
						//	System.out.println("size : " +removeE.size());
					}
				}
				// 죽일 적을 다 찾아낸 후 동시에 제거해야하기 때문에 따로 처리
				cnt += removeE.size();
				Iterator<e> iter = removeE.iterator();
				while (iter.hasNext()) {
					e n = iter.next();
					copymap[n.r][n.c] = 0; // 적제거
					//	printmap(copymap);
				}
				removeE.clear();
				//System.out.println("CNT : "+cnt);
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);

	}

	/*
	 * 각 궁수의 위치에서 거리가 1 ~ 제한 거리 일때까지 반복문을 돌려서 적이 나오면 break;
	 */
	static int[] remove(int[][] copymap, int r, int c) {
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {r, c});
		int dis = 1;
		while (!q.isEmpty()) {
			if(dis > D) {
				break;
			}
			int size = q.size();
			for (int j = 0; j < size; j++) {
				int n[] = q.poll();
				for (int d = 0; d < dir.length; d++) {
					int nr = n[0]+dir[d][0];
					int nc = n[1]+dir[d][1];
					if(isRange(nr,nc) ) {
						if(copymap[nr][nc] ==1 && nr > r ) {
							return new int[] {nr, nc};
						}
						q.add(new int[] {nr,nc});
					}
				}
			}
			dis++;
		}
		
		return new int[] {r,c};
	}

	static boolean isRange(int nr, int nc) {
		return nr >=0 && nc >= 0 && nr < N+1 && nc < M;
	}

	static void combi(int cnt, int start) {
		if (cnt == 3) {
			archers.add(Arrays.copyOf(arc, 3));
			return;
		}
		for (int i = start; i < M; i++) {
			arc[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

	static void printmap(int[][] copy) {
		System.out.println("----------------");
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf(copy[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------");

	}

}