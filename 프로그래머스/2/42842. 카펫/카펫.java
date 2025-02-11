import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int r = 0;
        int c = 0;
        if(brown == 8 && yellow ==1){
            return new int[] {3, 3};
        }
        for(int i = 1; i <= yellow/2; i++){
            if(yellow % i != 0) continue;
            int yellowR = yellow/i;
            int yellowC = i;
            System.out.println(yellowR+", " + yellowC);
            
            if(yellowR *2 + yellowC*2 + 4 == brown){
                r = yellowR + 2;
                c = yellowC + 2;
                break;
            }
        }
        // int tmp = r;
        // r = Math.max(r,c);
        // c = Math.min(tmp, c);
        return new int[] {r, c};
    }
}