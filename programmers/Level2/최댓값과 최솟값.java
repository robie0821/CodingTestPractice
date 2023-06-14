class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
        
        for(int i = 0; i < arr.length; i++) {
            long temp = Long.parseLong(arr[i]);
            if(temp > max) {
                max = temp;
            }
            if(temp < min) {
                min = temp;
            }
        }
        
        String answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}