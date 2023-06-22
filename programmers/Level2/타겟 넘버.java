class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public int dfs (int[] numbers, int target, int index, int sum) {
        int result = 0;
        if (index == numbers.length - 1) {
            if (sum + numbers[index] == target) {
                result++;
            }
            
            if (sum - numbers[index] == target) {
                result++;
            }
            
        } else {
            result += dfs (numbers, target, index + 1, sum + numbers[index]);
            result += dfs (numbers, target, index + 1, sum - numbers[index]);
        }
        
         return result;
    }
}