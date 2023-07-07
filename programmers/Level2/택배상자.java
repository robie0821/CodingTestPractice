import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int[] arr = new int[order.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            arr[order[i] - 1] = i;
        }
        
        
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            
            while (!stack.empty()) {
                if (stack.peek() == index) {
                    stack.pop();
                    index++;
                    answer++;
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}