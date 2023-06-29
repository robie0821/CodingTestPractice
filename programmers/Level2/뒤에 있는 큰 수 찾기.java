import java.util.Stack;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<List<Integer>> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            if (!stack.empty()) {
                while (!stack.empty() && stack.peek().get(0) < numbers[i]) {
                    List<Integer> arr = stack.pop();
                    answer[arr.get(1)] = numbers[i];
                }
            }
            stack.push(Arrays.asList(numbers[i], i));
        }
        
        while (!stack.empty()) {
            List<Integer> arr = stack.pop();
            answer[arr.get(1)] = -1;
        }
        
        return answer;
    }
}