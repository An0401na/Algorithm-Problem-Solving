import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> del = new ArrayList<>();
        String []temp = today.split("");
        
        int year = Integer.parseInt(temp[0]+temp[1]+temp[2]+temp[3]);
        int month = Integer.parseInt(temp[5]+temp[6]);
        int day = Integer.parseInt(temp[8]+temp[9]);
        
        for(int i = 0; i < privacies.length; i++){
            
            
            System.out.println("======"+i);
            String []privacie = privacies[i].split("");
            
            int pyear = Integer.parseInt(privacie[0]+privacie[1]+privacie[2]+privacie[3]);
            int pmonth = Integer.parseInt(privacie[5]+privacie[6]);
            int pday = Integer.parseInt(privacie[8]+privacie[9]);
        
            System.out.println(pyear+"."+pmonth+"."+pday);
  

            for(String term : terms){
                if(privacie[11].charAt(0) == term.charAt(0)){
                    int tmonth = Integer.parseInt(term.substring(2,term.length()));
                    if(tmonth >= 12){
                        pyear += tmonth/12; 
                        tmonth %= 12;
                    }
                    pmonth +=tmonth;
                    if(pmonth > 12){
                        pyear += 1;
                        pmonth %= 12;
                    }
                    System.out.println(pyear+"."+pmonth+"."+pday);
                    if(year == pyear){
                        if(month == pmonth){
                            if(day >= pday){
                                System.out.println("day");
                                del.add(i);
                            }
                        }else if(month > pmonth){
                            System.out.println("month");
                            del.add(i);
                        }
                    }else if(year > pyear){
                        System.out.println("year");
                        del.add(i);
                    }
                    break;
                }
            }
        }
        
        
        int[] answer = new int[del.size()];
        for(int i = 0; i < del.size(); i++){
            answer[i] = del.get(i)+1;
        }
        
        return answer;
    }
}