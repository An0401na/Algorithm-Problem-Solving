import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long answer = 0;
        Arrays.sort(times);
        // 이분탐색 기준은 모든 인원이 입국심사를 받는데 걸리는 시간
        // 1분 동안 모든 인원이 입국심사를 전부 받았나? -> X
        // 2분 동안 모든 인원이 입국심사를 전부 받았나? -> X
        // 3분 동안 모든 인원이 입국심사를 전부 받았나? -> O
        // 4분 동안 모든 인원이 입국심사를 전부 받았나? -> O
        // 5분 동안 모든 인원이 입국심사를 전부 받았나? -> O
        // 의 형태를 띄기때문에 이분탐색으로 풀이 가능
        long left = 1;
        long right = times[0] * (long)n; // 가장 오래 걸리는 경우 (심사하는데 걸리는 시간이 가장 긴 시간 * 입국신사 기다리는 사람의 수)
        long mid = (left + right)/2;
        while (left <= right){
            if(isAllPass(mid, n , times)){ // mid 시간내에 모든인원이 입국심사를 받았는지 확인
                // 받았다면 더 짧은 시간 범위를 확인
                right = mid -1 ;
                answer = mid;
            }else{
                // 못받았다면 시간을 늘려서 더 긴 시간 범위 확인
                left = mid +1;
            }
            mid = (left + right)/2;            
        }
        return answer;
    }
    public boolean isAllPass(long time, int n, int[] times){
        int pass = 0;
        for(int i = 0; i < times.length; i ++){
            pass += time/times[i];
            if(pass >= n){
                return true;
            }
        }
        return false;
    }
}