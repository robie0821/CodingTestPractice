import java.util.HashMap;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        int x = 0, y = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            switch(dirs.substring(i, i+1)) {
                case "U":
                    if (y < 5) {
                        String U1 = String.valueOf(x) + "-" + String.valueOf(y) + "-" + "U";
                        String U2 = String.valueOf(x) + "-" + String.valueOf(y + 1) + "-" + "D";
                        y++;
                        if (!map.containsKey(U1)) {
                            map.put(U1, 1);
                            map.put(U2, 1);
                            answer++;
                        }
                    }
                    break;
                case "D":
                    if (y > -5) {
                        String D1 = String.valueOf(x) + "-" + String.valueOf(y) + "-" + "D";
                        String D2 = String.valueOf(x) + "-" + String.valueOf(y - 1) + "-" + "U";
                        y--;
                        if (!map.containsKey(D1)) {
                            map.put(D1, 1);
                            map.put(D2, 1);
                            answer++;
                        }
                    }
                    break;
                case "R":
                    if (x < 5) {
                        String R1 = String.valueOf(x) + "-" + String.valueOf(y) + "-" + "R";
                        String R2 = String.valueOf(x + 1) + "-" + String.valueOf(y) + "-" + "L";
                        x++;
                        if (!map.containsKey(R1)) {
                            map.put(R1, 1);
                            map.put(R2, 1);
                            answer++;
                        }
                    }
                    break;
                case "L":
                    if (x > -5) {
                        String L1 = String.valueOf(x) + "-" + String.valueOf(y) + "-" + "L";
                        String L2 = String.valueOf(x - 1) + "-" + String.valueOf(y) + "-" + "R";
                        x--;
                        if (!map.containsKey(L1)) {
                            map.put(L1, 1);
                            map.put(L2, 1);
                            answer++;
                        }
                    }
                    break;
            }
        }
        return answer;
    }
}