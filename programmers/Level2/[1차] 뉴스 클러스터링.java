import java.util.HashMap;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int size = 0, inter = 0;
        
        for (int i = 0; i< str1.length() - 1; i++) {
            String sub = str1.substring(i, i + 2);
            if (val(sub)) {
                size++;
                if(!map.containsKey(sub)) {
                    map.put(sub, 1);
                } else {
                    map.put(sub, map.get(sub) + 1);
                }
            }
        }
        System.out.println("--------------------");
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String sub = str2.substring(i, i + 2);
            if (val(sub)) {
                size++;
                if (map.containsKey(sub)) {
                    inter++;
                   
                    if (map.get(sub) == 1) {
                        map.remove(sub);
                    } else {
                        map.put(sub, map.get(sub) - 1);
                    }
                }
            }
        }
        
        size -= inter;
        
        if (size == 0) {
            answer = 65536;
        } else {
            double J = (double) inter / (double) size * 65536;
            answer = (int) Math.floor(J);
        }
        
        
        return answer;
    }
    
    public boolean val (String str) {
        for (int i = 0; i < str.length(); i++) {
            if(!((str.charAt(i)>='A' && str.charAt(i)<='Z'))) {
                return false;
            }
        }
        return true;
    }
}