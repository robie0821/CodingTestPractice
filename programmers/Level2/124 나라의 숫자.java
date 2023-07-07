class Solution {
    public String solution(int n) {
        String answer = trans(n);
        
        return answer;
    }
    
    public String trans(int n) {
        String result = "";

        while (n >= 1) {
            switch(n % 3) {
                case 1:
                    result = "1" + result;
                    break;
                case 2:
                    result = "2" + result;
                    break;
                case 0:
                    result = "4" + result;
                    break;
            }
            n--;
            n = n / 3;
        }
        return result;
    }
}