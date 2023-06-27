import java.util.*;
class Solution {
    public String solution(int a, int b) {
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(1,31);
        map.put(2,29);
        map.put(3,31);
        map.put(4,30);
        map.put(5,31);
        map.put(6,30);
        map.put(7,31);
        map.put(8,31);
        map.put(9,30);
        map.put(10,31);
        map.put(11,30);
        map.put(12,31);
        
        int day = 0;
        for(int i= 1; i < a;i++){
            day += map.get(i);
        }
        day += b;
        
        day %= 7;
        
        String answer = "";
        switch(day){
                case(0):
                answer = "THU";
                break;
                case(1):
                answer = "FRI";
                break;
                case(2):
                answer = "SAT";
                break;
                case(3):
                answer = "SUN";
                break;
                case(4):
                answer = "MON";
                break;
                case(5):
                answer = "TUE";
                break;
                case(6):
                answer = "WED";
                break;
        }
        
        return answer;
    }
}