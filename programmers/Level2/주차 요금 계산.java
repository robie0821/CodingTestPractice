import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<Integer, Integer> time = new HashMap<>();
        HashMap<Integer, Integer> total = new HashMap<>();
        HashMap<Integer, Integer> cost = new HashMap<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] temp = records[i].split(" ");
            int parkTime = trans(temp[0]);
            int carNum = Integer.valueOf(temp[1]);
            
            switch(temp[2]) {
                case "IN":
                    time.put(carNum, parkTime);
                    break;
                case "OUT":
                    parkTime = parkTime - time.remove(carNum);
                    if (total.containsKey(carNum)) {
                        total.put(carNum, total.get(carNum) + parkTime);
                    } else {
                        total.put(carNum, parkTime);
                    }
                    break;
            }
        }
        
        if (!time.isEmpty()) {
            for (int key : time.keySet()) {
                int parkTime = 1439 - time.get(key);
                
                if (total.containsKey(key)) {
                    total.put(key, total.get(key) + parkTime);
                } else {
                    total.put(key, parkTime);
                }
            }
        }
        
        for (int key : total.keySet()) {
            int parkTime = total.get(key);
            if (parkTime <= fees[0]) {
                cost.put(key, fees[1]);
            } else {
                int temp = fees[1] + (int) Math.ceil((parkTime - fees[0]) / (double) fees[2]) * fees[3];
                cost.put(key, temp);
            }
        }
        
        int index = 0;
        int[] arr = new int[cost.size()];
        for (int key : total.keySet()) {
            arr[index] = key;
            index++;
        }
        
        Arrays.sort(arr);
        
        index = 0;
        int[] answer = new int[cost.size()];
        for (int key : arr) {
            answer[index] = cost.get(key);
            index++;
        }
        
        
        return answer;
    }
    
    public int trans(String time) {
        String[] arr = time.split(":");
        return Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
    }
}