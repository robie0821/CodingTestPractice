import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> map = new HashMap<>();
        
        int len = 0;
        
        for (int i = 0; i < record.length; i++) {
            if (record[i].charAt(0) == 'E') {
                String[] arr = record[i].split(" ");
                map.put(arr[1], arr[2]);
            } else if (record[i].charAt(0) == 'C') {
                String[] arr = record[i].split(" ");
                map.put(arr[1], arr[2]);
                len++;
            }
        }
        
        String[] answer = new String[record.length - len];
        int index = 0;
        
        for (int i = 0; i < record.length; i++) {
            if (record[i].charAt(0) == 'E') {
                String[] arr = record[i].split(" ");
                if (map.containsKey(arr[1])) {
                    answer[index++] = map.get(arr[1]) + "님이 들어왔습니다.";
                } else {
                    answer[index++] = arr[2] + "님이 들어왔습니다.";
                }
            } else if (record[i].charAt(0) == 'L') {
                String[] arr = record[i].split(" ");
                if (map.containsKey(arr[1])) {
                    answer[index++] = map.get(arr[1]) + "님이 나갔습니다.";
                } else {
                    answer[index++] = arr[2] + "님이 나갔습니다.";
                }
            }
        }
        
        return answer;
    }
}