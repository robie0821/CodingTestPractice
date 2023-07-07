class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int min = 1000000;
        
        while (true) {
            if (sum == k) {
                if (right - left < min)
                {
                    answer[0] = left;
                    answer[1] = right;
                    min = right - left;
                }
                sum = sum - sequence[left];
                left++;
                continue;
            }
            if (sum < k) {
                if (right == sequence.length - 1) {
                    break;
                }
                sum += sequence[++right];
                continue;
            } else if (sum > k) {
                sum -= sequence[left++];
                continue;
            }
        }
        return answer;
    }
}