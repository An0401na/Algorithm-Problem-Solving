import java.util.*;

class Solution {

        static HashSet<Integer> prime = new HashSet();
        static boolean visited[];
        static String nums;
        public int solution(String numbers) {
            nums = numbers;
            visited = new boolean[numbers.length()];

            makeNumber(0 , "");

            int answer = prime.size();
            return answer;
        }

        private void makeNumber(int depth, String number) {
            if(depth >= nums.length()){
                return;
            }

            for (int i = 0; i < nums.length(); i++) {
                if(visited[i]) continue;
                visited[i] = true;
                number = number + nums.charAt(i);
                isPrime(number);
                makeNumber(depth+1, number);
                number = number.substring(0, number.length()-1);
                visited[i] = false;
            }
        }

        private void isPrime(String number) {
            int n = Integer.parseInt(number);
            if(n == 0 || n == 1){
                return;
            }

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) {
                    return;
                }
            }

            prime.add(n);
        }
}