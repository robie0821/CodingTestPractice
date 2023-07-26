class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];
        
        loop: for (long i = begin; i <= end; i++) {
            if (i == 1) {
                answer[(int) (i-begin)] = 0;
            } else {
                int max = 1;
                for (int j = 2; j < Math.sqrt(i)+1; j++) {
                    if (i % j == 0) {
                        max = j;
                        if(i / j <= 10000000) {
                            answer[(int) (i-begin)] = (int) (i / j);
                            continue loop;
                        }
                    }
                }
                answer[(int) (i-begin)] = max;
            }
        }
        return answer;
    }
}