import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> que = new LinkedList<String>();

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
            if (!que.isEmpty()) {
                int size = que.size();
                que.remove(cities[i]);
                if (size != que.size()){
                    answer++;
                } else {
                    answer += 5;
                }
            } else {
                answer += 5;
            }
            
            que.add(cities[i]);
            
            if (que.size() > cacheSize) {
                que.poll();
            }
        }
        return answer;
    }
}