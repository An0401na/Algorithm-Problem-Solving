class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;


        int[] queue = new int[len *2];
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < len; i++) {
            // queue1 + queue2 형태로 배열 합치기
            queue[i] = queue1[i];
            queue[i + len] = queue2[i];

            // queue1 과 queue2 합계 구하기
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        int answer = 0;
        int start1 = 0;
        int start2 = len;
        boolean isFirst1 = true; // start들이 돌아서 제자리로 돌아오면 같아질수 없는 경우이며 이를 체크하기 위한 boolean 값
        boolean isFirst2 = true;
        while (start1 != start2){
            if((!isFirst1 && start1 == 0) || (!isFirst2 && start2 == len)){
                answer = -1;
                break;
            }
            if(sum1 < sum2){ // queue2에서 빼서 queue1으로 넣기 -> start2을 오른쪽으로 이동
                sum2 -= queue[start2];
                sum1 += queue[start2];
                // start2 다음이 없다면 맨 앞으로 이동
                if(start2+1 == queue.length){
                    start2 = 0;
                }else{
                    start2++;
                    isFirst2 = false;
                }

            }else if(sum1 > sum2){ // queue1에서 빼서 queue2으로 넣기 -> start1을 오른쪽으로 이동
                sum1 -= queue[start1];
                sum2 += queue[start1];
                // start1 다음이 없다면 맨 앞으로 이동
                if(start1+1 == queue.length){
                    start1 = 0;
                }else{
                    start1++;
                    isFirst1 = false;  
                }

            }else{ // sum1 == sum2
//                 System.out.println("같아짐 : " + sum1 +" == "+ sum2);
//                 int p = start1;
//                 System.out.println("queue1 : ");
//                 while (p != start2){
//                     System.out.print(queue[p++]);
//                     if(p ==  queue.length) p = 0;
//                 }

//                 p = start2;
//                 System.out.println();
//                 System.out.println("\nqueue2 : ");
//                 while (start1 != p){
//                     System.out.print(queue[p++]);
//                     if(p ==  queue.length) p = 0;
//                 }
//                 System.out.println();
                break;
            }
            answer++;
        }

        if(sum1 != sum2){
            answer = -1;
        }


        return answer;
    }
}