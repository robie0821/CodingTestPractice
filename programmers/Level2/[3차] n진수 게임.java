class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        
        int max = m * (t - 1) + p;
        int num = 0;
        int len = 0;
        
        while (len < max) {
            str = str + trans(num, n);
            num++;
            len = str.length();
        }
        
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if((i + 1) % m == p % m) {
                answer = answer + str.substring(i, i+1);
                count++;
            }
            if (count == t) {
                break;
            }
        }
        return answer;
    }
    
    public String trans (int n, int k) {
        String num = "";
        if (n == 0) {
            return "0";
        }
        while (n > 0) {
            int mod = n % k;
            n = n / k;
            switch(mod) {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9:
                    num = String.valueOf(mod) + num;
                    break;
                case 10:
                    num = "A" + num;
                    break;
                case 11:
                    num = "B" + num;
                    break;
                case 12:
                    num = "C" + num;
                    break;
                case 13:
                    num = "D" + num;
                    break;
                case 14:
                    num = "E" + num;
                    break;
                case 15:
                    num = "F" + num;
                    break;
            }
            
        }
        return num;
    }
}