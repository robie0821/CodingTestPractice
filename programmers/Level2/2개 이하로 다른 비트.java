class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int t = 0; t < numbers.length; t++) {
            if (numbers[t] % 2 == 0) {
                answer[t] = numbers[t] + 1;
            } else {
                String str = convert(numbers[t]);
                
                for (int i = str.length() - 2; i >= 0; i--) {
                    if (str.substring(i, i+1).equals("0")) {
                        str = str.substring(0, i) + "10" + str.substring(i + 2);
                        answer[t] = reconvert(str);
                        break;
                    }
                }
                
            }
        }
        return answer;
    }
    
    public String convert(long num) {
        String str = "";
        while(num >= 1) {
            long temp = num % 2;
            num = num / 2;
            str = String.valueOf(temp) + str;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i,i+1).equals("0")) {
                return str;
            }
        }
        return "0" + str;
    }
    
    public long reconvert(String str) {
        long sum = 0;
        for(int i = 0; i < str.length(); i++) {
            if (str.substring(i, i+1).equals("1")) {
                sum += (long)Math.pow(2, str.length() - i - 1);
            }
        }
        return sum;
    }
}