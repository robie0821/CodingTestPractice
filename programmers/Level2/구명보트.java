import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int len = people.length;
        
        Arrays.sort(people);
        
        int index = 0;
        
        for (int i = len - 1; i >= index; i--) {
            if(people[index] + people[i] <= limit) {
                index++;
                answer++;
            } else {
                answer++;
            }
        }
            
        return answer;
    }
}