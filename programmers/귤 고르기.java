import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[tangerine.length];
        int index = 0;
        
        Arrays.sort(tangerine);
        
        for (int i = 0; i < tangerine.length; i++) {
            if (i == 0 || tangerine[i] == tangerine[i - 1]) {
            } else {
                index++;
            }
            arr[index]++;
        }
        
        Arrays.sort(arr);
        
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max += arr[arr.length - 1 - i];
            if(max >= k) {
                answer = i + 1;
                break;
            }
        }
        
        
        return answer;
    }
}