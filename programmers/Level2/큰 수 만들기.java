class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int len = number.length() - k;
        int index = 0;
        for (int t = 0; t < number.length() - k; t++) {
            char max = '0';
            for (int i = index; i < k + t + 1; i++) {
                if (number.charAt(i) == '9') {
                    max = number.charAt(i);
                    index = i;
                    break;
                }
                if (max < number.charAt(i)) {
                    max = number.charAt(i);
                    index = i;
                }
            }
            answer = answer + max;
            index++;
        }
        return answer;
    }
}