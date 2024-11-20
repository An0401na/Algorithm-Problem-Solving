import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N; // 변호사 수
    static int M; // 신뢰 관계 수
    static ArrayList<Integer>[] graph; // 변호사 간 신뢰 관계를 나타내는 그래프 (인접 리스트)
    static int parent[]; // 유니온-파인드 부모 배열
    static boolean isDefended[]; // 각 변호사가 변호를 받았는지 여부를 체크하는 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 변호사 수
        M = Integer.parseInt(st.nextToken()); // 신뢰 관계 수

        // 초기화
        parent = new int[N+1]; // 부모 배열 초기화
        isDefended = new boolean[N+1]; // 변호 받음 여부 초기화
        graph = new ArrayList[N+1]; // 그래프 초기화

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>(); // 각 변호사의 리스트 초기화
        }

        // 신뢰 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 변호사 A
            int b = Integer.parseInt(st.nextToken()); // 변호사 B
            graph[a].add(b); // B가 A를 신뢰 -> A가 B를 변호 가능
        }

        // 1단계: 단방향 간선 처리
        for (int a = 1; a <= N; a++) {
            int idx = 0;
            while (idx < graph[a].size()) {
                int b = graph[a].get(idx); // 변호사 A가 변호할 수 있는 변호사 B
                if (graph[b].contains(a)) {
                    // B도 A를 신뢰하면 양방향 간선으로 남겨둠
                    idx++;
                    continue;
                }
                //단방향 간선 처리
                // B가 A를 신뢰하지 않으면 A는 무조건 B를 변호해야함
                isDefended[b] = true; // 변호사 B는 변호를 받음
                graph[a].remove(Integer.valueOf(b)); // 단방향 간선 제거
            }
        }

        // 유니온-파인드 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i; // 초기에는 자기 자신이 루트
        }

        // 2단계: 남은 간선 (양방향 간선, 서로 신뢰(변호)) 처리
        for (int a = 1; a <= N; a++) {
            int idx = 0;
            while (idx < graph[a].size()) { // A가 변호할 수 있는 B
                int b = graph[a].get(idx++);
                graph[b].remove(Integer.valueOf(a)); // B -> A 간선 제거 (중복 확인 방지)

                if (find(a) == find(b)) { // 사이클 발견
                    isDefended[find(a)] = true; // 해당 루트는 변호받았다고 처리
                } else {
                    // 유니온-파인드로 병합
                    if (isDefended[b]) union(b, a); // B가 이미 변호받았다면 B -> A로 병합 B가 A를 변호
                    else union(a, b); // 그렇지 않으면 A -> B로 병합
                }
            }
        }

        // 3단계: 모든 변호사가 변호를 받았는지 확인
        for (int i = 1; i <= N; i++) {
            if (!isDefended[find(i)]) { // 변호를 받지 못한 변호사가 있다면
                System.out.println("NO");
                return; // "NO" 출력 후 종료
            }
        }

        // 모든 변호사가 변호받았다면
        System.out.println("YES");
    }

    // 유니온-파인드의 find 함수: 루트 노드를 찾음 (경로 압축 포함)
    public static int find(int x) {
        if (parent[x] == x) return x; // 자기 자신이 루트면 반환
        return parent[x] = find(parent[x]); // 루트를 찾아 경로 압축
    }

    // 유니온-파인드의 union 함수: 두 집합을 병합
    public static void union(int a, int b) {
        a = find(a); // A의 루트 찾기
        b = find(b); // B의 루트 찾기
        if (a == b) return; // 이미 같은 집합이면 병합하지 않음
        parent[b] = a; // B의 루트를 A로 설정
    }
}