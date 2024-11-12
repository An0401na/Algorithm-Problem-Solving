import java.util.*;
class Book implements Comparable<Book>{
    int startHour;
    int startMinute;
    int endHour;
    int endMinute;
    
    public Book(int startHour , int startMinute, int endHour, int endMinute){
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute +10;
        if(this.endMinute > 59){
            this.endHour ++;
            this.endMinute -= 60;
        }
    }
                
    public int compareTo(Book o){
        if(this.startHour - o.startHour == 0){
            return this.startMinute  - o.startMinute;
        }
        return this.startHour - o.startHour;
    }
    
    public String toString(){
        return "startHour : "+startHour+"\n"+
            "startMinute : "+startMinute+"\n"+
            "endHour : "+endHour+"\n"+
            "endMinute : "+endMinute+"\n";
    }
}

class Room {
    int endHour;
    int endMinute;
    
    public Room(int endHour, int endMinute){
        this.endHour = endHour;
        this.endMinute = endMinute;
    }
    
    public String toString(){
        return "endHour : " + endHour+" endMinute : "+ endMinute;
    }
    
    public boolean canAdd(Book book){
        if(this.endHour == book.startHour){
            if(this.endMinute <= book.startMinute){
                return true;
            }
            return false;
        }
        return this.endHour < book.startHour;
    }
    
    public void addBook(Book book){
        this.endHour = book.endHour;
        this.endMinute = book.endMinute;
    }
}


class Solution {
    public int solution(String[][] book_time) {
        
        PriorityQueue<Book> pq = new PriorityQueue<>();
        
        for(int i = 0; i < book_time.length; i++){
            String start = book_time[i][0];
            String end = book_time[i][1];
            
            int startHour = Integer.parseInt(start.substring(0,2));
            int startMinute = Integer.parseInt(start.substring(3,5));
            int endHour = Integer.parseInt(end.substring(0,2));
            int endMinute = Integer.parseInt(end.substring(3,5));
            
            pq.add(new Book(startHour, startMinute, endHour, endMinute));
        }
        
        ArrayList<Room> rooms = new ArrayList<>();
        
        while(!pq.isEmpty()){
            Book book = pq.poll();
            
            boolean shouldAddRoom = true;
            for(Room room : rooms){
                if(room.canAdd(book)){
                    room.addBook(book);
                    shouldAddRoom = false;
                    break;
                }
            }
            
           if(shouldAddRoom){
               rooms.add(new Room(book.endHour, book.endMinute));
           }
        }
        
        
        int answer = rooms.size();
        return answer;
    }
    
    
}