import java.util.HashMap;
import java.util.Set;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            String kind = clothes[i][1];
            if (map.containsKey(kind)) {
                map.put(kind, map.get(kind) + 1);
            } else {
                map.put(kind, 2);
                count++;
            }
        }
        
        Set <String> keySet = map.keySet();
        for (String key :keySet) {
            answer = answer * map.get(key);
        }
        
        return answer - 1;
    }
}