import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static int arr[];
    static boolean visited[];
    static ArrayList<Integer> selectedNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        selectedNum = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        Collections.sort(selectedNum);
        System.out.println(selectedNum.size());
        for (int i = 0; i < selectedNum.size(); i++) {
            System.out.println(selectedNum.get(i));
        }
    }

    private static void dfs(int num, int target){
        if(arr[num] == target){
            selectedNum.add(target);
        }

        if(visited[arr[num]]) return;
        visited[arr[num]] = true;
        dfs(arr[num], target);
        visited[arr[num]] = false;
    }
}