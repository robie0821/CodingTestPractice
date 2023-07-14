class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int temp = storey % 10;
            
            if (temp < 5) {
                answer += temp;
            } else if (temp > 5) {
                answer = answer + 10 - temp;
                storey += 10;
            } else {
                answer += 5;
                if (storey % 100 > 50) {
                    storey += 10;
                }
            }
            
            storey = storey / 10;
        }
        return answer;
    }
}