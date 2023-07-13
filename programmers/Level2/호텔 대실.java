import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String o1[], String o2[]) {
                return o1[0].compareTo(o2[0]);
            }
        });
        
        ArrayList<Integer> room = new ArrayList<>();
        
        loop: for (int t = 0; t < book_time.length; t++) {
            
            int start = Integer.parseInt(book_time[t][0].substring(0, 2)) * 60 + 
                Integer.parseInt(book_time[t][0].substring(3));
            
            int end = Integer.parseInt(book_time[t][1].substring(0, 2)) * 60 + 
                Integer.parseInt(book_time[t][1].substring(3)); 
            
            if (room.size() == 0) {
                room.add(end + 10);
                continue loop;
            }
            
            for (int i = 0; i < room.size(); i++) {
                if (room.get(i) <= start) {
                    room.set(i, end + 10);
                    continue loop;
                }
            }
        
            room.add(end + 10);

        }
        
        int answer = room.size();
        return answer;
    }
}