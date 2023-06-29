class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] count = {781, 156, 31, 6, 1};
        for (int i = 0; i < word.length(); i++) {
            String temp = word.substring(i, i + 1);
            switch (temp) {
                case "A":
                    answer += count[i] * 0;
                    break;
                case "E":
                    answer += count[i] * 1;
                    break;
                case "I":
                    answer += count[i] * 2;
                    break;
                case "O":
                    answer += count[i] * 3;
                    break;
                case "U":
                    answer += count[i] * 4;
                    break;
            }
            answer++;
        }
        return answer;
    }
}