import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int CONNECT = 1;
	static int G; //게이트의 수 
	static int P; //비행기의 수 
	static int gate[]; //각 비행기가 1번부터 몇번까지 
	static int parent[];
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		

		gate = new int[P];
		
		for (int i = 0; i < P; i++) {
			gate[i] = Integer.parseInt(br.readLine());
		}
		
		parent = new int [G+1]; //1~i번째 도킹을 허용하는 비행기가 들어왓을때
		//1~i번째 게이트중 연결할 수 있는 가장 큰 번호를 가지는 게이트 번호를 기록한다.
		for (int i = 1; i < G+1; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < P; i++) {
			if(find(gate[i]) == 0) {
				break;
			}
			
//			System.out.println("======유니온 호출 전 ");
//			System.out.println(Arrays.toString(parent));
			
//			union(find(gate[i]), find(gate[i])-1);
			int p = find(gate[i]);
			parent[p] = find(p-1);

//			System.out.println("======유니온 끝나고 ");
//			System.out.println(Arrays.toString(parent));
			
			count ++;
//			System.out.println("=========="+i+"번째 비행기 : "+gate[i]+"========");
//			System.out.println(Arrays.toString(parent));
		}
		
		System.out.println(count);	
	}
	
	static void union(int x, int y) {
		System.out.println("======유니온 안에서 ");
		System.out.println(Arrays.toString(parent));
		
		parent[find(x)] = find(y);
		
		
	}

	//부모를 찾으며 경로 압축
	static int find(int x) {
		if(x == parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}

}