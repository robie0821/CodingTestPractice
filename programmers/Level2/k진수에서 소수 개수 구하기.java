class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = trans(n, k);
        String[] arr = str.split("0+");
        
        loop: for(int i = 0; i < arr.length; i++) {
            long temp = Long.parseLong(arr[i]);
            if (temp == 1) {
                continue loop;
            } else {
                for (int j = 2; j < (long) Math.sqrt(temp) + 1; j++) {
                    if(temp % j == 0) {
                        continue loop;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
    
    public String trans (int n, int k) {
        String num = "";
        while (n > 0) {
            int mod = n % k;
            n = n / k;
            num = String.valueOf(mod) + num;
        }
        return num;
    }
}