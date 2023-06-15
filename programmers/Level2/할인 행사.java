import java.util.HashMap;

class Solution {
    
    HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        loop: for (int t = 0; t < discount.length - 9; t++) {
            init(want, number);
            for (int i = 0; i < 10; i++) {
                String key = discount[t + i];
                if(!map.containsKey(key)) {
                    continue;
                } else {
                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
                }
            }
            if(map.isEmpty()) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    public void init(String[] want, int[] number) {
        map.clear();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
    }
}