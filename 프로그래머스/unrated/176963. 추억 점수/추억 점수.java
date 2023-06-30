class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
       int[] answer = new int[photo.length];
        for(int k =0; k < photo.length; k++){
            String[] p = photo[k];
            int score = 0;
            for(int i = 0; i < name.length; i++){
                for(int j = 0; j < p.length; j++){
                    if(name[i].equals(p[j])){
                        score += yearning[i];
                    }
                }
            }
            answer[k] = score;
        }
        
        return answer;
    }
}