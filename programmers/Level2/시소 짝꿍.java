import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        
        for (int num : weights) {
            double x1 = num;
            double x2 = num * 2.0 / 3.0;
            double x3 = num / 2.0;
            double x4 = num * 3.0 / 4.0;
            
            if (map.containsKey(x1)) answer += map.get(x1);
            if (map.containsKey(x2)) answer += map.get(x2);
            if (map.containsKey(x3)) answer += map.get(x3);
            if (map.containsKey(x4)) answer += map.get(x4);
            
            if (map.containsKey(x1)) {
                map.put(x1, map.get(x1) + 1);
            } else {
                map.put(x1, 1);
            }
            
        }
        return answer;
    }
}