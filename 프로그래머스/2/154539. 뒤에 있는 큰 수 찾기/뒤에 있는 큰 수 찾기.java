
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

class Number {
    int idx;
    int num;
    public Number(int idx, int num){
        this.idx = idx;
        this.num = num;
    }
}
class Solution {
    public int[] solution(int[] numbers) {
            int[] answer =  new int[numbers.length];
            Arrays.fill(answer, -1);
            Stack<Number> st = new Stack<>();

            for(int i = 0; i < numbers.length; i++){
                while (true){
                    if(st.size() == 0 || st.peek().num >= numbers[i]){
                        break;
                    }else{
                        answer[st.pop().idx] = numbers[i];
                    }
                }
                st.push(new Number(i,numbers[i]));
            }
        
        return answer;
    }
}
