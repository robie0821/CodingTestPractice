import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> lmap = new HashMap<>();
        HashMap<Integer, Integer> rmap = new HashMap<>();
        
        int ltop = 0;
        int rtop = 0;
        
        for (int i = 0; i < topping.length; i++) {
            if (!rmap.containsKey(topping[i])) {
                rmap.put(topping[i], 1);
                rtop++;
            } else {
                rmap.put(topping[i], rmap.get(topping[i]) + 1);
            }
        }
        
        for (int i = 0; i < topping.length; i++) {
            if (!lmap.containsKey(topping[i])) {
                lmap.put(topping[i], 1);
                ltop++;
            } else {
                lmap.put(topping[i], lmap.get(topping[i]) + 1);
            }
            
            if (rmap.get(topping[i]) == 1) {
                rmap.remove(topping[i]);
                rtop--;
            } else {
                rmap.put(topping[i], rmap.get(topping[i]) - 1);
            }
            
            if (ltop == rtop) {
                answer++;
            }
        }
        
        return answer;
    }
}