import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static class Point{
		int red_r;
		int red_c;
		int blue_r;
		int blue_c;
		int count;
		public Point(int red_r, int red_c, int blue_r, int blue_c, int count) {
			super();
			this.red_r = red_r;
			this.red_c = red_c;
			this.blue_r = blue_r;
			this.blue_c = blue_c;
			this.count = count;
		}
		@Override
		public String toString() {
			return "Point [red_r=" + red_r + ", red_c=" + red_c + ", blue_r=" + blue_r + ", blue_c=" + blue_c
					+ ", count=" + count + "]";
		}
	}
	static char[][] map;
	static Queue<Point> points = new LinkedList<>();
	static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static HashSet<int[]> visited = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		
		
		int redr = 0, redc=0, bluer=0, bluec=0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'R') {
					redr =i;
					redc = j;
				}
				if(map[i][j] == 'B') {
					bluer = i;
					bluec = j;
				}
			}
		}
		
		points.add(new Point(redr, redc, bluer, bluec, 0));
		Point p = points.peek();
		visited.add(new int[] {redr, redc, bluer, bluec});

		
		while (!points.isEmpty()) {
			p = points.poll();
			redr = p.red_r;
			redc = p.red_c;
			bluer = p.blue_r;
			bluec = p.blue_c;
			
//			map[redr][redc] = 'R';
//			map[bluer][bluec] = 'B';
			
			
//			System.out.println("==========================");
//			System.out.println(p.toString());
//			print();
			
			map[redr][redc] = '.';
			map[bluer][bluec] = '.';
		
			if(p.count == 10) {
				break;
			}
			
			for (int d = 0; d < dir.length; d++) {
				
				int nstate[] = move(d, p);
//				System.out.println("d : "+d+" => "+Arrays.toString(nstate));
				if(visited.contains(nstate))continue;
				
				
				visited.add(nstate);
				points.add(new Point(nstate[0], nstate[1], nstate[2], nstate[3], p.count+1));
//				System.out.println("추가");
				
				
			}
		}
		
		System.out.println(-1);
		
		
	}
	
	

	
	static int[] move(int d, Point p) {
		int redr = p.red_r;
		int redc = p.red_c;
		int bluer = p.blue_r;
		int bluec = p.blue_c;
		while (true) {
			int nrr = redr + dir[d][0];
			int nrc = redc + dir[d][1];
			int nbr = bluer + dir[d][0];
			int nbc = bluec + dir[d][1];
			
			if(map[nrr][nrc] == '#' && map[nbr][nbc] == '#') break; // 다음 이동한 곳이 벽이면 좌표를 바꾸지 않고 멈춤
			
			if(map[nrr][nrc] == '.') { //빨간 구슬이 앞으로 갈 곳이 남아있는 경우 앞으로 전진
				redr = nrr;
				redc = nrc;
			}
			
			if(map[nbr][nbc] == '.') {
				bluer = nbr;
				bluec = nbc;
			}
			
			if(map[nbr][nbc] == 'O') { // 파란 구슬이 구멍에 빠지는 경우
				return  new int[] {p.red_r, p.red_c, p.blue_r, p.blue_c} ; //input 상태를 리턴에서 set visited에 걸리도록 함
			}
			
			if(map[nrr][nrc] == 'O' && map[nbr][nbc] == '#') { // 빨간구슬은 구멍에, 파란 구슬은 벽에 도달한 경우
				System.out.println(p.count+1);
				System.exit(0);
			}
			
		}

		if(redr == bluer && redc == bluec) {
			int red_dis = Math.abs(p.red_r - redr)+Math.abs(p.red_c-redc);
			int blue_dis = Math.abs(p.blue_r - bluer)+Math.abs(p.blue_c-bluec);
			if(red_dis > blue_dis) {
				redr -=dir[d][0];
				redc -=dir[d][1];
			}else {
				bluer -=dir[d][0]; 
				bluec -=dir[d][1];
			}
		}
		
		
		return new int[] {redr, redc, bluer, bluec} ;
	}




	static void print() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}