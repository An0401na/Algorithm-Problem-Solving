import java.util.*;

class Solution {
    // static int dir[][] = {{1,0}, {-1, 0}, {0,1},{0,-1}}
    static int board[][] = new int[101][101];
    static class Robot{
        int r;
        int c;
        int goalIdx;
        boolean isAlive;
        int[] route;
        public Robot(int r, int c, int[] route){
            this.r = r;
            this.c = c;
            goalIdx = 1;
            isAlive = true;
            this.route = route;
        }
        
        public String toString(){
            return "r : " + r +", c : "+c +", goalIdx : "+ goalIdx;
        }
    }
    static ArrayList<Robot> robots = new ArrayList<>();

    static int[][] points;
    public int solution(int[][] ps, int[][] routes) {
        points = ps;
    
        int dangerCnt = 0;
        
        for(int i = 0; i < routes.length; i++){
            int p = routes[i][0]-1;
            
            robots.add(new Robot(points[p][0], points[p][1], routes[i]));
            board[points[p][0]][points[p][1]] ++;
            if(board[points[p][0]][points[p][1]] == 2){
                dangerCnt ++;
            }
        }
        
        resetBoard();
        
        while(!robots.isEmpty()){
            for(int i = 0; i < robots.size(); i++){
                moveRobot(robots.get(i));
                if(isCrash(robots.get(i))){
                    dangerCnt ++;
                }
            }
            
            resetBoard();
            checkAlive();
        }
        
        
        
        return dangerCnt;
    }
    public boolean isCrash(Robot robot){
        if(board[robot.r][robot.c] == 2){
            return true;
        }
        return false;
    }
    public void checkAlive(){
        int i = 0;
        while(i < robots.size()){
            if(!robots.get(i).isAlive){
                robots.remove(i);
            }else {
                i++;
            }
        }
    }
    public void moveRobot(Robot robot){
        int[] route = robot.route;
        int goalPoint[] = points[route[robot.goalIdx]-1];
        int goalR = goalPoint[0];
        int goalC = goalPoint[1];
        
        if(goalR - robot.r != 0){
            if(goalR - robot.r < 0){ // 위로
                robot.r--;
            }else{ // 아래로
                robot.r++;
            }
        }else if(goalC - robot.c != 0){
            if(goalC - robot.c < 0){ // 왼쪽으로
                robot.c--;
            }else{ // 오른쪽으로
                robot.c++;
            }
        }
        
        board[robot.r][robot.c]++;
        
        if(goalR == robot.r && goalC == robot.c){
            robot.goalIdx ++;
            if(robot.goalIdx == robot.route.length){
                robot.isAlive = false;
            }
        }
        
    }
    
    public void resetBoard(){
        
        for(int i = 0; i < robots.size(); i++){
            int r = robots.get(i).r;
            int c = robots.get(i).c;
            board[r][c] = 0;
        }
        
    }
}