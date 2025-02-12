import java.util.*;
class Solution {    
    public int solution(int[][] sizes) {
        
        for(int i = 0 ; i < sizes.length; i++){
            Arrays.sort(sizes[i]);
        }
        
        int r = 0;
        int c = 0;
        for(int i = 0 ; i < sizes.length; i++){
            r = Math.max(r, sizes[i][0]);
            c = Math.max(c, sizes[i][1]);
        }
    
        return r * c;
    }
}