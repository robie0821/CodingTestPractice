import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < 26; i++) {
            char ch = (char) (65 + i);
            map.put(String.valueOf(ch), i + 1);
        }
        
        int index = 27;
        
        loop: for (int i = 0; i < msg.length(); i++) {
            for (int j = 2; j < msg.length() - i + 1; j++) {
                if (!map.containsKey(msg.substring(i, i + j)) && map.containsKey(msg.substring(i, i + j - 1))) {
                    map.put(msg.substring(i, i + j), index);
                    index++;
                    
                    answer = addArray(answer);
                    answer[answer.length - 1] = map.get(msg.substring(i, i + j - 1));
                    
                    i += j - 2;
                    continue loop;
                }
            }
            answer = addArray(answer);
            answer[answer.length - 1] = map.get(msg.substring(i));
            break;
        }
        
        return answer;
    }
    
    public int[] addArray(int[] arr) {
        int[] temp = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }
}