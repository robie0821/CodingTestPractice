import java.util.*;

class Solution {
    boolean[] visit;
    public int solution(int[] cards) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        visit = new boolean[cards.length];
        
        for (int i = 0; i < cards.length; i++) {
            if (!visit[i]) {
                arr.add(search(cards, i));
            }
        }
        
        if (arr.size() == 1) {
            return 0;
        }
        
        int[] score = new int[arr.size()];
        
        for (int i = 0; i < score.length; i++) {
            score[i] = arr.get(i);
        }
        
        Arrays.sort(score);
        
        answer = score[score.length - 1] * score[score.length - 2];
        
        return answer;
    }
    
    public int search(int[] cards, int index) {
        int result = 0;
        int next = index;
        
        while (true) {
            if (visit[next]) {
                break;
            }
            visit[next] = true;
            next = cards[next] - 1;
            result++;
        }
        
        return result;
    }
}