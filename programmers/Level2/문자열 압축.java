import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int k = 1; k <= s.length()/2; k++) {
            
            ArrayList<String> str = new ArrayList<>();
            
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i == s.length() - 1) {
                    str.add(s.substring(index));
                } else {
                    if ((i+1) % k == 0) {
                        str.add(s.substring(index, i + 1));
                        index = i + 1;
                    }
                }
            }
            
            String temp = "";
            int count = 0;
            
            for (int i = 0; i < str.size(); i++) {
                if (i == str.size() - 1) {
                    if (str.get(i-1).equals(str.get(i))) {
                        temp += String.valueOf(count+1) + str.get(i);
                        count = 0;
                    } else {
                        temp += str.get(i);
                    }
                } else {
                    if (str.get(i).equals(str.get(i+1))) {
                        count++;
                    } else {
                        if (count == 0) {
                            temp += str.get(i);
                        } else {
                            temp += String.valueOf(count+1) + str.get(i);
                            count = 0;
                        }
                    }
                }
            }
            
            if (answer > temp.length()) {
                answer = temp.length();
            }
            
        }
        
        return answer;
    }
}