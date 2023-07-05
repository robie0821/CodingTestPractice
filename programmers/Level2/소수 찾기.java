import java.util.HashMap;

class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<>();
    
    
    public int solution(String numbers) {
        String[] arr = numbers.split("");
        int[] check = new int[arr.length];
        
        
        map.put(0,1);
        map.put(1,1);
        
        return dfs(arr, check, "");
    }
    
    public int dfs (String[] arr, int[] check, String str) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                if (prime(str + arr[i])) {
                    answer++;
                }
                answer += dfs(arr, check, str + arr[i]);
                check[i] = 0;
            }

        }
        return answer;
    }
    
    public boolean prime(String str) {
        int num = Integer.parseInt(str);
        if (map.containsKey(num)) {
            return false;
        }
        
        map.put(num, 1);
        int sqrt = (int) Math.round(Math.sqrt(num));
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}