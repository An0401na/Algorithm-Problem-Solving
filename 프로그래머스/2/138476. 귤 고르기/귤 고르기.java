import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++){
            if(map.containsKey(tangerine[i])){
                map.put(tangerine[i], map.get(tangerine[i])+1);
                continue;
            }
            map.put(tangerine[i], 1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());

        Collections.sort(keys, (v2, v1) -> (map.get(v1).compareTo(map.get(v2))));
        
        int cnt = 0;
        int answer = 0;
        for(Integer key : keys){
            if(cnt >= k){
                break;
            }
            cnt += map.get(key);
            answer++;
        }
        
        return answer;
    }
}