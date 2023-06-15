import java.util.Arrays;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[1];
        int[] time = new int[progresses.length];
        int index = 0;
        
        for (int i = 0; i < progresses.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0) {
                time[i] = (100 - progresses[i]) / speeds[i];
            } else {
                time[i] = (100 - progresses[i]) / speeds[i] + 1;
            }
        }
        
        int max = 0;
        for (int i = 0; i < time.length; i++) {
            if (i == 0) {
                max = time[i];
                answer[index]++;
            } else {
                if (max >= time[i]) {
                    answer[index]++;
                } else {
                    max = time[i];
                    int[] temp = Arrays.copyOf(answer, answer.length + 1);
                    answer = temp;
                    index++;
                    answer[index]++;
                }
            }
        }
        
        return answer;
    }
}