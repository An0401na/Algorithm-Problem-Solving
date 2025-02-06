import java.util.*;

class Solution {
    public long getTimes(int level, int[] diffs, int[] times){

        long time = 0;
        for(int i = 0; i < diffs.length; i ++){
            if(diffs[i] <= level){
                time += times[i];
            }else{
                time += (diffs[i]-level)*(times[i] + times[i-1])+times[i];
            }
        }
        return time;
        
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int len = diffs.length;
        
        int maxDiff = 0;
    
        for(int i = 0; i < diffs.length; i ++){
            maxDiff = Math.max(maxDiff, diffs[i]);
        }
        
        int s = 0;
        int e = maxDiff;
        while(s < e-1){
        
            int mid = (s + e)/2;
            
            // System.out.println("s : " + s +", e : " + e +", mid : " + mid);
            // System.out.println("소요시간 : "+getTimes(mid, diffs, times));
            if(limit < getTimes(mid, diffs, times)){
                // System.out.println("시간 넘김");
                s = mid;
            }else{
                // System.out.println("시간 안넘김");
                e = mid;
            }
        }
        
        int answer = e;
        return answer;
   }
}