import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;        
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < enemy.length; i++) {
            if (n - enemy[i] < 0) {
                if (k > 0) {
                    k--;

                    int max = 0;
                    if (!q.isEmpty()) max = q.peek();
                    
                    if (max > enemy[i]) {
                        n += q.poll();
                        n -= enemy[i];
                        q.offer(enemy[i]);
                    }
                } else {
                    answer = i;
                    break;
                }
            } else {
                n -= enemy[i];
                q.offer(enemy[i]);
            }
        }
        return answer;
    }
}