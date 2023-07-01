import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int limit = 0;
        int index = 0;
        
        Queue<List<Integer>> q = new LinkedList<>();
        
        while (true) {            
            if (q.size() == 0) {
                q.offer(Arrays.asList(truck_weights[index], index));
                limit += truck_weights[index];
                index++;
            } else {
                if (q.size() >= bridge_length) {
                    List<Integer> temp = q.poll();
                    limit = limit - temp.get(0);
                    if (temp.get(1) == truck_weights.length - 1) {
                        break;
                    }
                }
                
                if (index < truck_weights.length && limit + truck_weights[index] <= weight) {
                    q.offer(Arrays.asList(truck_weights[index], index));
                    limit += truck_weights[index];
                    index++;
                } else {
                    q.offer(Arrays.asList(0, 0));
                }
            }
            answer++;
        }
        
        return answer;
    }
}