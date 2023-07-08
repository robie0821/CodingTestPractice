import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        int answer = 0;
        while (true) {
            if (sum1 == sum2) {
                break;
            }
            
            if (answer > 2 * (queue1.length + queue2.length)) {
                answer = -1;
                break;
            }
            
            if (sum1 > sum2) {
                int temp = q1.remove();
                q2.add(temp);
                sum1 -= temp;
                sum2 += temp;
                answer++;
            } else if (sum1 < sum2) {
                int temp = q2.remove();
                q1.add(temp);
                sum1 += temp;
                sum2 -= temp;
                answer++;
            }
        }
        
        return answer;
    }
}