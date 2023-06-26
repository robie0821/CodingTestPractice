import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<List<Integer>> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            while(!stack.empty() && stack.peek().get(0) > prices[i]) {
                List<Integer> values = stack.pop();
                answer[values.get(1)] = i - values.get(1);
            }
            stack.push(Arrays.asList(prices[i], i));
        }
        
        while (!stack.empty()) {
            List<Integer> values = stack.pop();
            answer[values.get(1)] = prices.length - values.get(1) - 1;
        }
        return answer;
    }
}