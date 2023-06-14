class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        loop: for (int i = arr[arr.length - 1]; ; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i % arr[j] != 0) {
                    continue loop;
                }
            }
            answer = i;
            break;
        }
        
        return answer;
    }
}