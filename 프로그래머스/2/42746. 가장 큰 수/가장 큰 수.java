import java.util.*;

class Solution {
        public String solution(int[] numbers) {
            String nums[] = new String[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                nums[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(nums,(o1, o2) -> {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            });

//            System.out.println(Arrays.toString(nums));

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                if(i == 0 && nums[0].equals("0")) return "0";
                answer.append(nums[i]);
            }
            return answer.toString();
        }
}