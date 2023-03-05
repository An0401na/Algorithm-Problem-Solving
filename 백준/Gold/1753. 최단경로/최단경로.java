import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int[] distance;
    static int V, E, K;
    
    static class Edge{
        
        int v;
        int w;
        
        public Edge(int v, int w) {
            super();
            this.v = v;
            this.w = w;
        }
        
    }
    
    static List<Edge>[] adj;
    static int INF = Integer.MAX_VALUE/1000;
    static boolean[] checked;

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[V];
        for(int i=0; i<V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[s-1].add(new Edge(e-1, w));
        }
        
        distance = new int[V];
        checked = new boolean[V];
        Arrays.fill(distance, INF); //최소 경로를 찾을거기 때문에 무한대 넣어줌
        
        distance[K-1] = 0; //시작점에서 시작점까지의 경로값은 0이니까
        
        for(int i=0; i<V-1; i++) { //시작점의 정점은 출력할 필요가 없으니까 정점-1개 만큼 반복
            
            int minV = INF; //시작점에서 현재 경로까지의 최소 경로값
            int w = -1; // 끊어졌는지 끊어지지 않았는지 판별하기 위함.
            
            for(int j=0; j<V; j++) {
            	//모든 정점에서 연결되지 않은 정점 중 가장 경로값이 짧은 것을 찾음
            	//경로값이 가장 짧은 걸 찾아서 다음 정점으로 붙임
                if(!checked[j] && minV>distance[j]) {
                    minV = distance[j]; //갈수 있는 정점 중 가장 최소 경로값
                    w = j; //방문한 정점의 번호를 담음
                }
            }
            
            if(w==-1) break; //w가 -1이라면 더이상 방문할 노드가 없으니 끝내기
            
            
            checked[w] = true; //방문한 정점이 있다면 방문했다고 check
            for(Edge next : adj[w]) { 
            	//연결된 정점에서 다음으로 갈 수 있는 모든 정점에 대해서 최소 경로값을 갱신 시켜줌
            	//현재 정점까지의 경로값 + 다음 정점까지의 가중치가 시작정점에서 다음정점까지의 경로값보다 작다면 갱신
            	//이미 연결된 노드는 최소라는게 보장이 되기 때문에 다시 보지 않는다.
                if(!checked[next.v] && distance[next.v]>distance[w]+next.w) {
                    distance[next.v] = distance[w]+next.w;
                }
            }
            
        }
        
        for(int i=0; i<distance.length; i++) {
            if(distance[i]==INF) {
                System.out.println("INF");
            }
            else {
                System.out.println(distance[i]);
            }
        }
    }

}