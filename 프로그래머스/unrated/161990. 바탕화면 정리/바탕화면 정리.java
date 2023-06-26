class Solution {
    public int[] solution(String[] wallpaper) {
        
        
        
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = 0;
        int rdy = 0;
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[0].length(); j++){
                if(wallpaper[i].charAt(j) =='#'){
                    lux = lux > i ? i : lux;
                    luy = luy > j ? j : luy;
                    rdx = rdx <= i ? i+1 : rdx;
                    rdy = rdy <= j ? j+1 : rdy;
                    
                }
            }
        }
        
        int[] answer = {lux, luy, rdx, rdy};
        return answer;
    }
}