import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        String[] arr = s.substring(2, s.length() - 2).split("\\},\\{");
        for (int i = 0; i < arr.length; i++) {
            String[] str = arr[i].split(",");
            for (int j = 0; j < str.length; j++) {
                int key = Integer.parseInt(str[j]);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
        }
        
        List<Entry<Integer, Integer>> list_entries = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
            
            Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
                public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2)
                {
                    return obj2.getValue().compareTo(obj1.getValue());
                }
            });
        int[] answer = new int[0];
        for(Entry<Integer, Integer> entry : list_entries) {
            int[] temp = new int[answer.length + 1];
            for(int i = 0; i < answer.length; i++) {
                temp[i] = answer[i];
            }
            temp[temp.length - 1] = entry.getKey();
            answer = temp;
        }
        
        return answer;
    }
}