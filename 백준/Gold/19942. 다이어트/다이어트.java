import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N; // 식재료 개수
    static int min[]; // 최소로 얻어야 하는 영양소
    static int foodInfo[][];
    static int minCost = Integer.MAX_VALUE;
    static ArrayList<Integer> selectedFood;
    static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
        }
        foodInfo = new int [N+1][5];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                foodInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int total[] = new int[4];
        selectedFood = new ArrayList<>();
        powerset(1, 0, total);
        if(result == null){
            System.out.println(-1);
        }else{
            System.out.println(minCost);
            System.out.println(result);
        }


    }

    private static void powerset(int foodIdx, int totalCost, int[] total) {
        if(totalCost > minCost) return;
        if(foodIdx > N){
            for (int i = 0; i < 4; i++) {
                if(min[i] > total[i]) return;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < selectedFood.size(); i++) {
                sb.append(selectedFood.get(i)+" ");
            }
            if(totalCost == minCost){
                // result 의 아스키코드 - sb의 아스키코드 => 음수이면 sb가 더 크다는 뜻이니까 사전순으로 뒤여야함. 즉 바꾸지 않아도됨
                if(result != null && result.compareTo(sb.toString()) <  0)return;
            }
            minCost = totalCost;
            result = sb.toString();
            return;
        }

        selectedFood.add(foodIdx);
        for (int i = 0; i < 4; i++) {
            total[i] += foodInfo[foodIdx][i];
        }
        powerset(foodIdx+1, totalCost+foodInfo[foodIdx][4], total);


        selectedFood.remove(selectedFood.size()-1);
        for (int i = 0; i < 4; i++) {
            total[i] -= foodInfo[foodIdx][i];
        }
        powerset(foodIdx+1, totalCost, total);

    }

}