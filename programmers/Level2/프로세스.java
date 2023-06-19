import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<Integer>();
        PriorityQueue<Integer> highQue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            que.add(priorities[i]);
            highQue.add(priorities[i]);
        }
        
        while (true) {
            int max = highQue.peek();
            int now = que.peek();
            if (max == now) {
                highQue.poll();
                que.poll();
                answer++;
                if (location == 0) {
                    break;
                } else {
                    location--;
                }
            } else {
                que.add(now);
                que.poll();
                if (location == 0) {
                    location += que.size() - 1;
                } else {
                    location--;
                }
            }
        }
        
        return answer;
    }
}