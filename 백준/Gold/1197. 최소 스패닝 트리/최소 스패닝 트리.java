import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V, E;
	static class Edge implements Comparable<Edge> {
		
		int s;
		int e;
		int w;
		
		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	static PriorityQueue<Edge> points;
	static long min;
	static int[] p;
	static int[] r;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		points = new PriorityQueue<>(); // 가중치로 비교해서 작은것 부터 나오게 되어있음
		
		p = new int[V+1]; //가장 최상위 부모 => 처음에는 자기 자신으로 설정 
		r = new int[V+1]; //딸려있는 정점의 갯수 => 처음에는 1 (딸려 있는 수가 많을 수록 최상위 부모여서 r[?]를 비교하여 최상위 부모랑 연결된 곳을 찾는다.)
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			points.offer(new Edge(s, e, w));
		}
		
		makeSet(); // 초기화
		int cnt = 0;
		min = 0;
		
		while(cnt!=V-1) { //정점의 갯수가 V개 이니까 모든 정점을 연결하는 최소 경로를 찾으려면 간선은 총 v-1개가 연결되어야 한다.
			
			Edge edge = points.poll();
			if(union(edge.s, edge.e)) { //이 간선이 되는거니? 연결할 수 있니?
				//연결할 수 있으면 간선의 개수를 증가 , 최소 가중치에 더해준다. 
				//union이 가능하다면 최소 가중치라는 것이 보장이 된다. (왜냐면 가중치가 작은 것부터 나오기 때문에)
				cnt++; 
				min += edge.w;
			}
		}
		
		System.out.println(min);

	}

	public static boolean union(int x, int y) {
		//정점 x와 연결된 최상위 부모를 찾음
		//정점 y와 연결된 최상위 부모를 찾음 
		x = find(x);
		y = find(y);
		
		if(x==y) return false;  //최상위 부모가 같으면 이미 (간접적으로)연결되어 있으므로 연결할 수 없음.
		
		//누가 자식이 많이 딸려 있는지 비교
		if(r[x] < r[y]) { //y에 더 많이 딸려 있다면 x를 y로 합침 y <- x
			r[y] += r[x];
			p[x] = y; //즉 x의 부모를 y로 바꿈 (합침과정)
		}
		else { //x에 더 많이 딸려 있다면 y를 x로 합침 x <- y
			r[x] += r[y];
			p[y] = x;
		}
		return true;
	}

	//최상위 부모를 찾는 함수
	public static int find(int x) {
		
		//부모가 자기 자신이면 자기자신을 리턴
		if(x==p[x]) return x;
		//부모가 자기자신이 아니면 자신의 최상위 부모를 찾을때까지 재귀
		else return p[x] = find(p[x]); //자신의 부모의 부모를 찾아야함으로 find(x)가 아닌 find(p[x])
		
	}

	public static void makeSet() {
		
		for(int i=0; i<V+1; i++) {
			p[i] = i;
			r[i] = 1;
		}
		
	}

}