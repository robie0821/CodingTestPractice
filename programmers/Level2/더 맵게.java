import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            que.add(scoville[i]);
        }
        
        while (true) {
            if (que.peek() < K) {
                if (que.size() == 1) {
                    return -1;
                }
                // int min = que.poll();
                // int min2 = que.poll();
                que.add(que.poll() + que.poll() * 2);
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}