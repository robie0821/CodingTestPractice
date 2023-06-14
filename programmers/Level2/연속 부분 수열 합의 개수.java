import java.util.HashMap;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < elements.length; i++) {
            int sum = 0;
            for(int l = 0; l < elements.length; l++) {
                int index = (i + l) % elements.length;
                sum += elements[index];
                
                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}