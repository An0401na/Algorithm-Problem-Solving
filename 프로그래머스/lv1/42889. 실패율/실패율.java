import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        
        int [] count = new int[N+2];
        for(int i = 0 ; i <stages.length; i++ ){
            count[stages[i]]++;
        }
        
        double percent[] = new double[N+2];
        double user = 0.0;
        for(int i = N+1; i >=1 ; i--){
            user+= count[i];
            System.out.println(count[i]+" / "+user);
            if(user == 0){
                continue;
            }
            percent[i] = count[i]/user;
        }
        
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(percent));
        
        
        int[] answer = new int[N];
        for(int i = 0 ; i < N; i++ ){
            double max = -1.0;
            int idx = 0;
            for(int j = 1 ; j <= N; j++){
                if(max < percent[j]){
                    max = percent[j];
                    idx = j;
                }
            }
            percent[idx] = -2.0;
            answer[i] = idx;
        }
        
        return answer;
    }
}