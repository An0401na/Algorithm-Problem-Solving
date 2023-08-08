import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
//	A - 65  Z - 90
//	a =97  z - 122
	static final char EMPTY = '.';
	static final char WALL = '*';
	static final char DOCS = '$';
	static int T; //테스트 케이스 개수 
	static int R;
	static int C;
	static char[][] originMap;
	static char[][] map;
	static boolean[][] visited;
	static boolean[] hasKey;
	static ArrayList<Door>[] doors;
	static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static int docsCnt;
	static Queue<Point> q;
//	static boolean isfindedKey;
	static StringBuilder sb = new StringBuilder(); 
	

	static char check = '0';
	
	static class Point{
		int r;
		int c;
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static class Door{
		char door;
		int r;
		int c;
		
		@Override
		public String toString() {
			return "Door [door=" + door + ", r=" + r + ", c=" + c + "]";
		}

		public Door(char door, int r, int c) {
			super();
			this.door = door;
			this.r = r;
			this.c = c;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			doors = new ArrayList[26];
			for (int i = 0; i <26; i++) {
				doors[i] = new ArrayList<Door>(); 
			}
//			isfindedKey = false;
			docsCnt = 0;
			hasKey = new boolean[26];
			visited = new boolean[R+2][C+2];
			originMap = new char[R+2][C+2]; // 모든 테두리에 빈 공간을 두르기  -> 어디서든 시작해도 됨
			
			
			//지도 입력
			Arrays.fill(originMap[0], EMPTY);
			for (int i = 1; i < R+1; i++) {
				String str = EMPTY+br.readLine()+EMPTY;
				for (int j = 0; j < C+2; j++) {
					char c =  str.charAt(j);
					originMap[i][j] = c;
					if('A' <= c && c <= 'Z') {
						doors[c - 65].add(new Door(c, i, j));
					}
				}
			}
			Arrays.fill(originMap[R+1], EMPTY);
			
			
//			print(originMap);
			//열쇠 입력
			String keys = br.readLine();
//			System.out.println(keys);
			if(keys.charAt(0) !=  '0') {
				for (int i = 0; i < keys.length(); i++) {
//					System.out.println(keys.charAt(i));
					int k = keys.charAt(i) - 97;
					hasKey[k] = true;
					openDoor(k, originMap);
					
				}
			}
			
//			print(originMap);
			
			
			map = new char[R+2][C+2];
			for (int i = 0; i < R+2; i++) {
				map[i] = Arrays.copyOf(originMap[i], C+2);
			}
			
//			System.out.println("\n\n시작");
			
			q = new LinkedList<>();
			// 0,0 에서 시작해서 사방으로 나감 
			q.add(new Point(0, 0));
			visited[0][0] = true;
			
			while (!q.isEmpty()) {
//				System.out.println("docsCnt : "+ docsCnt+" ~~~~~~~~~~~~~~~~~~~~~~~~~~~`` ");
				
				
				Point p = q.poll();

//				System.out.println("방문 지점 : "+p.toString()+" => "+map[p.r][p.c]);
				
				
				// 도착한 곳이 빈공간이라면 이동
				if(map[p.r][p.c] == EMPTY) {
//					System.out.println("빈공간 : "+map[p.r][p.c]);
					
					
				}else if('A' <= map[p.r][p.c]  && map[p.r][p.c] <= 'Z') { 
					//도착한 곳이 문이라면 넘어가기
//					System.out.println("문 : "+map[p.r][p.c]);
					if(hasKey[map[p.r][p.c] - 65]) {
//						System.out.println("근데 키가 있는디요 ?");
					}
					continue;
					
					
				}else if(map[p.r][p.c] == DOCS) {
					//보고 있는 곳이 문서라면 docsCnt 증가 후 빈공간으로 바꾸기
					docsCnt++;
//					System.out.print("문서 : "+map[p.r][p.c]+" -> ");
					map[p.r][p.c] = EMPTY;
//					System.out.println(map[p.r][p.c]);
					
					
				}else if('a' <= map[p.r][p.c] && map[p.r][p.c]  <= 'z') {
					// 보고 있는 곳이 열쇠라면 hasKey에 표시 후 빈공간으로 바꾸기
//					System.out.print("열쇠 : "+map[p.r][p.c]+" -> ");
					hasKey[map[p.r][p.c]  - 97] = true;
					
					openDoor(map[p.r][p.c] - 97, map); // 그 열쇠로 열 수 있는 모든 문 빈 공간으로 바꾸기 

					map[p.r][p.c]  = EMPTY;
//					System.out.println(map[p.r][p.c]);
					// map 의 방문 배열 초기화 하기 
					visited = new boolean[R+2][C+2];
//					map = new char[R+2][C+2];
//					for (int i = 0; i < R+2; i++) {
//						map[i] = Arrays.copyOf(originMap[i], C+2);
//					}
//					check++;
					
				}
				
//				map[p.r][p.c] = check;
//				print(map);
				
				
				
				for (int d = 0; d < dir.length; d++) {
					int nr = p.r + dir[d][0];
					int nc = p.c + dir[d][1];
					
					if(isInRange(nr, nc) && !visited[nr][nc]) { //범위안에 있고 방문하지 않았다면
						visited[nr][nc] = true;
						
						//벽이 아니라면 나중에 이동할거야 
						if(map[nr][nc] != WALL) {
							q.add(new Point(nr, nc));
						}
						
					}
				}	
			}
			
			sb.append(docsCnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	
	
	private static boolean isInRange(int nr, int nc) {
		return nr>=0 && nr < R+2 && nc >= 0 && nc < C+2;
	}



	private static void openDoor(int k, char[][] map) {
		if(doors[k].size() > 0) {
			for (Door d : doors[k]) {
				map[d.r][d.c] = '.';
			}
		}
	}



	private static void print(char[][] m) {
		System.out.println("====================");
		for (int i = 0; i < R+2; i++) {
			System.out.println(Arrays.toString(m[i]));
		}
		System.out.println("====================\n");
		
	}

}