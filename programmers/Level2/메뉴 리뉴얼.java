import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    List<String> arr = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        for (int i = 0; i < orders.length; i++) {
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = new String(temp);
        }
        Arrays.sort(orders);
       
        for (int t = 0; t < course.length; t++) {
            for (int i = 0; i < orders.length; i++) {
                com(orders[i], "", course[t], 0);
            }
            
            int max = -1;
            for (Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }
            
            for (Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && entry.getValue() == max) {
                    arr.add(entry.getKey());
                }
            }
            map.clear();
        }
        
        String[] answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    public void com(String order, String set, int len, int index) {
        for (int i = index; i < order.length(); i++) {
            String temp = set + order.charAt(i);
            if (temp.length() == len) {
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            } else {
                if (i < order.length() - 1) {
                    com(order, temp, len, i+1);
                }
            }
        }
    }
}