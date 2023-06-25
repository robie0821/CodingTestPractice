import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        int length = 0;
        
        String[][] arr = {};
        
        HashMap<String, String> idMap = new HashMap<>();
        
        for(int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            
            switch(temp[0]) {
                // case "Enter":
                //     idMap.put(temp[1], temp[2]);
                //     arr = addArray(arr);
                //     arr[i][0] = temp[0];
                //     arr[i][1] = temp[1];
                //     break;
                case "Leave":
                    // arr = addArray(arr);
                    // arr[i][0] = temp[0];
                    // arr[i][1] = temp[1];
                    break;
                case "Change":
                    // idMap.put(temp[1], temp[2]);
                    // break;
            }
        }
        
        String[] answer = new String[arr.length];
        
        for(int i = 0; i < answer.length; i++) {
            switch(arr[i][0]) {
                case "Enter":
                    if(idMap.containsKey(arr[i][1])) {
                        answer[i] = idMap.get(arr[i][1]) + "님이 들어왔습니다.";
                        break;
                    }
                case "Leave":
                    if(idMap.containsKey(arr[i][1])) {
                        answer[i] = idMap.get(arr[i][1]) + "님이 나갔습니다.";
                        break;
                    }
            }
        }
        
        
        return answer;
    }
    
    String[][] addArray(String[][] arr) {
        String[][] temp = new String[arr.length + 1][2];
        for (int i = 0; i < arr.length; i++) {
            temp[i][0] = arr[i][0];
            temp[i][1] = arr[i][1];
        }
        return temp;
    }
}